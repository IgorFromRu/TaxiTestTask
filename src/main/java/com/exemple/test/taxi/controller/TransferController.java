package com.exemple.test.taxi.controller;

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

    @GetMapping
    public ResponseEntity<Long> getDebit(@RequestParam(name = "account_id") long accountId,
                                         @RequestParam(name = "from") LocalDateTime from,
                                         @RequestParam(name = "to") LocalDateTime to) {
        Long debit = transferToService.getDebit(accountId, from, to);
        return debit != null
                ? new ResponseEntity<>(debit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Long> getCredit(@RequestParam(name = "account_id") long accountId,
                                          @RequestParam(name = "from") LocalDateTime from,
                                          @RequestParam(name = "to") LocalDateTime to) {
        Long credit = transferToService.getCredit(accountId, from, to);
        return credit != null
                ? new ResponseEntity<>(credit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistic(@RequestParam(name = "account_id") long accountId,
                                                          @RequestParam(name = "from") LocalDateTime from,
                                                          @RequestParam(name = "to") LocalDateTime to,
                                                          @RequestParam(name = "page") int pageNumber,
                                                          @RequestParam(name = "size") int pageSize) {
        StatisticResponse statistic = transferToService.getStatistic(accountId, from, to, pageNumber, pageSize);
        return statistic != null
                ? new ResponseEntity<>(statistic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
