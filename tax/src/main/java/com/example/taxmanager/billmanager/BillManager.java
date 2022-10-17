package com.example.taxmanager.billmanager;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class BillManager {
    @Id
    @SequenceGenerator(
            name="billmanager_sequence",
            sequenceName = "billmanager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "billmanager_sequence"
    )

   private Long id;
   private String billName;
   private String billDescription;
   private Integer billAmount;
   private LocalDate billDate;

    public BillManager() {
    }

    public BillManager(Long id, String billName, String billDescription, Integer billAmount, LocalDate billDate) {
        this.id = id;
        this.billName = billName;
        this.billDescription = billDescription;
        this.billAmount = billAmount;
        this.billDate = billDate;
    }

    public BillManager(String billName, String billDescription, Integer billAmount, LocalDate billDate) {
        this.billName = billName;
        this.billDescription = billDescription;
        this.billAmount = billAmount;
        this.billDate = billDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }

    public Integer getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Integer billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    @Override
    public String toString() {
        return "BillManager{" +
                "id=" + id +
                ", billName='" + billName + '\'' +
                ", billDescription='" + billDescription + '\'' +
                ", billAmount='" + billAmount + '\'' +
                ", billDate='" + billDate + '\'' +
                '}';
    }
}
