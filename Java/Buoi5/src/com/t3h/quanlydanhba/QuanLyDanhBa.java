package com.t3h.quanlydanhba;

import com.t3h.danhba.DanhBa;

import java.util.ArrayList;

public class QuanLyDanhBa {

    private ArrayList<DanhBa> danhBas = new ArrayList<DanhBa>();

    public QuanLyDanhBa() {
        add("Trung", "123");
        add("Lam", "128");
        add("Hieu", "5623");
        add("Phong", "173");
    }

    public void show(){
        for (DanhBa danhBa : danhBas) {
           danhBa.show();
        }
    }

    public int exist(String phone) {
        for (int i = 0; i < danhBas.size(); i++) {
            if (danhBas.get(i).getPhone().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    public void add(String name, String phone) {
        if (exist(phone) >= 0) {
            System.out.println("So da ton tai");
        } else {
            danhBas.add(new DanhBa(name, phone));
            System.out.println("Them moi thanh cong");
        }
    }

    public void edit(String oldPhone, String newPhone){
        int index = exist(oldPhone);
        if (index >= 0){
            danhBas.get(index).setPhone(newPhone);
            System.out.println("Thay doi thanh cong");
        } else {
            System.out.println("Khong ton tai sdt");
        }
    }
}
