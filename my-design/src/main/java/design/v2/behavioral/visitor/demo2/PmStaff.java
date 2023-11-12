package design.v2.behavioral.visitor.demo2;

/**
 * 被访问者-项目管理
 *
 * @author: cg1
 * @date: 2022-10-05 23:56
 **/
public class PmStaff extends Staff {

    private String productStatus;

    public PmStaff(String name, String type, String workingHours, String productStatus) {
        super(name, type, workingHours);
        this.productStatus = productStatus;
    }

    @Override
    public void accept(StaffVisitor staffVisitor) {
        super.accept(staffVisitor);
        staffVisitor.visitPm(this);
    }

    public String getProductStatus() {
        return productStatus;
    }
}
