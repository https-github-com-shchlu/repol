package com.scl.domain;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: chenglu
 * Date: 2019/11/18
 * Description:
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
