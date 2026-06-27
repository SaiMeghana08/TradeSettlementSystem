package com.Settlement.TradeService.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeRequest {
    private int buyerId;
    private int sellerId;
    private int amount;
    private int shares;
    private boolean settled;
}
