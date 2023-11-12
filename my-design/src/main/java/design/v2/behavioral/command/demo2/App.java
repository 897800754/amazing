package design.v2.behavioral.command.demo2;

/**
 * @author: cg
 * @date: 2022-10-07 23:26
 **/
public class App {

    public static void main(String[] args) {
        ICommand command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
