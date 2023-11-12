package design.v2.behavioral.visitor.demo2;

/**
 * @author: cg1
 * @date: 2022-10-05 23:55
 **/
public abstract class Staff {
    public Staff(String name, String type, String workingHours) {
        this.name = name;
        this.type = type;
        this.workingHours = workingHours;
    }

    /**
     * 名字
     */
    private String name;
    /**
     * 员工类型
     */
    private String type;

    /**
     * 工时
     */
    private String workingHours;

    public String getWorkingHours() {
        return workingHours;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void accept(StaffVisitor staffVisitor) {

    }

}
