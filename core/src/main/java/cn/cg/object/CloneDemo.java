package cn.cg.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: cg
 * @date: 2023-03-20 23:13
 **/
public class CloneDemo implements Cloneable {
    private String id;
    private List<String> eles;

    public CloneDemo(String id, List<String> eles) {
        this.id = id;
        this.eles = eles;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("100");
        CloneDemo cloneDemo = new CloneDemo("1", strings);
        CloneDemo clone = (CloneDemo) cloneDemo.clone();
        System.out.println(cloneDemo.equals(clone));//true

        //修改cloneDemo id,eles

        List<String> eles = clone.getEles();

        eles.add("1000");//浅拷贝,true

        System.out.println(cloneDemo);

        System.out.println(clone);

        System.out.println(clone.equals(cloneDemo));

        clone.setId("100000");

        System.out.println(cloneDemo);

        System.out.println(clone);

        System.out.println(clone.equals(cloneDemo));//false


    }

    public String getId() {
        return id;
    }

    public List<String> getEles() {
        return eles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEles(List<String> eles) {
        this.eles = eles;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloneDemo cloneDemo = (CloneDemo) o;
        return Objects.equals(id, cloneDemo.id) &&
                Objects.equals(eles, cloneDemo.eles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eles);
    }

    @Override
    public String toString() {
        return "CloneDemo{" +
                "id='" + id + '\'' +
                ", eles=" + eles +
                '}';
    }
}
