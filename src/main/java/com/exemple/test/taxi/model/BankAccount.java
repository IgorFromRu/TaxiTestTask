package com.exemple.test.taxi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String numberCard;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private long balance;

}
