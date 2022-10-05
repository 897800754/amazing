package design.v2.behavioral.visitor.demo1.structure;

import design.v2.behavioral.visitor.demo1.behavior.UnitVisitor;

/**
 * 中士
 *
 * @author: cg1
 * @date: 2022-10-05 17:11
 **/
public class Sergeant extends Unit {

    public Sergeant(Unit... children) {
        super(children);
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitSergeant(this);
        super.accept(visitor);
    }
}
