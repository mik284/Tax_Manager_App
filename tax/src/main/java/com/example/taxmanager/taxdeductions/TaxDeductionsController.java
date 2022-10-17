package com.example.taxmanager.taxdeductions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/taxmanager")
@CrossOrigin(origins = "http://localhost:4200")
public class TaxDeductionsController {

    private final TaxDeductionsService taxDeductionsService;

    @Autowired
    public TaxDeductionsController(TaxDeductionsService taxDeductionsService) {
        this.taxDeductionsService = taxDeductionsService;
    }

    @GetMapping
    public List<TaxDeductions> getTaxes(){
      return taxDeductionsService.getTaxes();
    }
    @PostMapping
    public  void registerNewTaxDeduction(@RequestBody TaxDeductions taxDeductions){
        taxDeductionsService.addNewTaxDeduction(taxDeductions);
    }
    @DeleteMapping(path = "{taxDeductionId}")
    public void deleteTaxDeduction(@PathVariable("taxDeductionId") Long taxDeductionId){
        taxDeductionsService.deleteTaxDeduction(taxDeductionId);

    }

    @PutMapping(path = "{taxDeductionId}")
    public void updateTaxDeduction(
            @PathVariable("taxDeductionId") Long taxDeductionId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String gross,
            @RequestParam(required = false) String nssf,
            @RequestParam(required = false) String nhif,
            @RequestParam(required = false) String paye,
            @RequestParam(required = false) String relief,
            @RequestParam(required = false) String netpay)

    {
        taxDeductionsService.updateTaxDeduction(taxDeductionId,name,email,gross,nssf,nhif,paye,relief,netpay);
    }
}
