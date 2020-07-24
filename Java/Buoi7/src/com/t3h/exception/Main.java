package com.t3h.exception;

public class Main {
    public static void main(String[] args) {
        try {
            String str = "3";
            int a = Integer.parseInt(str);
            System.out.println(a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Done!");
    }
}
