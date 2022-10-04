package test.juc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author: cg1
 * @date: 2021-08-10 14:09
 **/
public class ManagementFactoryTest {
    public static void main(String[] args) {
        //查询当前线程
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        if (threadInfos != null && threadInfos.length > 0) {
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println(threadInfo.toString());
            }
        }
    }
}
