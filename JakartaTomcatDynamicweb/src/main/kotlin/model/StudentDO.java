package model;

public class StudentDO {
    private int id;
    private String name;
    private String gender;
//    private int[] score;
    private int kor;
    private int eng;
    private int math;
    private int sci;

    public StudentDO() {

    }

    public StudentDO(int id, String name, String gender, int kor, int eng, int math, int sci) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sci = sci;
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

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
    }
}
