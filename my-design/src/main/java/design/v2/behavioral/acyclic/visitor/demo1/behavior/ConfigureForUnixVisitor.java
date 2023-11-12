package design.v2.behavioral.acyclic.visitor.demo1.behavior;

import design.v2.behavioral.acyclic.visitor.demo1.structure.Zoom;

public class ConfigureForUnixVisitor implements ZoomVisitor {
    @Override
    public void visit(Zoom zoom) {
        System.out.println(zoom + " used with Unix configurator.");
    }
}
