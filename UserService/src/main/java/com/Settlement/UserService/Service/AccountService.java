package com.Settlement.UserService.Service;

import com.Settlement.UserService.Client.TradeClient;
import com.Settlement.UserService.Model.Account;
import com.Settlement.UserService.Model.TradeDTO;
import com.Settlement.UserService.Model.User;
import com.Settlement.UserService.Repository.AccountRepo;
import com.Settlement.UserService.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TradeClient tradeClient;
    @Transactional
    public String settleTrade(
            int tradeId
    ) {
        TradeDTO trade=tradeClient.viewTrade(tradeId);
        System.out.println("Buyer ID: " + trade.getBuyer_id());
        System.out.println("Seller ID: " + trade.getSeller_id());
        System.out.println("Amount: " + trade.getAmount());
        System.out.println("Shares: " + trade.getShares());

        User buyerUser = userRepo.findById(trade.getBuyer_id())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        Account buyerAccount = buyerUser.getAccount();
        User sellerUser = userRepo.findById(trade.getSeller_id())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        Account sellerAccount = sellerUser.getAccount();

        if (buyerAccount.getBalance() < trade.getAmount()) {
            throw new RuntimeException(
                    "Insufficient Balance"
            );
        }

        if (sellerAccount.getShares() < trade.getShares()) {
            throw new RuntimeException(
                    "Insufficient Shares"
            );
        }

        // Buyer pays money
        buyerAccount.setBalance(
                buyerAccount.getBalance()
                        - trade.getAmount()
        );

        // Buyer receives shares
        buyerAccount.setShares(
                buyerAccount.getShares()
                        + trade.getShares()
        );

        // Seller receives money
        sellerAccount.setBalance(
                sellerAccount.getBalance()
                        + trade.getAmount()
        );

        // Seller loses shares
        sellerAccount.setShares(
                sellerAccount.getShares()
                        - trade.getShares()
        );

        accountRepo.save(buyerAccount);
        accountRepo.save(sellerAccount);

        return "Settlement Completed";
    }
}