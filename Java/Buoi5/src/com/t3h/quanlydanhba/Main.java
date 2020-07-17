package com.t3h.quanlydanhba;

public class Main {

    public static void main(String[] args) {

        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();

        System.out.println(quanLyDanhBa.exist("123"));

        quanLyDanhBa.add("Sang", "999");

        quanLyDanhBa.edit("123", "000");
        quanLyDanhBa.show();


    }

}
