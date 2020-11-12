package com.exemple.test.taxi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private long numberCard;

    @Column(nullable = false)
    private long balance;

    public BankAccount() {
    }
}
