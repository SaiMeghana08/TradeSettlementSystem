package com.Settlement.SettelemtService1.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettlementRequest {
    private int tradeId;
    private int buyerId;
    private int sellerId;

    private int amount;
    private int shares;
}