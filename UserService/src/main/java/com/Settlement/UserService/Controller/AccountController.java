package com.Settlement.UserService.Controller;


import com.Settlement.UserService.Model.Account;
import com.Settlement.UserService.Model.SettlementRequest;
import com.Settlement.UserService.Model.User;
import com.Settlement.UserService.Repository.AccountRepo;
import com.Settlement.UserService.Repository.UserRepo;
import com.Settlement.UserService.Service.AccountService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/getAccount/{AccountId}")
    public Account getAccount(@PathVariable int AccountId){
        return accountRepo.findById(AccountId).orElseThrow(()->new RuntimeException("Account Not Found"));
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
    @PutMapping("/settleTrade/{tradeId}")
    public String settleTrade(@PathVariable int tradeId){
        return accountService.settleTrade(tradeId);
    }
}
