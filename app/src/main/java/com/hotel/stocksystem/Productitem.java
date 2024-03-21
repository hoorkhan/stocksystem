package com.hotel.stocksystem;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;

@Entity
public class Productitem implements Serializable {
@PrimaryKey(autoGenerate = true)
    int ID;
String Name;
String type1;
String type2;
String type3;
String specifications;
String soldAt;
String updatedAt;
String desiredprice;
String status="In Stock";
String description;
int image;


    public Productitem() {
    }




    public Productitem(int ID, String name, String type1, String type2, String type3, String specifications, String updatedAt, String soldAt, String desiredprice, String status,String description ,int image) {
        this.ID = ID;
        this.Name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.specifications = specifications;
        this.soldAt=soldAt;
        this.updatedAt=updatedAt;
        this.desiredprice = desiredprice;
        this.status = status;
        this.description=description;

        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSoldAt(){
        return soldAt;
}
    public void setSoldAt(String format) {
        this.soldAt = soldAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDesiredprice() {
        return desiredprice;
    }

    public void setDesiredprice(String desiredprice) {
        this.desiredprice = desiredprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
