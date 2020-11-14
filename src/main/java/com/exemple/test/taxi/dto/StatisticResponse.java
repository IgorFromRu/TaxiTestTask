package com.exemple.test.taxi.dto;

import com.exemple.test.taxi.model.TransferTo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StatisticResponse {
    private List<TransferTo> transferToList;
    private int pageNumber;
    private int pageSizeNumber;
    private int TotalPages;
}
