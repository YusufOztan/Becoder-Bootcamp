package com.springtask1.bankingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "surname",length = 50,nullable = false)
    private String surname;

    @Column(name = "identityNo",length = 50)
    private Long identityNo;

    @Column(name = "password",length = 20)
    private String password;

    @Column(name = "email",length = 60)
    private String email;

    @Column(name = "phoneNumber",length = 11)
    private Long phoneNumber;


}
