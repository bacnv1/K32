package com.t3h.mangdong;

import java.util.ArrayList;
import java.util.Collections;

public class MangDong {
    private ArrayList<Integer> arr = new ArrayList<>();

    public MangDong() {
        arr.add(3);
        arr.add(5);
        arr.add(4);
        arr.add(1, 10);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(21);
        arr1.add(11);
        arr.addAll(arr1);

        arr.set(1, 100);
        arr.remove(1);
//        arr.clear();
        int index = arr.indexOf(21);
        System.out.println(index);
//        arr.sort();
//        Collections.reverse(arr);
        Collections.shuffle(arr);
    }

    public void inMang() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) +" ");
        }
    }

}
