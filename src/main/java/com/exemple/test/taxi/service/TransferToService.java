package com.exemple.test.taxi.service;

import com.exemple.test.taxi.dto.StatisticResponse;
import com.exemple.test.taxi.dto.TransferRequest;
import com.exemple.test.taxi.model.TransferTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferToService {

    TransferTo createTransfer(TransferRequest transferRequest);

    Long getDebit(long accountId, LocalDateTime localDateTimeFrom, LocalDateTime localDateTimeTo);

    Long getCredit(long accountId, LocalDateTime localDateTimeFrom, LocalDateTime localDateTimeTo);

    StatisticResponse getStatistic(long accountId, LocalDateTime localDateTimeFrom,
                                         LocalDateTime localDateTimeTo,
                                         int pageNumber,
                                         int pageSize);
}
