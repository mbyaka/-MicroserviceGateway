package com.infinidium.postgresql.admin.users.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name="USERS_SEQUENCE", sequenceName = "USERS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Entity
@Table(name = "USERS")
public class User
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQUENCE")
    @Column(name = "USER_ID")
    @Id
    private Integer userID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date created;
}
