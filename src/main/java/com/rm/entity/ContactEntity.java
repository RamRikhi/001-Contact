package com.rm.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "CONTACT_MNGT")
public class ContactEntity {
    @Id
    @GeneratedValue
    @Column(name = "CONTACT_ID")
    private Integer contactId;
    @Column(name = "FIRST_NAME")
    private  String firstName;
    @Column(name = "MIDDLE_NAME")
    private  String middleName;
    @Column(name = "LAST_NAME")
    private  String lasrName;
    @Column(name = "MOBILE")
    private Long mobile;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
}
