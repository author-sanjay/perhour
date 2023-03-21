package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.OrderRequest;
import com.articz.perhour.perhour.Entity.OrderResponse;
import com.articz.perhour.perhour.Services.RazorPay;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private RazorPay razorPay;
    private  RazorpayClient instance= new RazorpayClient("rzp_test_UdfAt8GHS33FEO","5B3PKHfKokclOrhcpCuIzc0y");

    public PaymentController() throws RazorpayException {
    }

    @PostMapping("/createorder")
    public OrderResponse createorder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse=new OrderResponse();
        Order order=razorPay.RazorPaypayments(orderRequest.getAmount(),"INR");
        System.out.println(order);
        orderResponse.setRazorpayorderid(order.get("id"));
//            orderResponse.setApplicationfees(orderRequest.getAmount());
        orderResponse.setSecretid("5B3PKHfKokclOrhcpCuIzc0y");
        orderResponse.setSecretkey("rzp_test_UdfAt8GHS33FEO");
        return orderResponse;
    }
}
