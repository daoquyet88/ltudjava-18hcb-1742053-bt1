/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai01_docghifile;

/**
 *
 * @author Admin
 */
public class Stock {
    
 private int id;
 private String desc;
 private double price;
 private int quantity;
 public Stock(int id, String desc, double price, int quantity) {
   this.id = id;
   this.desc = desc;
   this.price = price;
   this.quantity = quantity;
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 @Override
 public String toString() {
    return id + "-" + desc + "-" + price + "-" + quantity;
 }
}
    

