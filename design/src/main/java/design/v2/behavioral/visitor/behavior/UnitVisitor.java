package design.v2.behavioral.visitor.behavior;

import design.v2.behavioral.visitor.structure.Commander;
import design.v2.behavioral.visitor.structure.Sergeant;
import design.v2.behavioral.visitor.structure.Soldier;

/**
 * @author: cg1
 * @date: 2022-10-05 17:08
 **/
public interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);
}
