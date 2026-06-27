package com.Settlement.TradeService.Service;



import com.Settlement.TradeService.Client.UserClient;
import com.Settlement.TradeService.Enums.TradeStatus;
import com.Settlement.TradeService.Model.*;
import com.Settlement.TradeService.Repository.TradeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepo;
    @Autowired
    private UserClient userClient;
    public Trade createTrade(TradeRequest tradeRequest){

        UserDTO Buyer=userClient.getUserById(tradeRequest.getBuyerId());
        UserDTO Seller=userClient.getUserById(tradeRequest.getSellerId());
        Trade trade=new Trade();
        trade.setBuyer_id(tradeRequest.getBuyerId());
        trade.setSeller_id(tradeRequest.getSellerId());
        trade.setShares(tradeRequest.getShares());
        trade.setAmount(tradeRequest.getAmount());
        trade.setStatus(TradeStatus.PENDING);
        trade.setSettled(false);
        tradeRepo.save(trade);
        return trade;
    }

    public TradeDTO viewTrade(int TradeId){
        Trade trade=tradeRepo.findById(TradeId).orElseThrow(()->new RuntimeException("Account Not Found"));
        TradeDTO tradeDTO=new TradeDTO();
        tradeDTO.setTradeId(trade.getTradeId());
        tradeDTO.setSeller_id(trade.getSeller_id());
        tradeDTO.setBuyer_id(trade.getBuyer_id());
        tradeDTO.setShares(trade.getShares());
        tradeDTO.setStatus(String.valueOf(trade.getStatus()));
        return tradeDTO;
    }

    public List<Trade> getAllTrades(){
        return tradeRepo.findAll();
    }

    @Transactional
    public void markAsSettled(int tradeId) {

        Trade trade = tradeRepo.findById(tradeId)
                .orElseThrow(() -> new RuntimeException("Trade not found"));

        trade.setSettled(true);
        trade.setStatus(TradeStatus.SETTLED);

        // ✅ timestamp generated here (BEST PRACTICE)
        trade.setTimestamp(new Timestamp(System.currentTimeMillis()));

        tradeRepo.save(trade);
    }

}
