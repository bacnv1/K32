package com.t3h.ex2;

public class NguyenTac {
    private String str;

    public NguyenTac(String str) {
        this.str = str;
    }

    public void test(){
        String strings= str;
        int sum = 0;
        while (strings.contains("+-")
                ||strings.contains("-+")
                || strings.contains("--")
                ||strings.contains("++")){
            strings=strings.replace("+-","-");
            strings= strings.replace("-+","-");
            strings = strings.replace("--","-0-");
            strings = strings.replace("++","+0+");
        }
        System.out.println(strings);
        String newStr = strings;
        newStr= newStr.replace("+"," +");
        newStr= newStr.replace("-"," -");
        String[] str= newStr.split(" ");
        for (int i = 0; i <str.length ; i++) {
            if (!str[i].isEmpty()){
                sum += Integer.valueOf(str[i]);
            }
        }
        System.out.println(sum);

    }


    public void sortASC(String value){
        String chuoi = "";
        int[] array = new int[value.length()];
        for(int i = 0; i < value.length(); i++){
            char kt = value.charAt(i);
            int ascii = (int) kt;
            array[i] = ascii;
        }
//        sắp xếp
        int tg = 0;
        for(int j = 0; j < value.length(); j++){
            for(int k = j + 1; k < value.length(); k++){
                if(array[j] > array[k]){
                    tg = array[j];
                    array[j] = array[k];
                    array[k] = tg;
                }
            }
        }
//        in ra màn hình
        for(int o = 0; o < value.length(); o++){
            String strs = Character.toString((char)array[o]);
            chuoi = chuoi + strs;
        }
        System.out.println(chuoi);

    }

    public void daonguoc(String value){
        String[] str = value.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder(str[i]).reverse().toString();
            builder.append(" " + str[i]);
        }
        System.out.println(builder.toString().trim());
    }
}
