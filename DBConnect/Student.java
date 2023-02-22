package HwangJeongHwan;

public class Student {

    private int hakbun;
    private String name;
    private String MaleFemale;
    private int[] score;
    static int count;

    public Student(){}
    public Student(int hakbun, String name, String MaleFemale, int[]score){
        this.hakbun = hakbun;
        this.name = name;
        this.MaleFemale = MaleFemale;
        this.score = score;
        count++;
    }
    public int getHakbun(){
        return this.hakbun;

    }
    public String getName(){
        return this.name;
    }

    public String getMaleFemale() {
        return this.MaleFemale;
    }
    public int[] getScore(){
        return this.score;
    }
    public String printStudent(){

        String result = "";

        result += "학번 : " + this.hakbun + " 이름 : " + this.name + " 성별 : " + this.MaleFemale + " 국어 : " + score[0] + " 영어 : " + score[1] + " 수학 : " + score[2] + " 과학 : " + score[3];


        return result;
    }
    public void setStudent(int[] score){
        for(int i = 0; i < 4; i++){
            this.score[i] = score[i];
        }
    }
    public void setStudent(int num, int value){
        switch (num){
            case 1:
                this.score[0] = value;
                break;

            case 2:
                this.score[1] = value;
                break;

            case 3:
                this.score[2] = value;
                break;

            case 4:
                this.score[3] = value;
                break;


        }
    }
//    public String selectAll(){
//        String result = "";
//        for(int i = 0; i < count; i++){
//
//        }
//    }
}
