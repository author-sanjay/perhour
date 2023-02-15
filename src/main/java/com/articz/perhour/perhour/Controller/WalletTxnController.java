package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.WalletTxn;
import com.articz.perhour.perhour.Services.WalletTxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class WalletTxnController {

    @Autowired
    private WalletTxnService walletTxnService;


    @PostMapping("/add/{id}")
    public WalletTxn ad(@RequestBody WalletTxn walletTxn, @PathVariable long id){
        return  this.walletTxnService.add(walletTxn,id);
    }

    @GetMapping("/getall")
    public List<WalletTxn> getall(){
        return  this.walletTxnService.getall();
    }

    @GetMapping("/getall/{id}")
    public WalletTxn getsingle(@PathVariable long id){
        return  this.walletTxnService.getsingledetail(id);
    }


}
