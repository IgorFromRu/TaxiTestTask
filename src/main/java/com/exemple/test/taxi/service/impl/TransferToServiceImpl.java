package com.exemple.test.taxi.service.impl;

import com.exemple.test.taxi.dto.StatisticResponse;
import com.exemple.test.taxi.dto.TransferRequest;
import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.TransferTo;
import com.exemple.test.taxi.repository.TransferToRepository;
import com.exemple.test.taxi.service.BankAccountService;
import com.exemple.test.taxi.service.TransferToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferToServiceImpl implements TransferToService {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private TransferToRepository transferToRepository;

    @Override
    @Transactional
    public TransferTo createTransfer(TransferRequest transferRequest) {
        BankAccount senderAccount = bankAccountService.getAccount(transferRequest.getSenderNumberCardId());
        if (senderAccount.getBalance() < transferRequest.getSum()){
            throw new RuntimeException("Insufficient funds");
        }
        BankAccount recipientAccount = bankAccountService.getAccount(transferRequest.getRecipientNumberCardId());
        senderAccount.setBalance(senderAccount.getBalance() - transferRequest.getSum());
        recipientAccount.setBalance(recipientAccount.getBalance() + transferRequest.getSum());
        TransferTo transferTo = new TransferTo();
        transferTo.setSender(senderAccount);
        transferTo.setRecipient(recipientAccount);
        transferTo.setSumOperation(transferRequest.getSum());
        transferTo.setCreateDate(LocalDateTime.now());
        return transferToRepository.save(transferTo);
    }

    @Override
    public Long getDebit(long accountId, LocalDateTime from, LocalDateTime to) {
        BankAccount sender = bankAccountService.getAccount(accountId);
        List<TransferTo> debitList = transferToRepository.findBySenderAndCreateDateBetween(sender, from, to);
        return debitList.stream().mapToLong(transferTo -> transferTo.getSumOperation()).sum();
    }

    @Override
    public Long getCredit(long accountId, LocalDateTime from, LocalDateTime to) {
        BankAccount recipient = bankAccountService.getAccount(accountId);
        List<TransferTo> creditList = transferToRepository.findByRecipientAndCreateDateBetween(recipient, from, to);
        return creditList.stream().mapToLong(transferTo -> transferTo.getSumOperation()).sum();
    }

    @Override
    public StatisticResponse getStatistic(long accountId,
                                                LocalDateTime from,
                                                LocalDateTime to,
                                                int pageNumber,
                                                int pageSize) {
        PageRequest request = PageRequest.of(pageNumber - 1, pageSize);
        BankAccount account = bankAccountService.getAccount(accountId);
        Page<TransferTo> page = transferToRepository.findBySenderOrRecipientAndCreateDateBetween(account, account, from, to, request);
        StatisticResponse response = new StatisticResponse();
        response.setTransferToList(page.getContent());
        response.setPageNumber(pageNumber);
        response.setPageSizeNumber(pageSize);
        response.setTotalPages(page.getTotalPages());
        return response;
    }
}
