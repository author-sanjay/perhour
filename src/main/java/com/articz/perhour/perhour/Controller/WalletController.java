package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.WalletTxn;
import com.articz.perhour.perhour.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;


//    done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/balance/{id}")
    public float balance(@PathVariable long id){
        return this.walletService.balance(id);
    }



//    done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/txns/{id}")
    public List<WalletTxn> txns(@PathVariable long id){
        return this.walletService.gettxn(id);
    }
}
