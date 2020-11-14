package com.exemple.test.taxi.dto;

import lombok.Data;

@Data
public class TransferRequest {

    private long senderNumberCardId;

    private long recipientNumberCardId;

    private long sum;
}
