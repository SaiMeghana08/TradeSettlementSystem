package com.Settlement.SettelemtService1.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TradeDTO {

    private int tradeId;
    private int buyer_id;
    private int seller_id;
    private int amount;
    private int shares;
    private String status;
    private boolean settled;
}