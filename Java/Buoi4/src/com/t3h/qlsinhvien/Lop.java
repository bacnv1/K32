package com.t3h.qlsinhvien;

import java.util.Arrays;
import java.util.Comparator;

public class Lop {
    private SinhVien[] sv = new SinhVien[5];

    public Lop() {
        sv[0] = new SinhVien("Nguyen Van A", 10, true, 5.5f);
        sv[1] = new SinhVien("Nguyen ThiB", 11, false, 7.5f);
        sv[2] = new SinhVien("Ngo Van A", 10, true, 3.5f);
        sv[3] = new SinhVien("Tran Thi C", 10, false, 6.5f);
        sv[4] = new SinhVien("Nguyen Van D", 12, true, 9.5f);
    }

    private Comparator<SinhVien> comparator = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            int result = (int) ((o1.getDiem() - o2.getDiem()) * 10);
            return result;
        }
    };

    public void sapXep() {
        Arrays.sort(sv, comparator);
    }

    public void timKiem(int diem) {
        for (SinhVien s: sv) {
            if (s.getDiem() >= diem) {
                s.inThongTin();
                System.out.println("===============");
            }
        }
    }

    public void inDanhSach() {
        timKiem(0);
    }
}
