package com.example.taxmanager.billmanager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/taxmanager/bills")
@CrossOrigin(origins = "http://localhost:4200")
public class BillManagerController {

    private final BillManagerService billManagerService;

    @Autowired
    public BillManagerController(BillManagerService billManagerService) {
        this.billManagerService = billManagerService;
    }

    @GetMapping
    public List<BillManager> getBills(){
        return billManagerService.getBills();
    }
    @PostMapping
    public  void registerNewBill(@RequestBody BillManager billManager){
        billManagerService.addNewBill(billManager);
    }
    @DeleteMapping(path = "{billManagerId}")
    public void deleteBill(@PathVariable("billManagerId") Long billManagerId){
        billManagerService.deleteBill(billManagerId);

    }

    @PutMapping(path = "{billManagerId}")
    public void updateBill(
            @PathVariable("billManagerId") Long billManagerId,
            @RequestParam(required = false) String billName,
            @RequestParam(required = false)  Integer billAmount,
            @RequestParam(required = false) String billDescription,
            @RequestParam(required = false) LocalDate billDate)


    {
        billManagerService.updateBill(billManagerId,billName,billAmount,billDescription,billDate);
    }
}

