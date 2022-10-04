package cn.cg.spring.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: cg1
 * @date: 2022-09-24 23:34
 **/
@Data
public class Student {
    @NotNull(message = "not find id", groups = {Update.class})
    private Integer id;
//    @NotNull
//    private String name;


    public interface Update {

    }

    public interface Create {

    }
}
