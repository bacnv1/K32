package com.t3h.mang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MangTinh {
    private Random rd = new Random();
    private Integer[] arr = new Integer[10];

    public MangTinh() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(101);
        }
    }

    public void sapXep() {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    arr[j] = arr[i] + arr[j];
//                    arr[i] = arr[j] - arr[i];
//                    arr[j] = arr[j] - arr[i];
//                }
//            }
//        }
        Arrays.sort(arr, comparator);
    }

    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public void inMang() {
        System.out.println();
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
