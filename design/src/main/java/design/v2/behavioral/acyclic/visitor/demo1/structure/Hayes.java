package design.v2.behavioral.acyclic.visitor.demo1.structure;

import design.v2.behavioral.acyclic.visitor.demo1.behavior.HayesVisitor;
import design.v2.behavioral.acyclic.visitor.demo1.behavior.ModemVisitor;

/**
 * @author: cg1
 * @date: 2022-10-07 01:07
 **/
public class Hayes extends Modem {
    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof HayesVisitor) {
            ((HayesVisitor) modemVisitor).visit(this);
        } else {
            System.out.println("Only HayesVisitor is allowed to visit Hayes modem");
        }
    }
}
