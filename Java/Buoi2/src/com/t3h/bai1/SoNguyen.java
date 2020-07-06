package com.t3h.bai1;

public class SoNguyen {
    private int n;


    public SoNguyen(int n) {
        this.n = n;
    }

    public void tinhTong() {
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += i;
        }
        System.out.println("Tong la: " + tong);
    }
}
