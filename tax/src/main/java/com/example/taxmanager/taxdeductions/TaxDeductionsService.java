package com.example.taxmanager.taxdeductions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaxDeductionsService {

    private final TaxDeductionsRepository taxDeductionsRepository;
    @Autowired
    public TaxDeductionsService(TaxDeductionsRepository taxDeductionsRepository) {
        this.taxDeductionsRepository = taxDeductionsRepository;
    }

    public List<TaxDeductions> getTaxes(){
        return taxDeductionsRepository.findAll();
    }

    public void addNewTaxDeduction(TaxDeductions taxDeductions) {
        Optional<TaxDeductions> taxDeductionsOptional = taxDeductionsRepository.findTaxDeductionsByEmail(taxDeductions.getEmail());
        if(taxDeductionsOptional.isPresent()){
            throw  new IllegalStateException("email taken");
        }
        taxDeductionsRepository.save(taxDeductions);
    }

    

    public void deleteTaxDeduction(Long taxDeductionId) {
        
            boolean exists = taxDeductionsRepository.existsById(taxDeductionId);

            if(!exists){
                throw new IllegalStateException("Tax Deduction with id" + taxDeductionId + "does not exists");
            }
            taxDeductionsRepository.deleteById(taxDeductionId);

        
    }

    @Transactional
    public void updateTaxDeduction(Long taxDeductionId,
                                   String name,
                                   String email,
                                   String gross,
                                   String nssf,
                                   String nhif,
                                   String paye,
                                   String relief,
                                   String netpay) {
        TaxDeductions taxDeductions = taxDeductionsRepository.findById(taxDeductionId)
                .orElseThrow(() -> new IllegalStateException(
                        "Tax Deduction with id" + taxDeductionId + "does not exist" ));
        if(name != null && name.length() > 0 && !Objects.equals(taxDeductions.getName(),name)){
            taxDeductions.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(taxDeductions.getEmail(),email)){
            Optional<TaxDeductions> taxDeductionsOptional = taxDeductionsRepository.findTaxDeductionsByEmail(email);
            if(taxDeductionsOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            taxDeductions.setEmail(email);
        }
        if(gross != null && gross.length() > 0 && !Objects.equals(taxDeductions.getGross(),gross)){
            taxDeductions.setGross(Integer.valueOf(gross));
        }
        if(nssf != null && nssf.length() > 0 && !Objects.equals(taxDeductions.getNssf(),nssf)){
            taxDeductions.setNssf(Integer.valueOf(nssf));
        }
        if(nhif != null && nhif.length() > 0 && !Objects.equals(taxDeductions.getNhif(),nhif)){
            taxDeductions.setNhif(Integer.valueOf(nhif));
        }
        if(paye != null && paye.length() > 0 && !Objects.equals(taxDeductions.getPaye(),paye)){
            taxDeductions.setPaye(Integer.valueOf(paye));
        }
        if(relief != null && relief.length() > 0 && !Objects.equals(taxDeductions.getRelief(),relief)){
            taxDeductions.setRelief(Integer.valueOf(relief));
        }
        if(netpay != null && netpay.length() > 0 && !Objects.equals(taxDeductions.getNetpay(),netpay)){
            taxDeductions.setNetpay(Integer.valueOf(netpay));
        }


    }
}
