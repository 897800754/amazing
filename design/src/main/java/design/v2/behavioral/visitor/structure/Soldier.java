package design.v2.behavioral.visitor.structure;

import design.v2.behavioral.visitor.behavior.UnitVisitor;

/**
 * @author: cg1
 * @date: 2022-10-05 17:13
 **/
public class Soldier extends Unit {
    public Soldier(Unit... children) {
        super(children);
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSoldier(this);
        super.accept(visitor);
    }
}
