package com.example.campuss;

public class User3 {
  private String name,subject;
  private int grade;



  public User3(String name, String subject, Integer grade) {
      this.name = name;
      this.grade = grade;
      this.subject = subject;
    }


    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
  public String getSubject() {
    return subject;
  }

}
