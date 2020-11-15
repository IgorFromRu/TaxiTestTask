package com.exemple.test.taxi.repository;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.TransferTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.rmi.server.LoaderHandler;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferToRepository extends JpaRepository<TransferTo, Long> {

    List<TransferTo> findBySenderAndCreateDateBetween(BankAccount sender, LocalDateTime from, LocalDateTime to);

    List<TransferTo> findByRecipientAndCreateDateBetween(BankAccount recipient, LocalDateTime from, LocalDateTime to);

    Page<TransferTo> findBySenderOrRecipientAndCreateDateBetween(BankAccount sender, BankAccount recipient,
                                                                 LocalDateTime from, LocalDateTime to,
                                                                 Pageable pageRequest);
}
