package org.glamey.springboottrain.java8;

import lombok.Data;

/**
 * @author zhouyang.zhou
 * @date 2017.12.23.23
 */

@Data
public class UserDomain implements java.io.Serializable {

    private Long id;
    private String code;
    private String name;
    private Integer age;
    private Double salary;
    private Status status;


    public UserDomain() {
    }

    public UserDomain(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public UserDomain(String code, String name, Integer age, Double salary, Status status) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public static enum Status {
        FREE,
        BUSY;
    }
}