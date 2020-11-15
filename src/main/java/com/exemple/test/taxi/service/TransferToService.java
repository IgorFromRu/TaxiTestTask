package com.exemple.test.taxi.service;

import com.exemple.test.taxi.dto.AccountTransactionRequest;
import com.exemple.test.taxi.dto.StatisticResponse;
import com.exemple.test.taxi.dto.TransferRequest;
import com.exemple.test.taxi.model.TransferTo;

import java.time.LocalDateTime;

public interface TransferToService {

    TransferTo createTransfer(TransferRequest transferRequest);

    Long getDebit(AccountTransactionRequest accountTransactionRequest);

    Long getCredit(AccountTransactionRequest accountTransactionRequest);

    StatisticResponse getStatistic(AccountTransactionRequest accountTransactionRequest);
}
