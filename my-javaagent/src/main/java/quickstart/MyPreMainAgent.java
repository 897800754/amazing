package quickstart;

import java.lang.instrument.Instrumentation;

/**
 * @author: cg
 * @date: 2023-11-15 17:50
 **/
public class MyPreMainAgent {

    /**
     * jvm 参数形式启动,运行该方法
     *
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("preMain");
    }

//    /**
//     * 动态 attach 方法启动
//     *
//     * @param agentArgs
//     * @param instrumentation
//     */
//    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
//        System.out.println("agentmain");
//    }

}
