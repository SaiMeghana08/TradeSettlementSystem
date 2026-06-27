package com.Settlement.UserService.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;
}
