package design.v2.behavioral.visitor.demo2;

/**
 * 访问者
 *
 * @author: cg1
 * @date: 2022-10-05 23:55
 **/
public class CTOStaffVisitor implements StaffVisitor {


    @Override
    public void visitEngineer(EngineerStaff engineerStaff) {
        System.out.printf("CTOStaffVisitor:name %s type %s commitAmount %s%n", engineerStaff.getName(), engineerStaff.getType(), engineerStaff.getCommitAmount());
    }

    @Override
    public void visitPm(PmStaff pmStaff) {
        System.out.printf("CTOStaffVisitor:name %s type %s productStatus %s%n", pmStaff.getName(), pmStaff.getType(), pmStaff.getProductStatus());

    }
}
