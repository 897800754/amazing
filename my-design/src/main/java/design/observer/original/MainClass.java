package design.observer.original;

/**
 * @author Administrator
 * @title: MainClass
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2714:09
 */
public class MainClass {
    public static void main(String[] args) {
        //设置公告板内容
        CurrentConditions cc = new CurrentConditions();
        //创建WeatherData传入公告板
        WeatherData w = new WeatherData(cc);
        w.dataChange(40, 100, 100);

    }
}
