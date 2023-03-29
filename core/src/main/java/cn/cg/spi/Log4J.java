package cn.cg.spi;

public class Log4J implements Logger {
    @Override
    public void info(String s) {
        System.out.println("Log4J info 打印日志：" + s);
    }

    @Override
    public void debug(String s) {
        System.out.println("Log4J debug 打印日志：" + s);
    }
}
