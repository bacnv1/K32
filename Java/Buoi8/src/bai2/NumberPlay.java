package bai2;

import java.util.Scanner;

public class NumberPlay {
    public static Scanner s= new Scanner(System.in);
    private int value;
    public void isNiceNumber(){
        int sumRight =0;
        int sumLeft = 0;
        String str = s.nextLine();

        for (int i = 0; i < str.length()/2; i++) {
            sumLeft += Integer.parseInt(str.charAt(i)+"");
        }
        int start = str.length()/2;
        if (str.length()%2!=0){
            start +=1;
        }
        for (int j = start; j < str.length(); j++) {
            sumRight += Integer.parseInt(str.charAt(j)+"");
        }
        if(sumLeft == sumRight){
            System.out.println("can");
        }else {
            System.out.println("Khong can");
        }
    }
}
