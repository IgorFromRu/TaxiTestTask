package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.dto.AccountTransactionRequest;
import com.exemple.test.taxi.dto.StatisticResponse;
import com.exemple.test.taxi.dto.TransferRequest;
import com.exemple.test.taxi.model.TransferTo;
import com.exemple.test.taxi.service.TransferToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("transfers")
public class TransferController {

    @Autowired
    private TransferToService transferToService;

    @PostMapping
    public ResponseEntity<TransferTo> createTransfer(@RequestBody TransferRequest transferRequest) {
        TransferTo transfer = transferToService.createTransfer(transferRequest);
        return transfer != null
                ? new ResponseEntity<>(transfer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/debit")
    public ResponseEntity<Long> getDebit(@RequestBody AccountTransactionRequest accountTransactionRequest) {
        Long debit = transferToService.getDebit(accountTransactionRequest);
        return debit != null
                ? new ResponseEntity<>(debit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/credit")
    public ResponseEntity<Long> getCredit(@RequestBody AccountTransactionRequest accountTransactionRequest) {
        Long credit = transferToService.getCredit(accountTransactionRequest);
        return credit != null
                ? new ResponseEntity<>(credit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/statistic")
    public ResponseEntity<StatisticResponse> getStatistic(@RequestBody AccountTransactionRequest accountTransactionRequest) {
        StatisticResponse statistic = transferToService.getStatistic(accountTransactionRequest);
        return statistic != null
                ? new ResponseEntity<>(statistic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
