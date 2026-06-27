package com.Settlement.TradeService.Model;


import com.Settlement.TradeService.Enums.TradeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeId;
    private int buyer_id;
    private int seller_id;
    private Timestamp timestamp;
    private int amount;
    @Enumerated(EnumType.STRING)
    private TradeStatus status;
    private int shares;
    private boolean settled;
}
