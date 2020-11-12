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
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        final Driver creatDriver = driverService.creatDriver(driver);
        return creatDriver != null
                ? new ResponseEntity<>(creatDriver, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Driver> getIdDriver(@PathVariable(name = "id") long id){
        return driverService.getIdDriver(id) != null
                ? new ResponseEntity<>(driverService.getIdDriver(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
