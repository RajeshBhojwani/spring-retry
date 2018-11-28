package com.example.springretrydemo;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/billing")
public class BillingClientService {

    @Autowired
    private BillingService billingService;
    @GetMapping
    public String callRetryService() throws SQLException {
        return billingService.simpleRetry();
    }
}