package com.Settlement.SettelemtService1.Client;

import com.Settlement.SettelemtService1.Model.SettlementRequest;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "user-service",
        contextId = "accountClient"
)
public interface AccountClient {


    @PutMapping("/users/settleTrade/{tradeId}")
    @Transactional
    String settleAccounts(
           @PathVariable int tradeId
    );
}