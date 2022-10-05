package design.v2.behavioral.visitor.structure;

import design.v2.behavioral.visitor.behavior.UnitVisitor;

import java.util.Arrays;

/**
 * @author: cg1
 * @date: 2022-10-05 17:08
 **/
public abstract class Unit {

    private final Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        if (children != null && children.length > 0) {
            Arrays.stream(children).forEach(child -> child.accept(visitor));
        }
    }
}
