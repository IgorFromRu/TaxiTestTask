package com.exemple.test.taxi.service;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.Driver;

import java.util.Date;

public interface DriverService {

    Driver creatDriver (Driver driver);
    Driver getIdDriver (long id);
    String debit (Driver driver, BankAccount bankAccount, long money);
    Driver credit (Driver driver);
    Driver balance (Driver driver);
    Driver moneyTransfer (Driver driver);
    Driver dateOfTurnoverOneAccount (Driver driver, BankAccount bankAccount, Date dateFrom, Date dateBefore);
    Driver dateOfTurnoverAllAccount (Driver driver, Date dateFrom, Date dateBefore);

}
