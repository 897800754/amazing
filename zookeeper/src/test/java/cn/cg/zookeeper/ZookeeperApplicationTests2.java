package cn.cg.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class ZookeeperApplicationTests2 {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    /**
     * 创建顺序节点
     */
    @Test
    public void test2() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<String>(executorService);


        List<Callable<String>> collect = Stream.iterate(0, n -> n + 1)
                .limit(100)
                .map(x -> new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);
                        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                                // the server to connect to (can be a server list)
                                .connectString("127.0.0.1:2181")
                                .retryPolicy(retryPolicy)
                                .build();
                        try {
                            zkClient.start();

                            String res = zkClient
                                    .create()
                                    .creatingParentsIfNeeded()
                                    .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                                    .forPath("/seq", "clientNodeDate".getBytes());

                            return res;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            zkClient.close();
                        }
                        return null;
                    }
                })
                .collect(Collectors.toList());

        collect.forEach(executorCompletionService::submit);
        List<String> res = new ArrayList<>();

        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .forEach(x -> {
                    try {
                        res.add(executorCompletionService.take().get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println(res.stream().distinct().collect(Collectors.joining(",")));

        System.out.println(res.size());
    }
}
