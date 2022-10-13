package com.example.taxmanager.taxdeductions;

import javax.persistence.*;

@Entity
@Table
public class TaxDeductions {
    @Id
    @SequenceGenerator(
            name="taxdeductions_sequence",
            sequenceName = "taxdeductions_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "taxdeductions_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private Integer gross;

    private Integer nssf;
    private Integer nhif;
    private Integer paye;
    private Integer relief;
    private Integer netpay;

    public TaxDeductions(){

    }

    public TaxDeductions(Long id,
                         String name,
                         String email,
                         Integer gross,
                         Integer nssf,
                         Integer nhif,
                         Integer paye,
                         Integer relief,
                         Integer netpay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gross = gross;
        this.nssf = nssf;
        this.nhif = nhif;
        this.paye = paye;
        this.relief = relief;
        this.netpay = netpay;
    }

    public TaxDeductions(String name,
                         String email,
                         Integer gross,
                         Integer nssf,
                         Integer nhif,
                         Integer paye,
                         Integer relief,
                         Integer netpay) {
        this.name = name;
        this.email = email;
        this.gross = gross;
        this.nssf = nssf;
        this.nhif = nhif;
        this.paye = paye;
        this.relief = relief;
        this.netpay = netpay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Integer getNssf() {
        return nssf;
    }

    public void setNssf(Integer nssf) {
        this.nssf = nssf;
    }

    public Integer getNhif() {
        return nhif;
    }

    public void setNhif(Integer nhif) {
        this.nhif = nhif;
    }

    public Integer getPaye() {
        return paye;
    }

    public void setPaye(Integer paye) {
        this.paye = paye;
    }

    public Integer getRelief() {
        return relief;
    }

    public void setRelief(Integer relief) {
        this.relief = relief;
    }

    public Integer getNetpay() {
        return netpay;
    }

    public void setNetpay(Integer netpay) {
        this.netpay = netpay;
    }

    @Override
    public String toString() {
        return "TaxDeductions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gross=" + gross +
                ", nssf=" + nssf +
                ", nhif=" + nhif +
                ", paye=" + paye +
                ", relief=" + relief +
                ", netpay=" + netpay +
                '}';
    }
}

