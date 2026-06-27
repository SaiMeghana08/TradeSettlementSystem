package com.Settlement.SettelemtService1.Repository;


import com.Settlement.SettelemtService1.Model.SettlementRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepo extends JpaRepository<SettlementRecords,Integer> {
}
