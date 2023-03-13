package com.example.jeonghwanhwang.model;

public class Student {

    private int id;
    private String name;
    private String gender;
    private int korean;
    private int english;
    private int math;
    private int science;
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }
    public String printStudent(){
        String result = "id : " + this.getId() + " name : " + this.getName() + " gender : " + this.getGender() +
        " korean : " + this.getKorean() + " english : " + this.getEnglish() + " math : " + this.getMath() + " science : " + this.getScience();
        return result;
    }
}