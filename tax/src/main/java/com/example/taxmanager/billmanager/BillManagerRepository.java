package com.example.taxmanager.billmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillManagerRepository extends JpaRepository<BillManager, Long> {
    @Query("SELECT s FROM BillManager s WHERE s.billName =?1")
    Optional<BillManager> findBillByName(String billName);


}

