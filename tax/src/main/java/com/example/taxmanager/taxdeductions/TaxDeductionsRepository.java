package com.example.taxmanager.taxdeductions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxDeductionsRepository extends JpaRepository<TaxDeductions, Long> {
    @Query("SELECT s FROM TaxDeductions s WHERE s.email =?1")
    Optional<TaxDeductions> findTaxDeductionsByEmail(String email);


}
