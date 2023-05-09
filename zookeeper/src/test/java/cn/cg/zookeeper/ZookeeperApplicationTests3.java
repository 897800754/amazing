package cn.cg.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@SpringBootTest
class ZookeeperApplicationTests3 {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);
    CuratorFramework zkClient = CuratorFrameworkFactory.builder()
            // the server to connect to (can be a server list)
            .connectString("127.0.0.1:2181")
            .retryPolicy(retryPolicy)
            .build();

    private static int x = 0;

    /**
     * 分布式锁
     *
     * @throws Exception
     */
    @Test
    void lock() throws Exception {

        try {
            // 4.1. creatingParentsIfNeeded()可以递归创建节点
            // 4.2. withMode(CreateMode.PERSISTENT)创建持久化节点
            zkClient.start();

            InterProcessMutex lock = new InterProcessMutex(zkClient, "/abc");

            ExecutorService executorService = Executors.newFixedThreadPool(10);

            CountDownLatch countDownLatch = new CountDownLatch(1000);

            Stream
                    .iterate(0, n -> n + 1)
                    .limit(1000)
                    .forEach(seed -> {
                        //...............
                        executorService.submit(() -> {
                            try {
                                lock.acquire();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            x++;
                            countDownLatch.countDown();
                            try {
                                lock.release();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    });

            countDownLatch.await();
            System.out.println("x:" + x);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }
    }


}
