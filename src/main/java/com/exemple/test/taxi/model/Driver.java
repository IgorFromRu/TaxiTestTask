package com.exemple.test.taxi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @Column
    private List<BankAccount> bankAccounts;

    public Driver() {
    }
}
