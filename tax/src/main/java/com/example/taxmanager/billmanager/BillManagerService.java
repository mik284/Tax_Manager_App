package com.example.taxmanager.billmanager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillManagerService {

    private final BillManagerRepository billManagerRepository;
    @Autowired
    public BillManagerService(BillManagerRepository billManagerRepository) {
        this.billManagerRepository = billManagerRepository;
    }

    public List<BillManager> getBills(){
        return billManagerRepository.findAll();
    }

    public void addNewBill(BillManager billManager) {
        Optional<BillManager> billManagerOptional = billManagerRepository.findBillByName(billManager.getBillName());
        if(billManagerOptional.isPresent()){
            throw  new IllegalStateException("Bill is present");
        }
        billManagerRepository.save(billManager);
    }



    public void deleteBill(Long billManagerId) {

        boolean exists = billManagerRepository.existsById(billManagerId);

        if(!exists){
            throw new IllegalStateException("Bill with id" + billManagerId + "does not exists");
        }
        billManagerRepository.deleteById(billManagerId);


    }

    @Transactional
    public void updateBill(Long billManagerId,
                                   String billName,
                                   Integer billAmount,
                                   String billDescription,
                                   LocalDate billDate
                                  ) {
        BillManager billManager = billManagerRepository.findById(billManagerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Bill with id" + billManagerId + "does not exist" ));
        if(billDescription != null && billDescription.length() > 0 && !Objects.equals(billManager.getBillDescription(),billDescription)){
            billManager.setBillDescription(billDescription);
        }
        if(billName != null && billName.length() > 0 && !Objects.equals(billManager.getBillName(),billName)){
            Optional<BillManager> billManagerOptional = billManagerRepository.findBillByName(billName);
            if(billManagerOptional.isPresent()){
                throw new IllegalStateException("Bill name taken");
            }
            billManager.setBillName(billName);
        }
        if(billAmount != null  && !Objects.equals(billManager.getBillAmount(),billAmount)){
            billManager.setBillAmount(Integer.valueOf(billAmount));
        }
        if(billDate != null  && !Objects.equals(billManager.getBillDate(),billDate)){
            billManager.setBillDate(billDate);
        }


    }
}

