package com.bashizip.bhlib;


public class BusinessHours extends BasePojo implements Comparable<BusinessHours> {

    static int[] week_days_int = {1, 2, 3, 4, 5, 6, 7};
    private int dayIndex;
    private String dayOfWeek;
    private String from;
    private String to;

    public BusinessHours() {


    }


    public BusinessHours(String dayOfWeek, String from, String to) {
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    @Override
    public String toString() {
        return dayOfWeek + ", " + from + " - " + to;
    }

    @Override
    public int compareTo(BusinessHours businessHours) {
        return 0;
    }
}
