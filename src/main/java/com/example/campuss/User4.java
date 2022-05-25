package com.example.campuss;

public class User4 {
    private String Name;

    private Integer Year;

    private String Subject1;

    private String Subject2;

    public User4 (String Name ,Integer year, String sem1,String sem2){
        this.Name=Name;
        this.Year=Year;
        this.Subject1=Subject1;
        this.Subject2=Subject2;
    }

    public String getName() {
        return Name;
    }

    public Integer getYear() {
        return Year;
    }

    public String getSubject1() {
        return Subject1;
    }

    public String getSubject2() {
        return Subject2;
    }
}
