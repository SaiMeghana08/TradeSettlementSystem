package com.Settlement.TradeService.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private int accountId;

    private double balance;

    private int shares;
}