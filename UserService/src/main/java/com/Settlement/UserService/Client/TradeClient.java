package com.Settlement.UserService.Client;

import com.Settlement.UserService.Model.TradeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "trade-service",
        contextId = "tradeClient"
)
public interface TradeClient {

    @GetMapping("/trades/viewTrade/{tradeId}")
    TradeDTO viewTrade(@PathVariable int tradeId);

}