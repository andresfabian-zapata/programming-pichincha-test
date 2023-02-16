package com.programmingtest.clientservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

    @Column(unique = true)
    private String name;
    private String gender;
    private String age;
    private String identification;
    private String address;
    private String phone;
}
