package design.v2.behavioral.visitor.demo2;

/**
 * 访问者
 *
 * @author: cg1
 * @date: 2022-10-05 23:55
 **/
public interface StaffVisitor {

    void visitEngineer(EngineerStaff engineerStaff);

    void visitPm(PmStaff pmStaff);
}
