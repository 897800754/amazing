package design.v2.behavioral.visitor.demo1;


import design.v2.behavioral.visitor.demo1.behavior.CommanderVisitor;
import design.v2.behavioral.visitor.demo1.behavior.SergeantVisitor;
import design.v2.behavioral.visitor.demo1.behavior.SoldierVisitor;
import design.v2.behavioral.visitor.demo1.structure.Commander;
import design.v2.behavioral.visitor.demo1.structure.Sergeant;
import design.v2.behavioral.visitor.demo1.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:19
 **/
public class App {
    public static void main(String[] args) {
        Soldier soldier = new Soldier(null);
        Sergeant sergeant = new Sergeant(soldier);
        Commander commander = new Commander(sergeant);

        commander.accept(new SoldierVisitor());
        commander.accept(new SergeantVisitor());
        commander.accept(new CommanderVisitor());
    }
}
