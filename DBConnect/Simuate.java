package HwangJeongHwan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Simuate {
    Scanner sc = new Scanner(System.in);
    Control control;
    ArrayList<Student> arr;
    Student student;
    public Simuate(Control control){
        this.control = control;
        arr = new ArrayList<>();
        student = new Student();
    }
    public void start(int n){
        do {
            System.out.println("1. 학생 정보 입력\n" +
                    "2. 학생 정보 조회\n" +
                    "3. 성적 변경\n" +
                    "4. 학생 정보 삭제\n" +
                    "5. 프로그램 종료");
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("정수만 입력할 수 있습니다! \n 다시 입력해주세요");
                System.out.println("1. 학생 정보 입력\n" +
                        "2. 학생 정보 조회\n" +
                        "3. 성적 변경\n" +
                        "4. 학생 정보 삭제\n" +
                        "5. 프로그램 종료");
                n = Integer.parseInt(sc.nextLine());
            }
            if (n < 0 || n > 5) {
                System.out.println("다시 입력해 주세요\n 입력할수 있는 수는 1 ~ 5입니다!");
            }
            switch (n) {
                case 1:
                    insertInfo();
                    break;

                case 2:
                    selectInfo();
                    break;
                case 3:
                    updateInfo();
                    break;
                case 4:
                    deleteInfo();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break;
            }
        }
        while(n != 5);

    }
    public void selectInfo(){
        System.out.println("(1) 개별조회 (2) 전체 학생 정보 조회");
        int search = Integer.parseInt(sc.nextLine());
        switch(search){
            case 1:
                System.out.print("개별조회할 학번을 입력하세요 : ");
                int findHakbun = Integer.parseInt(sc.nextLine());
                System.out.println("학번:" + findHakbun);

                student = control.selectStudent(findHakbun);
                if(student == null){
                    System.out.println("저장된 학생이 없습니다.");
                }
                else {
                    System.out.println(student.printStudent());
                }
//                boolean checkHakbun = false;
////                            System.out.println(arr.size());
//                for(int i = 0; i < arr.size(); i++){
//                    Student s = arr.get(i);
//                    if(s.getHakbun() == findHakbun){
//                        System.out.println(s.printStudent());
//                        checkHakbun = true;
//                    }
//                }
//                if(!checkHakbun){
//                    System.out.println("학생정보를 찾을 수 없습니다.");
//                }
                break;



            case 2:
                arr = control.selectAll();
                if(arr.isEmpty()){
                    System.out.println("저장된 학생이 없습니다.");
                }
                else {
                    for(int i = 0; i < arr.size(); i++){
                        System.out.println(arr.get(i).printStudent());
                    }
                }

                break;


        }

    }
    public void insertInfo(){
        int hakbun = 0;
        try {
            System.out.print("학번을 입력해 주세요 (정수) ");
            hakbun = Integer.parseInt(sc.nextLine());
            System.out.println("학번 : " + hakbun);
        }
        catch(NumberFormatException e){
            System.out.println("숫자를 입력해야 합니다!");
            System.out.print("학번을 다시입력해 주세요 (정수) ");
            hakbun = Integer.parseInt(sc.nextLine());
            System.out.println("학번 : " + hakbun);
        }
        System.out.print("이름을 입력해 주세요 ");
        String name = sc.nextLine();
        System.out.println("이름 : " + name);
        System.out.print("성별을 입력해 주세요 : (남 or 여) ");
        String MaleFemale = sc.nextLine();
        System.out.println("성별 : " + MaleFemale);
        while(!MaleFemale.equals("남") && !MaleFemale.equals("여")){
            System.out.println("성별은 남 or 여 로만 입력할 수 있습니다!");
            System.out.print("성별을 입력해 주세요 ex)남, 여 ");
            MaleFemale = sc.nextLine();
            System.out.println("성별 : " + MaleFemale);
            if(MaleFemale.equals("남") || MaleFemale.equals("여")){
                break;
            }
        }
        System.out.println("국어 영어 수학 과학 순으로 점수를 공백으로 구분해 입력해 주세요 \n ex)10 20 30 40");
        int[] score;

        try {
            score = new int[4];

            String[] scores = sc.nextLine().split(" ");

            System.out.println(Arrays.toString(scores));
            for (int i = 0; i < 4; i++) {
                score[i] = Integer.parseInt(scores[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("국 영 수 과 순서로 점수를 공백으로 구분해 입력해야 합니다!");
            System.out.println("국어 영어 수학 과학 순으로 점수를 공백으로 구분해 입력해 주세요 \n ex)10 20 30 40");
            score = new int[4];
            String[] scores = sc.nextLine().split(" ");

            System.out.println(Arrays.toString(scores));
            for (int i = 0; i < 4; i++) {
                score[i] = Integer.parseInt(scores[i]);
            }


        }
        System.out.println("국, 영, 수, 과 : " + Arrays.toString(score));
//        arr.add(new Student(hakbun, name, MaleFemale, score));
        Student s = new Student(hakbun, name, MaleFemale, score);
        control.insertStudent(s);
    }
    public int updateInfo(){

        System.out.print("성적을 변경할 학생의 학번을 입력하세요 : ");
        int update = Integer.parseInt(sc.nextLine());
        boolean updateFlag = false;

        if(control.selectHakbun(update) != update) {
            System.out.println("저장된 학생의 정보가 없습니다!");
        }
        else{
            System.out.println("변경방법을 선택하세요 (1) 한번에 모든 과목 다 바꾸기 (2) 한과목씩 바꾸기");
            updateFlag = true;
            int seletUpdate = Integer.parseInt(sc.nextLine());
            switch(seletUpdate){
                case 1:
                    System.out.println("국어 영어 수학 과학 순으로 점수를 입력해 주세요 ");
                    int[] updateScore = new int[4];
                    String[] updateScores = sc.nextLine().split(" ");
//                                    System.out.println(Arrays.toString(scores));
                    for(int i = 0; i < 4; i++){
                        updateScore[i] = Integer.parseInt(updateScores[i]);
                    }

                    System.out.println("변경전 정보" + control.selectStudent(update).printStudent());
                    // 업데이트
                    control.updateStudent(update,updateScore);
                    System.out.println("변경된 정보" + control.selectStudent(update).printStudent());
                    break;

                case 2:
                    System.out.print("변경할 과목을 입력하세요 (1)국어 (2)영어 (3) 수학 (4) 과학");
                    String title = "";

                    int selectSubject = Integer.parseInt(sc.nextLine());
                    switch(selectSubject){
                        case 1:
                            title = "korean";
                            break;
                        case 2:
                            title ="english";
                            break;
                        case 3:
                            title = "math";
                            break;
                        case 4:
                            title = "science";
                            break;
                    }
                    System.out.print("변경할 점수를 입력하세요 : ");
                    int changeScore = Integer.parseInt(sc.nextLine());
                    System.out.println("변경전 정보" + control.selectStudent(update).printStudent());
                    // 업데이트
                    control.updateStudent(update,title,changeScore);
                    System.out.println("변경된 정보" + control.selectStudent(update).printStudent());
                    break;


            }

        }

        if(!updateFlag){
            System.out.println("저장된 학생 정보가 없습니다. 학번을 다시 입력해주세요!");
        }
        return 0;
    }
    public void deleteInfo(){

        System.out.println("삭제할 학생의 학번을 입력하세요 : ");
        int deleteStudent = Integer.parseInt(sc.nextLine());
        if(deleteStudent != control.selectHakbun(deleteStudent)){
            System.out.println("일치하는 학번을 가진 학생이 없습니다.");
        }
        else{
            control.deleteStudent(deleteStudent);
            System.out.println("삭제되었습니다.");

        }
//        for(Student s : arr){
//            if(s.getHakbun() == deleteStudent){
//                System.out.println(s.printStudent() + " 학생정보 삭제");
//                arr.remove(s);
//                break;
//            }
//        }
    }
}
