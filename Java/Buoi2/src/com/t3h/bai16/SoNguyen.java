package com.t3h.bai16;

public class SoNguyen {
    private int n;

    public SoNguyen(int n) {
        this.n = n;
    }

    public void tinhToan() {
        int tong = 0;
        int tich = 1;
        int dC = 0;
        int dL = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                tong += i;
                tich *= i;
                if (i % 2 == 0) {
                    dC ++;
                } else {
                    dL ++;
                }
            }
        }
        System.out.println("Tong: " + tong);
        System.out.println("Tich: " + tich);
        System.out.println("Dem Chan: " + dC);
        System.out.println("Dem Le: " + dL);
    }
}
