package cn.cg.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: cg
 * @date: 2023-03-21 17:09
 **/
public class Main {

    public static void main(String[] args) {
        ServiceLoader<Logger> load = ServiceLoader.load(Logger.class);
        Iterator<Logger> iterator = load.iterator();
        while (iterator.hasNext()) {
            Logger next = iterator.next();
            next.debug("123");

        }

    }
}
