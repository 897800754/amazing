package design.v2.behavioral.acyclic.visitor.demo1.structure;

import design.v2.behavioral.acyclic.visitor.demo1.behavior.ModemVisitor;

/**
 * @author: cg1
 * @date: 2022-10-07 01:06
 **/
public abstract class Modem {

    public abstract void accept(ModemVisitor modemVisitor);
}
