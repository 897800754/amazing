package design.v2.behavioral.acyclic.visitor.demo1.behavior;

import design.v2.behavioral.acyclic.visitor.demo1.structure.Zoom;

public interface ZoomVisitor extends ModemVisitor {
  void visit(Zoom zoom);
}
