package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.model.Driver;
import com.exemple.test.taxi.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<?> createDriver(@RequestBody Driver driver) {
        final Driver driver1 = driverService.creatDriver(driver);
        return driver1 != null
                ? new ResponseEntity<>(driver1, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Driver> getIdDriver(@PathVariable(name = "id") long id){
        return driverService.getIdDriver(id) != null
                ? new ResponseEntity<>(driverService.getIdDriver(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
