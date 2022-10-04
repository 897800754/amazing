package test.juc.base;

/**
 * 设置3个线程，线程名分别为ABC，按照ABC的顺序打印，重复20遍
 *
 * @author: cg1
 * @date: 2021-06-08 18:42
 **/
public class ThreadTest {

    private volatile String nextName;

    private static final String[] Dict = new String[]{"A", "B", "C"};

    public ThreadTest(String nextName) {
        this.nextName = nextName;
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest("A");

        Thread b = new Thread(new Producer(threadTest), "B");
        Thread a = new Thread(new Producer(threadTest), "A");
        Thread c = new Thread(new Producer(threadTest), "C");
        a.start();
        b.start();
        c.start();
    }

    /**
     * 生产者
     */
    public static class Producer implements Runnable {

        private volatile ThreadTest threadTest;

        private int limit = 20;

        private int current = 0;


        public Producer(ThreadTest threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            synchronized (ThreadTest.class) {
                while (current != limit) {
                    Thread thread = Thread.currentThread();
                    if (thread.getName().equals(threadTest.nextName)) {
                        //如果是下一个线程 打印
                        System.out.println(thread.getName());

                        if ("B".equals(thread.getName())) {
                            threadTest.nextName = "C";
                        } else if ("C".equals(thread.getName())) {
                            threadTest.nextName = "A";
                        }
                        if ("A".equals(thread.getName())) {
                            threadTest.nextName = "B";
                        }
                        current++;
                        //激活其他线程
                        ThreadTest.class.notifyAll();
                    } else {
                        //则睡觉
                        try {
                            ThreadTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
