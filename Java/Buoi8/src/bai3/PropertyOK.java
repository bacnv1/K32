package bai3;

public class PropertyOK {
    private String value;

    public PropertyOK(String value) {
        this.value = value;
    }

    public boolean checkPropertyOK(){
        int kt= 0;
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '('){
                kt+=1;
            }else {
                kt -= 1;
            }
            if(kt == -1) {
                return false;
            }
        }
        return kt == 0;
    }

    public boolean checkPropertyOk2() {
        while (value.contains("()")) {
            value = value.replace("()", "");
        }
        return value.isEmpty();
    }
}
