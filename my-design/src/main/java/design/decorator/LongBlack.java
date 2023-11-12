package design.decorator;

/**
 * @author Administrator
 * @title: Blank
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2723:38
 */
public class LongBlack extends Coffee {
    //描述,价格,状态
    public LongBlack(String desc, Float cost, String status) {
        this.setDesc(desc);
        this.setCost(cost);
        this.setStatus(status);
    }

}
