package org.example.onlinemovietheater.userdatabaseservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "account_status")
    private Boolean accountStatus;

    public User(String email, String password, boolean accountStatus) {
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public User() {
    }
}
