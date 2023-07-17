package org.example.Model;

public class MyTime {
    private int min,hr,sec;

    public MyTime() {
    }

    public MyTime(int min, int hr, int sec) {
        this.min = min;
        this.hr = hr;
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    @Override
    public String toString() {
        return "MyTime{" +
                "min=" + min +
                ", hr=" + hr +
                ", sec=" + sec +
                '}';
    }
}
