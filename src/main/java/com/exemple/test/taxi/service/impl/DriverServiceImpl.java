package com.exemple.test.taxi.service.impl;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.Driver;
import com.exemple.test.taxi.repository.DriverRepository;
import com.exemple.test.taxi.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver creatDriver(Driver driver) {
        driverRepository.save(driver);
        return driver;
    }

    @Override
    public Driver getIdDriver(long id) {
        return driverRepository.findById(id).get();
    }

    @Override
    public String debit(Driver driver, BankAccount bankAccount, long money) {
        return null;
    }

    @Override
    public Driver credit(Driver driver) {
        return null;
    }

    @Override
    public Driver balance(Driver driver) {
        return null;
    }

    @Override
    public Driver moneyTransfer(Driver driver) {
        return null;
    }

    @Override
    public Driver dateOfTurnoverOneAccount(Driver driver, BankAccount bankAccount, Date dateFrom, Date dateBefore) {
        return null;
    }

    @Override
    public Driver dateOfTurnoverAllAccount(Driver driver, Date dateFrom, Date dateBefore) {
        return null;
    }
}
