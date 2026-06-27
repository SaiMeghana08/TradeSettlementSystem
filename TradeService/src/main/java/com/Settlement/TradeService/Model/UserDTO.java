package com.Settlement.TradeService.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int userId;
    private String userName;
    private AccountDTO account;
}
