package design.v2.behavioral.visitor.behavior;

import design.v2.behavioral.visitor.structure.Commander;
import design.v2.behavioral.visitor.structure.Sergeant;
import design.v2.behavioral.visitor.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:13
 **/

public class CommanderVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {
        System.out.println("CommanderVisitor hi commander");
    }
}
