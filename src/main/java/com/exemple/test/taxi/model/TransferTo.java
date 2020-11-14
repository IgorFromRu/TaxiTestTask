package com.exemple.test.taxi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transfer")
public class TransferTo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private BankAccount sender;

    @ManyToOne
    @JoinColumn(name = "recipient_account_id")
    private BankAccount recipient;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column
    private long sumOperation;


}
