package com.t3h.qlsinhvien;

public class SinhVien {
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private float diem;

    public SinhVien(String ten, int tuoi, boolean gioiTinh, float diem) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diem = diem;
    }

    public void inThongTin() {
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi tinh: " + (gioiTinh ? "Nam" : "Nu"));
        System.out.println("Diem: " + diem);
    }

    public String getTen() {
        return ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public float getDiem() {
        return diem;
    }
}
