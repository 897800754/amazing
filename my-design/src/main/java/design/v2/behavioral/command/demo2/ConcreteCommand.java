package design.v2.behavioral.command.demo2;

/**
 * @author chengang
 */
public class ConcreteCommand implements ICommand {

    Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.action();
    }
}
