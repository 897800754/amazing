package design.v2.behavioral.visitor.demo2;

/**
 * 访问者
 *
 * @author: cg1
 * @date: 2022-10-05 23:55
 **/
public class CEOStaffVisitor implements StaffVisitor {

    @Override
    public void visitEngineer(EngineerStaff engineerStaff) {
        System.out.printf("CEOStaffVisitor:name %s type %s workingHours %s%n", engineerStaff.getName(), engineerStaff.getType(), engineerStaff.getWorkingHours());

    }

    @Override
    public void visitPm(PmStaff pmStaff) {
        System.out.printf("CEOStaffVisitor:name %s type %s workingHours %s%n", pmStaff.getName(), pmStaff.getType(), pmStaff.getWorkingHours());

    }
}
