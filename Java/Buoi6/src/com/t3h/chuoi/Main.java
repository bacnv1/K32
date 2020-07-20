package com.t3h.chuoi;

public class Main {
    public static void main(String[] args) {
        String str = "hello World, hello java, hello lazada, hello lalala";
        int length = str.length();
        System.out.println(length);
        char c = str.charAt(10);
        System.out.println(c);
        int ascii = c;
        System.out.println(ascii);
        c = (char) ascii;
        System.out.println(c);
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'l') {
//                System.out.println(i);
//            }
//        }

//        int index = str.indexOf("l");
//        System.out.println(index);
//        int second = str.indexOf("l", index + 1);
//        System.out.println(second);
//        int lastIndex = str.lastIndexOf("l");
//        System.out.println(lastIndex);

//        int index = str.indexOf("l");
//        while (index >= 0) {
//            System.out.print(index+"\t");
//            index = str.indexOf("l", index + 1);
//        }
//        System.out.println();
//        str = str.replace("l", "L");
//        System.out.println(str);
//        String str1 = str.substring(11);
//        System.out.println(str1);
//        str1 = str.substring(11, 19);
//        System.out.println(str1);
//
//        str = str.toUpperCase();
//        System.out.println(str);
//        str = str.toLowerCase();
//        System.out.println(str);
        System.out.println(str);
        str = " " + str;
        int index = str.indexOf(" ");
        while (index >= 0) {
            String s = str.substring(index, index + 2);
            str = str.replace(s, s.toUpperCase());
            index = str.indexOf(" ", index + 1);
        }
        str = str.trim();
        System.out.println(str);

        String s = "Hello";
        String s1 = "h";
        boolean equal = s.equals(s1);
        System.out.println(equal);
        boolean equalIgnoreCase = s.equalsIgnoreCase(s1);
        System.out.println(equalIgnoreCase);

        String s2 = "lo";
        boolean contain = s.contains(s2);
        System.out.println(contain);

        int compare = s.compareToIgnoreCase(s1);
        System.out.println(compare);
        String[]arr = str.split(" ");
        for (String part: arr) {
            System.out.println(part);
        }
    }
}
