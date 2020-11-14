package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.dto.StatisticResponse;
import com.exemple.test.taxi.dto.TransferRequest;
import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.TransferTo;
import com.exemple.test.taxi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("transfers")
public class TransferController {

    @PostMapping
    public ResponseEntity<TransferTo> createTransfer(@RequestBody TransferRequest transferRequest) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Long> getDebit(@RequestParam(name = "account_id") long accountId,
                                         @RequestParam(name = "from") LocalDateTime localDateTimeFrom,
                                         @RequestParam(name = "to") LocalDateTime localDateTimeTo){
        return null;
    }

    @GetMapping
    public ResponseEntity<Long> getCredit(@RequestParam(name = "account_id") long accountId,
                                          @RequestParam(name = "from") LocalDateTime localDateTimeFrom,
                                          @RequestParam(name = "to") LocalDateTime localDateTimeTo){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<StatisticResponse>> getStatistic(@RequestParam(name = "account_id") long accountId,
                                                                @RequestParam(name = "from") LocalDateTime localDateTimeFrom,
                                                                @RequestParam(name = "to") LocalDateTime localDateTimeTo,
                                                                @RequestParam(name = "page") int pageNumber,
                                                                @RequestParam(name = "size") int pageSize){
        return null;
    }
}
