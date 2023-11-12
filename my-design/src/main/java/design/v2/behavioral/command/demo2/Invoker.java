package design.v2.behavioral.command.demo2;

/**
 * @author chengang
 */
public class Invoker {

    private ICommand iCommand;

    public Invoker(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    public void action() {
        iCommand.execute();
    }
}
