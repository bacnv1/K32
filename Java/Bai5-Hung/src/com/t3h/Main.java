package com.t3h;

public class Main {

    public static void main(String[] args) {
        nguoi ng1 = new nguoi("hung","Sinh vien",2000,2000);
        nguoi ng2= new nguoi("hung","Sinh vien",2000,2000);
        nguoi ng3 = new nguoi("hung","Sinh vien",2000,2000);
        nguoi[] tv = new nguoi[3];
        tv[0] = ng1;
        tv[1] = ng2;
        tv[2] = ng3;
        HoDan[] hoDan = new HoDan[1];
        hoDan[0] = new HoDan(3,128,tv);
        KhuPho kp1 = new KhuPho(1,hoDan);
        kp1.setN(1);
        kp1.getN();
        kp1.hienThi();
    }
}
