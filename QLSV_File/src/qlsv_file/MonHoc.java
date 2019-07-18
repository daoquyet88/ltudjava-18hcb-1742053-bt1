/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv_file;

/**
 *
 * @author Admin
 */
public class MonHoc {
    public String sTT;
    public  String maMH;
    public String tenMH;
    public String phongH;

    public MonHoc(String maMH, String tenMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
    }

    @Override
    public String toString() {
        return tenMH;
    }

    public String getsTT() {
        return sTT;
    }

    public void setsTT(String sTT) {
        this.sTT = sTT;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getPhongH() {
        return phongH;
    }

    public void setPhongH(String phongH) {
        this.phongH = phongH;
    }
    
}
