package com.t3h.main;

import com.t3h.hocsinh.HocSinh;

public class Main {
    public static void main(String[] args) {
        HocSinh hs = new HocSinh("Nguyen Van A",
                "Ha Noi", true, 19);
        hs.hoc();
        hs.thi();
        hs.inThongTin();
    }
}
