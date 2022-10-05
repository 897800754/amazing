package design.v2.behavioral.visitor.behavior;

import design.v2.behavioral.visitor.structure.Commander;
import design.v2.behavioral.visitor.structure.Sergeant;
import design.v2.behavioral.visitor.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:15
 **/
public class SergeantVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        System.out.println("SergeantVisitor hi sergeant");
    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
