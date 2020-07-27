package Bai1;

import java.util.ArrayList;

public class StringUtil {
    private String value;

    public StringUtil(String value) {
        this.value = value;
    }

    public void printUpperCaseCharacters(){
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i))){
                System.out.println(value.charAt(i) + ",");
            }
        }
    }

    public void findSmallestNumber(){
        int smallest = 10;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))){
                int number = value.charAt(i) - '0';
                if (number < smallest){
                    smallest = number;
                }
            }
        }

        if(smallest == 10){
            System.out.println("No number!");
        }else {
            System.out.println("Smallest number is " + smallest);
        }
    }
}
