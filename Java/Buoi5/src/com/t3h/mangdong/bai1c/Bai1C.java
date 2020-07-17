package com.t3h.mangdong.bai1c;

import java.util.ArrayList;

public class Bai1C {

    private int[] ints = new int[]{1, 2, 3, 5, 4, 6, 7, 8, 9, 8, 7, 6, 5, 11, 12, 13, 15, 14, 16, 18, 2, 4, 3, 5, 7, 9};

    public void phanC() {
        int hieu = -1;
        String list = "";
        for (int i = 1; i < ints.length; i++) {
            int h = (ints[i] - ints[i - 1]);
            if (h > 0 && hieu < 0) {
                hieu = h;
                list += ints[i - 1];
            }
            if (h <= 0 || h != hieu) {
                if (!list.isEmpty()) {
                    System.out.println(list);
                }
                list = "";
                if (h > 0 && h != hieu) {
                    i = i - 1;
                }
                hieu = -1;
            } else if (hieu == h) {
                list += " " + ints[i];
            }
        }
        System.out.println(list);
    }
}
