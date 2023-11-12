package design.v2.behavioral.acyclic.visitor.demo1.behavior;

import design.v2.behavioral.acyclic.visitor.demo1.structure.Hayes;

/**
 * @author: cg1
 * @date: 2022-10-07 01:07
 **/
public interface HayesVisitor extends ModemVisitor {
    void visit(Hayes hayes);
}

