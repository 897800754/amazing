package cn.cg.mybatisflex;

import lombok.Data;

import java.util.Date;

/**
 * @author: cg
 * @date: 2023-08-02 15:51
 **/
@Data
public class ArticleDTO {
    private Long id;
    private Long accountId;
    private String title;
    private String content;

    //以下用户相关字段
    private String authorName;
    private int age;
    private Date birthday;
}
