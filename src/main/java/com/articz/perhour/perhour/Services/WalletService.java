package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {
    public float balance(long id);
    public List<WalletTxn> gettxn(long id);
}
