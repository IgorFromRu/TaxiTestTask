package com.exemple.test.taxi.service.impl;

import com.exemple.test.taxi.dto.AccountTransactionRequest;
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
import org.springframework.data.domain.Pageable;
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
        if (senderAccount.getBalance() < transferRequest.getSum()) {
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
    public Long getDebit(AccountTransactionRequest accountTransactionRequest) {
        BankAccount sender = bankAccountService.getAccount(accountTransactionRequest.getAccountId());
        List<TransferTo> debitList = transferToRepository.findBySenderAndCreateDateBetween(sender,
                accountTransactionRequest.getFrom(),
                accountTransactionRequest.getTo());
        return debitList.stream().mapToLong(TransferTo::getSumOperation).sum();
    }

    @Override
    public Long getCredit(AccountTransactionRequest accountTransactionRequest) {
        BankAccount recipient = bankAccountService.getAccount(accountTransactionRequest.getAccountId());
        List<TransferTo> creditList = transferToRepository.findByRecipientAndCreateDateBetween(recipient,
                accountTransactionRequest.getFrom(),
                accountTransactionRequest.getTo());
        return creditList.stream().mapToLong(TransferTo::getSumOperation).sum();
    }

    @Override
    public StatisticResponse getStatistic(AccountTransactionRequest accountTransactionRequest) {

        Pageable pageRequest = PageRequest.of(accountTransactionRequest.getPageNumber() - 1, accountTransactionRequest.getPageSize());
        BankAccount account = bankAccountService.getAccount(accountTransactionRequest.getAccountId());
        Page<TransferTo> page = transferToRepository.findBySenderOrRecipientAndCreateDateBetween(account,
                account,
                accountTransactionRequest.getFrom(),
                accountTransactionRequest.getTo(),
                pageRequest);
        StatisticResponse response = new StatisticResponse();
        response.setTransferToList(page.getContent());
        response.setPageNumber(accountTransactionRequest.getPageNumber());
        response.setPageSizeNumber(accountTransactionRequest.getPageSize());
        response.setTotalPages(page.getTotalPages());
        return response;
    }
}
