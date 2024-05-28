package com.vitoleandro.picpay.service;

import com.vitoleandro.picpay.controller.dto.CreateWalletDto;
import com.vitoleandro.picpay.entity.Wallet;
import com.vitoleandro.picpay.exception.WalletDataAlreadyExistException;
import com.vitoleandro.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        var walletDB = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletDB.isPresent()) {
            throw new WalletDataAlreadyExistException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}
