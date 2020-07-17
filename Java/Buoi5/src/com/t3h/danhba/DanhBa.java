package com.t3h.danhba;

public class DanhBa {

    private String name;
    private String phone;

    public DanhBa(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void show(){

        System.out.println("ten :" + name);
        System.out.println("sdt :" + phone);
        System.out.println("=============");

    }

}
