package com.vitoleandro.picpay.controller;

import com.vitoleandro.picpay.controller.dto.CreateWalletDto;
import com.vitoleandro.picpay.entity.Wallet;
import com.vitoleandro.picpay.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    private final WalletService walletService;
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet>createWallet(@RequestBody @Valid CreateWalletDto dto) {
        var wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }
}
