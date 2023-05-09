package cn.cg.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootTest
class ZookeeperApplicationTests1 {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);
    CuratorFramework zkClient = CuratorFrameworkFactory.builder()
            // the server to connect to (can be a server list)
            .connectString("127.0.0.1:2181")
            .retryPolicy(retryPolicy)
            .build();

    /**
     * 创建节点
     *
     * @throws Exception
     */
    @Test
    void createNode() throws Exception {

        try {
            // 4.1. creatingParentsIfNeeded()可以递归创建节点
            // 4.2. withMode(CreateMode.PERSISTENT)创建持久化节点
            zkClient.start();

            String res = zkClient
                    .create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath("/client/client1/client11/client111", "clientNodeDate".getBytes());

            System.out.println("res:" + res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }
    }


    /**
     * 查询节点
     *
     * @throws Exception
     */
    @Test
    void findNode() throws Exception {

        try {
            zkClient.start();

            List<String> strings = zkClient.getChildren().forPath("/");

            System.out.println(strings.stream().collect(Collectors.joining(";")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }
    }


    /**
     * 删除节点
     *
     * @throws Exception
     */
    @Test
    void deleteNode() throws Exception {

        try {
            zkClient.start();

            zkClient.delete().deletingChildrenIfNeeded().forPath("/");
            findNode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }
    }


    /**
     * watch机制
     * 监听节点
     *
     * @throws Exception
     */
    @Test
    void watchNode() throws Exception {

        try {

            zkClient.start();

            //----------------- 监听单个节点 -----------------------------------
            //1. 创建节点数据监听对象
            final NodeCache nodeCache = new NodeCache(zkClient, "/client");

            //2. 注册监听
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                @Override
                //如果节点数据有变化，会回调该方法
                public void nodeChanged() throws Exception {
                    System.out.println("节点变化了~");
                    //获取修改节点后的数据
                    byte[] data = nodeCache.getCurrentData().getData();
                    System.out.println(new String(data));
                }
            });
            //3.开始监听0
/**
 * start参数为true：可以直接获取监听的节点，
 * System.out.println(nodeCache.getCurrentData());为ChildData {path='/aa', stat=607,765,1580205779732,1580973376268,2,1,0,0,5,1,608, data=[97, 98, 99, 100, 101]}
 * 参数为false：不可以获取监听的节点，System.out.println(nodeCache.getCurrentData());为null
 */
            nodeCache.start(true);

            //创建节点
            Stat stat = zkClient
                    .setData()
                    .forPath("/client", "修改节点".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }
        TimeUnit.SECONDS.sleep(30);


    }


    /**
     * watch机制
     * 监听子节点
     *
     * @throws Exception
     */
    @Test
    void watchChild() throws Exception {

        try {

            zkClient.start();

            //----------------- 监听单个节点 -----------------------------------
            //1. 创建节点数据监听对象
            final PathChildrenCache nodeCache = new PathChildrenCache(zkClient, "/client", true);
            //2. 注册监听
            nodeCache.getListenable().addListener(new PathChildrenCacheListener() {

                @Override
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                    System.out.println("子节点变化了~");
                    System.out.println(event);
                    //监听子节点的数据变更，并且拿到变更后的数据
                    //1.获取类型
//                    PathChildrenCacheEvent.Type type = event.getType();
                    //2.判断类型是否是update
//                    if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
//                    System.out.println("数据变了！！！");
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));
//                    }

                }
            });
            //3.开始监听0
            nodeCache.start();

            //创建节点
            Stat stat = zkClient
                    .setData()
                    .forPath("/client/client1/client11", "修改节点client11".getBytes());
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }


    }


    /**
     * watch机制
     * 监听树
     *
     * @throws Exception
     */
    @Test
    void watchTree() throws Exception {

        try {

            zkClient.start();

            //----------------- 监听单个节点 -----------------------------------
            //1. 创建节点数据监听对象
            final TreeCache nodeCache = new TreeCache(zkClient, "/client");
            //2. 注册监听
            nodeCache.getListenable().addListener(new TreeCacheListener() {

                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent event) throws Exception {
                    System.out.println("子节点变化了~");
                    System.out.println(event);
                }

            });
            //3.开始监听0
            nodeCache.start();

            //创建节点
            Stat stat = zkClient
                    .setData()
                    .forPath("/client/client1/client11", "修改节点client11".getBytes());
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkClient.close();
        }


    }


}
