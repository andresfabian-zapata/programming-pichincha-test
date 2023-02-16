package com.programmingtest.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientProxy {

    private Long id;
    private String name;
    private String gender;
    private String age;
    private String identification;
    private String address;
    private String phone;
    private String password;
    private Boolean state;

}
