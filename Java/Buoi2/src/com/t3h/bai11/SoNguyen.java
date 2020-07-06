package com.t3h.bai11;

public class SoNguyen {
    private int n;

    public SoNguyen(int n) {
        this.n = n;
    }

    public void tinhToan() {
        int tong = 0;
        int tich = 1;
        for (int i = 1; i <= n; i++) {
            tich *= i;
            tong += tich;
        }
        System.out.println("Ket qua:" + tong);
    }
}
