package com.articz.perhour.perhour.Services;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorPayImpl implements RazorPay {
    RazorpayClient instance= new RazorpayClient("rzp_test_UdfAt8GHS33FEO","5B3PKHfKokclOrhcpCuIzc0y");

    public RazorPayImpl() throws RazorpayException {
    }

    @Override
    public Order RazorPaypayments(double amount, String currency) {
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount); // amount in the smallest currency unit
            orderRequest.put("currency", currency);
//            orderRequest.put("receipt", "order_rcptid_11");

            Order order = instance.orders.create(orderRequest);
            return order;

        }catch (RazorpayException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
