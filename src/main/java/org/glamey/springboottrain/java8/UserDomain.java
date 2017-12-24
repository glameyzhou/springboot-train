package org.glamey.springboottrain.java8;

import lombok.Data;

/**
 * @author zhouyang.zhou
 * @date 2017.12.23.23
 */

@Data
public class UserDomain implements java.io.Serializable {

    private Long id;
    private String email;
    private String address;


    public UserDomain() {
    }

    public UserDomain(String email, String address) {
        this.email = email;
        this.address = address;
    }
}