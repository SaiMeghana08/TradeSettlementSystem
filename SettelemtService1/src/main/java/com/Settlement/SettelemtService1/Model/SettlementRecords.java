package com.Settlement.SettelemtService1.Model;


import com.Settlement.SettelemtService1.Enums.SettlementStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SettlementRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settlementId;
    @Enumerated(EnumType.STRING)
    private SettlementStatus status;
    private int trade_id;

}
