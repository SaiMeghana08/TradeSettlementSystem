package com.Settlement.TradeService.Controller;


import com.Settlement.TradeService.Model.Trade;
import com.Settlement.TradeService.Model.TradeDTO;
import com.Settlement.TradeService.Model.TradeRequest;
import com.Settlement.TradeService.Service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @PostMapping("/createTrade")
    public Trade createTrade(@RequestBody TradeRequest trade){
        System.out.println("Buyer ID received: " + trade.getBuyerId());
        return tradeService.createTrade(trade);
    }
    
    @GetMapping("/viewTrade/{tradeId}")
    public TradeDTO viewTrade(@PathVariable int tradeId){
        return tradeService.viewTrade(tradeId);
    }
    @GetMapping("/getAllTrades")
    public List<Trade> getAllTrades(){
        return tradeService.getAllTrades();
    }
    @PutMapping("/settle/{id}")
    public String markAsSettled(@PathVariable int id) {
        tradeService.markAsSettled(id);
        return "Trade updated successfully";
    }
}
