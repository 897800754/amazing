package design.v2.behavioral.acyclic.visitor.demo1.behavior;

import design.v2.behavioral.acyclic.visitor.demo1.structure.Hayes;
import design.v2.behavioral.acyclic.visitor.demo1.structure.Zoom;

/**
 * for dos
 */
public class ConfigureForDosVisitor implements AllModemVisitor {
    @Override
    public void visit(Hayes hayes) {
        System.out.println(hayes + " used with Dos configurator.");
    }

    @Override
    public void visit(Zoom zoom) {
        System.out.println(zoom + " used with Dos configurator.");
    }
}
