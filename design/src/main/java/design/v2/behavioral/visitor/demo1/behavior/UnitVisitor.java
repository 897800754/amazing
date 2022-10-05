package design.v2.behavioral.visitor.demo1.behavior;

import design.v2.behavioral.visitor.demo1.structure.Commander;
import design.v2.behavioral.visitor.demo1.structure.Sergeant;
import design.v2.behavioral.visitor.demo1.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:08
 **/
public interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);
}
