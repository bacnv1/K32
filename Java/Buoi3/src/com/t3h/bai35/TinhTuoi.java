package com.t3h.bai35;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class TinhTuoi {
    private int ngay;
    private int thang;
    private int nam;

    public TinhTuoi(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public void tinhTuoi() {
        Calendar dob = Calendar.getInstance();
        System.out.println(dob.getTimeInMillis());
        Calendar current = Calendar.getInstance();
        long diff = current.getTimeInMillis() - dob.getTimeInMillis();
        int day = (int) (diff / 1000 / 60 / 60 / 24);
        int month = day / 30;
        day = day % 30;
        int year = month / 12;
        month = month % 12;
        System.out.println(year + " nam " + month + " thang " + day + " ngay");


        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        System.out.println(current.getTimeInMillis());
        format.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));
        System.out.println(format.format(current.getTimeInMillis()));
    }
}
