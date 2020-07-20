package com.t3h;

public class HoDan {
    private int sothanhvien,sonha;
    private nguoi[] tv;

    public int getSothanhvien() {
        return sothanhvien;
    }

    public int getSonha() {
        return sonha;
    }

    public nguoi[] getTv() {
        return tv;
    }

    public HoDan(int sothanhvien, int sonha, nguoi[] tv) {
        this.sothanhvien = sothanhvien;
        this.sonha = sonha;
        this.tv = tv;
    }

    public void hienThiHoDan(){
        for (int i = 0; i < tv.length; i++) {
            tv[i].hienThiThongTin();
        }
    }
}
