package com.example.deviceWarrantyTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Device
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serial;
    private LocalDate purchaseDate;
    private int warrantyMonths;
    private String vendor;
    private LocalDate warrantyExpiresAt;

    //calculating expiry date before saving
    public void calculateExpiryDate()
    {
        if(purchaseDate != null && warrantyMonths >0)
        {
            this.warrantyExpiresAt = purchaseDate.plusMonths(warrantyMonths);
        }
    }
    //getters and setters
    //for id
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    //for name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //for serial
    public String getSerial() {return serial;}
    public void setSerial(String serial) {this.serial = serial;}

    //for purchaseDate
    public LocalDate getPurchaseDate() {return purchaseDate;}
    public void setPurchaseDate(LocalDate purchaseDate) {this.purchaseDate = purchaseDate;}

    //for warrantyMonths
    public int getWarrantyMonths() {return warrantyMonths;}
    public void setWarrantyMonths(int warrantyMonths) {this.warrantyMonths = warrantyMonths;}

    //for vendor
    public String getVendor() {return vendor;}
    public void setVendor(String vendor) {this.vendor = vendor;}

    //for warrantyExpiresAt
    public LocalDate getWarrantyExpiresAt() {return warrantyExpiresAt;}
    public void setWarrantyExpiresAt(LocalDate warrantyExpiresAt) {this.warrantyExpiresAt = warrantyExpiresAt;}


    //what about constructors?
}


