package com.Settlement.SettelemtService1.Controller;


import com.Settlement.SettelemtService1.Model.SettlementRecords;
import com.Settlement.SettelemtService1.Model.SettlementRequest;
import com.Settlement.SettelemtService1.Service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settlements")
public class SettlementController {
    @Autowired
    private SettlementService settlementService;
    @PutMapping("/settleTrade/{tradeId}")
    public String settleTrade(@PathVariable int tradeId){
        try{
            return settlementService.settleTrade(tradeId);
        }catch(Exception e){
            return "Error: "+e.getMessage();
        }
    }
    @GetMapping("/getAllSettlements")
    public List<SettlementRecords> getAllSettlements(){
        return settlementService.getAllSettlements();
    }
}
