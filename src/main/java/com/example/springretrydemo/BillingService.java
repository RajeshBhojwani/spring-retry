package com.example.springretrydemo;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingService.class);
    int counter =0;

    @Retryable(value = { SQLException.class }, maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public String simpleRetry() throws SQLException {
        counter++;
        LOGGER.info("Billing Service Failed "+ counter);
        throw new SQLException();

    }

    @Recover
    public String recover(SQLException t){
        LOGGER.info("Service recovering");
        return "Service recovered from billing service failure.";
    }
}   