package com.t3h.TinhTong;

public class Number {
    private int n;

    public Number(int n) {
        this.n = n;
    }
    public void TinhTongDaySo(){
        int tong=0;
        int tongChan=0;
        int tongLe=0;
        while (n>0){
            int so = n%10;
            if(kiemTraSoNguyenTo(so)){
                System.out.println("So nguyen to la:"+ so);
            }
            if(so%2==0){
                tongChan += so;
            }
            else {
                tongLe += so;
            }
            tong += so;
            n = n/10;
        }

        System.out.println("Tong chan:" + tongChan);
        System.out.println("Tong le:"+ tongLe);
        System.out.println("Tong: " + tong);

    }
    public boolean kiemTraSoNguyenTo(int so){
        for (int i = 2; i <= Math.sqrt(so); i++) {
            if(so%i == 0){
                return false;
            }
        }
        return true;
    }
}
