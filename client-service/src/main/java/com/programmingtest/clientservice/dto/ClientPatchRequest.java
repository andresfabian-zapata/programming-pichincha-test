package com.programmingtest.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPatchRequest {

    private String name;
    private String gender;
    private String age;
    private String identification;
    private String address;
    private String phone;
    private String password;
    private Boolean state;
}
