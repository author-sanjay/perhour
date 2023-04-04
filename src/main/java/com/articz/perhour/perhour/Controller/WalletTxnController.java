package com.articz.perhour.perhour.Controller;
import com.articz.perhour.perhour.Entity.WalletTxn;
import com.articz.perhour.perhour.Services.WalletTxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class WalletTxnController {

    @Autowired
    private WalletTxnService walletTxnService;


    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/add/{id}")
    public WalletTxn ad(@RequestBody WalletTxn walletTxn, @PathVariable long id){
        return  this.walletTxnService.add(walletTxn,id);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/withdraw/{id}/{id2}")
    public WalletTxn withdraw( @PathVariable long id,@PathVariable float id2){
        return  this.walletTxnService.withdraw(id,id2);
    }

    //done
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/getall")
    public List<WalletTxn> getall(){
        return  this.walletTxnService.getall();
    }


//    done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getsingle/{id}")
    public WalletTxn getsingle(@PathVariable long id){
        return  this.walletTxnService.getsingledetail(id);
    }


}
