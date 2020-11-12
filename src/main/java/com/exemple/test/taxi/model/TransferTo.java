package com.exemple.test.taxi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transfer")
public class TransferTo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String cardSender;

    @Column(nullable = false)
    private Long cardRecipient;

    @Column(nullable = false)
    private LocalDateTime timeOperation;

    @Column(nullable = false)
    private Long sumOperation;

    public TransferTo() {
    }
}
