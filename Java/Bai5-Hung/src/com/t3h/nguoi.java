package com.t3h;

public class nguoi {
    private String ht,nn;
    private int tuoi,ns;

    public nguoi() {
    }

    public nguoi(String ht, String nn, int tuoi, int ns) {
        this.ht = ht;
        this.nn = nn;
        this.tuoi = tuoi;
        this.ns = ns;
    }

    public void hienThiThongTin(){
        System.out.println("Ho ten: " + ht);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Nam sinh: " + ns);
        System.out.println("Nghe nghiep: " + nn);
    }
}
