package design.v2.behavioral.visitor.demo1.behavior;

import design.v2.behavioral.visitor.demo1.structure.Commander;
import design.v2.behavioral.visitor.demo1.structure.Sergeant;
import design.v2.behavioral.visitor.demo1.structure.Soldier;

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
