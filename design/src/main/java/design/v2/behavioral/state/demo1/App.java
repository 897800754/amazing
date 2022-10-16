package design.v2.behavioral.state.demo1;

/**
 * @author: cg
 * @date: 2022-10-16 20:35
 **/
public class App {
    public static void main(String[] args) {
        Mammoth mammoth = new Mammoth();

        mammoth.observe();

        mammoth.timePasses();

        mammoth.observe();

        mammoth.timePasses();

        mammoth.observe();
    }
}
