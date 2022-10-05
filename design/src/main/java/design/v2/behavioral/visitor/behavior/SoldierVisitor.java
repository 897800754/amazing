package design.v2.behavioral.visitor.behavior;

import design.v2.behavioral.visitor.structure.Commander;
import design.v2.behavioral.visitor.structure.Sergeant;
import design.v2.behavioral.visitor.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:16
 **/
public class SoldierVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {
        System.out.println("SoldierVisitor hi soldier");
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
