package design.v2.behavioral.acyclic.visitor.demo1.structure;

import design.v2.behavioral.acyclic.visitor.demo1.behavior.ModemVisitor;
import design.v2.behavioral.acyclic.visitor.demo1.behavior.ZoomVisitor;

/**
 * @author: cg1
 * @date: 2022-10-07 01:06
 **/
public class Zoom extends Modem {

    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof ZoomVisitor) {
            ((ZoomVisitor) modemVisitor).visit(this);
        } else {
            System.out.println("Only ZoomVisitor is allowed to visit Zoom modem");
        }
    }
}

