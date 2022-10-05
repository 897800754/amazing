package design.v2.behavioral.visitor.demo2;

/**
 * @author: cg1
 * @date: 2022-10-06 00:33
 **/
public class StaffVisitManager {

    private Staff[] staff;

    public StaffVisitManager(Staff[] staff) {
        this.staff = staff;
    }

    public void report(StaffVisitor staffVisitor) {
        for (Staff staff1 : staff) {
            staff1.accept(staffVisitor);
        }
    }


    public static void main(String[] args) {
        StaffVisitManager staffVisitManager = new StaffVisitManager(
                new Staff[]{
                        new EngineerStaff("张三", "Java开发工程师", "100H", "10000行"),
                        new PmStaff("李四", "项目经历", "500H", "100%")});
        //ceo 访问者 看工时
        staffVisitManager.report(new CEOStaffVisitor());
        //cto 访问者 工程师看代码行数,pm看项目进度
        staffVisitManager.report(new CTOStaffVisitor());
    }
}
