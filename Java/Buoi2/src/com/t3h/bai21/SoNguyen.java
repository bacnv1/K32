package com.t3h.bai21;

public class SoNguyen {
    private int n;
    private int m;

    public SoNguyen(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void uocChungLonNhat() {
        int min = Math.min(m, n);
        for (int i = min; i >= 1 ; i--) {
            if (m % i == 0 && n % i == 0) {
                System.out.println("Uoc chung lon nhat: " + i);
                return;
            }
        }
        System.out.println("Khong co uoc chung");
    }
}
