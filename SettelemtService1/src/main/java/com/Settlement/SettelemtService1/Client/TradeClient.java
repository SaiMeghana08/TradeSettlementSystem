package com.Settlement.SettelemtService1.Client;

import com.Settlement.SettelemtService1.Model.TradeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "trade-service",
        contextId = "tradeClient"
)
public interface TradeClient {

    @GetMapping("/trades/viewTrade/{id}")
    TradeDTO getTradeById(
            @PathVariable int id
    );
    @PutMapping("/trades/settle/{id}")
    String markAsSettled(@PathVariable int id);

}