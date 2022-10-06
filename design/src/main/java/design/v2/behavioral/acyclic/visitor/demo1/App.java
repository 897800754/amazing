package design.v2.behavioral.acyclic.visitor.demo1;

import design.v2.behavioral.acyclic.visitor.demo1.behavior.ConfigureForDosVisitor;
import design.v2.behavioral.acyclic.visitor.demo1.behavior.ConfigureForUnixVisitor;
import design.v2.behavioral.acyclic.visitor.demo1.structure.Hayes;
import design.v2.behavioral.acyclic.visitor.demo1.structure.Zoom;

/**
 * @author: cg1
 * @date: 2022-10-07 01:10
 **/
public class App {
    public static void main(String[] args) {
        ConfigureForUnixVisitor conUnix = new ConfigureForUnixVisitor();
        ConfigureForDosVisitor conDos = new ConfigureForDosVisitor();
        Zoom zoom = new Zoom();
        Hayes hayes = new Hayes();


        hayes.accept(conDos);
        zoom.accept(conDos);
        hayes.accept(conUnix);
        zoom.accept(conUnix);
    }
}
