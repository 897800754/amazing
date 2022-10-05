package design.v2.behavioral.visitor;

import design.v2.behavioral.visitor.behavior.CommanderVisitor;
import design.v2.behavioral.visitor.behavior.SergeantVisitor;
import design.v2.behavioral.visitor.behavior.SoldierVisitor;
import design.v2.behavioral.visitor.structure.Commander;
import design.v2.behavioral.visitor.structure.Sergeant;
import design.v2.behavioral.visitor.structure.Soldier;

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
