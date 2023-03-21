package com.articz.perhour.perhour.Services;

import com.razorpay.Order;
import org.springframework.stereotype.Service;

@Service
public interface RazorPay {

    public Order RazorPaypayments(double amount, String currency);
}
