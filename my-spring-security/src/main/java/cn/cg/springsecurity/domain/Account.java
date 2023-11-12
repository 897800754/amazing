package cn.cg.springsecurity.domain;

import lombok.Data;

/**
 * @author: cg
 * @date: 2023-08-02 19:40
 **/
@Data
public class Account {

    private Integer id;

    private String userName;

    private String password;

    private String salt;
}
