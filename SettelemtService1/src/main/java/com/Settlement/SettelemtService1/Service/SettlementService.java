package com.Settlement.SettelemtService1.Service;


import com.Settlement.SettelemtService1.Client.AccountClient;
import com.Settlement.SettelemtService1.Client.TradeClient;
import com.Settlement.SettelemtService1.Enums.SettlementStatus;
import com.Settlement.SettelemtService1.Model.SettlementRecords;
import com.Settlement.SettelemtService1.Model.SettlementRequest;
import com.Settlement.SettelemtService1.Model.TradeDTO;
import com.Settlement.SettelemtService1.Repository.SettlementRepo;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@Service
public class SettlementService {
    @Autowired
    private TradeClient tradeClient;
    @Autowired
    private SettlementRepo settlementRepo;
    @Autowired
    private AccountClient accountClient;

    @Transactional
    public String settleTrade(int tradeId) {

        // 1. Fetch trade
        TradeDTO trade = tradeClient.getTradeById(tradeId);

        // 2. Validate existence
        if (trade == null) {
            throw new RuntimeException("❌ Trade not found. Settlement aborted.");
        }

        // 3. Validate already settled
        if (trade.isSettled()) {
            throw new RuntimeException("❌ Trade already settled.");
        }
        String result;
        try {
            result = accountClient.settleAccounts(tradeId);
        } catch (Exception e) {
            throw new RuntimeException("Account settlement failed: " + e.getMessage());
        }
        // 2. Call Account Service for settlement


        tradeClient.markAsSettled(tradeId);
        // (optional) call trade-service to update status
        // tradeClient.updateTrade(trade);
        SettlementRecords settlement = new SettlementRecords();
        settlement.setTrade_id(tradeId);
        settlement.setStatus(SettlementStatus.SETTLED);
        settlementRepo.save(settlement);

        return "✅ Settlement successful for tradeId: " + trade.getTradeId();
    }

    public List<SettlementRecords> getAllSettlements(){
        return settlementRepo.findAll();
    }
}
