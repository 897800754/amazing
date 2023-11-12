package design.v2.behavioral.visitor.demo2;

/**
 * 被访问者-工程师
 *
 * @author: cg1
 * @date: 2022-10-05 23:56
 **/
public class EngineerStaff extends Staff {
    /**
     * 代码提交数量
     */
    private String commitAmount;


    public EngineerStaff(String name, String type, String workingHours, String commitAmount) {
        super(name, type, workingHours);
        this.commitAmount = commitAmount;
    }

    public String getCommitAmount() {
        return commitAmount;
    }

    @Override
    public void accept(StaffVisitor staffVisitor) {
        super.accept(staffVisitor);
        staffVisitor.visitEngineer(this);
    }
}
