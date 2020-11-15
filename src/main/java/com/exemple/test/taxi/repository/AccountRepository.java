package com.exemple.test.taxi.repository;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findByUser(User user);

    @Query("select ba from BankAccount ba where ba.numberCard = :nam")
    BankAccount findByNumberCard(@Param("nam") String numberCard);


}
