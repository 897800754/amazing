package design.v2.behavioral.visitor.demo1.structure;

import design.v2.behavioral.visitor.demo1.behavior.UnitVisitor;

/**
 * 指挥官
 *
 * @author: cg1
 * @date: 2022-10-05 17:10
 **/
public class Commander extends Unit {
    public Commander(Unit... children) {
        super(children);
    }

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visitCommander(this);
        super.accept(visitor);
    }
}
