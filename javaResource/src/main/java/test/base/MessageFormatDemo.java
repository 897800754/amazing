package test.base;

import java.text.MessageFormat;

/**
 * @author: cg1
 * @date: 2021-08-09 10:46
 **/
public class MessageFormatDemo {

    public static void main(String[] args) {
        System.out.println(MessageFormat.format("hello {0} ,{0},{1}", "a", "b"));
        try {
            System.out.println(MessageFormat.format("hello {}", "123"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
