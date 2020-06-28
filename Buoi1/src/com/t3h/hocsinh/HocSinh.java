package com.t3h.hocsinh;

public class HocSinh {
    private String hoTen;
    private String diaChi;
    private boolean gioiTinh;
    private int tuoi;

    public HocSinh(String hoTen, String diaChi, boolean gioiTinh, int tuoi) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public void thi() {
        System.out.println("Thi ket thuc mon");
    }

    public void hoc() {
        System.out.println("Hoc kien thuc");
    }

    public void inThongTin() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Dia Chi: " + diaChi);
        if (gioiTinh) {
            System.out.println("Nam");
        } else {
            System.out.println("Nu");
        }
        System.out.println("Tuoi: " + tuoi);
    }
}
