package com.t3h;

public class KhuPho {
    private int n;
    private HoDan[] hoDan;

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }


    public KhuPho(int n, HoDan[] hoDan) {
        this.n = n;
        this.hoDan = hoDan;
    }

    public void hienThi(){
        for (int i = 0; i < hoDan.length; i++) {
            System.out.println("So thanh vien: "+ hoDan[i].getSothanhvien());
            System.out.println("So nha: " + hoDan[i].getSonha());
            hoDan[i].hienThiHoDan();

        }
    }
}
