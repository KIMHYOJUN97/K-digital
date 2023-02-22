package Kimhyojun.service;

import Kimhyojun.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeworkService {
    static Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main_step() {
        System.out.println("### 학생 성적 관리 프로그램 ###\n");
        System.out.println("1. 학생 정보 입력");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 성적 변경");
        System.out.println("4. 학생 정보 삭제");
        System.out.println("5. 프로그램 종료");
        System.out.print(">>> ");
    }

    public static void change_information(ArrayList<Student> Database) {
        try {
            clearScreen();
            System.out.println("변경할 학생의 학번을 입력하여 주세요");
            int searched = Integer.parseInt(sc.nextLine());
            int flag = 0;
            for (Student s : Database) {
                if (s.num == searched) {
                    System.out.println("학생의 성적: 국어=" + s.score[0] + "영어=" + s.score[1] + "수학=" + s.score[2] + "과학=" + s.score[3]);
                    while (true) {
                        System.out.println("변경할 학생의 과목을 선택해 주세요");
                        System.out.println("1.국어 2.영어 3.수학 4.과학");
                        System.out.print(">>> ");
                        int choice = Integer.parseInt(sc.nextLine());
                        System.out.println("변경할 점수를 알려주세요");
                        int changed = Integer.parseInt(sc.nextLine());
                        s.score[choice - 1] = changed;
                        System.out.println("변경 되었습니다! 더 변경하시겠습니까?(Y/N)");
                        String nxt = sc.nextLine();
                        if (nxt.equals("N") || nxt.equals("n")) break;
                        if (!nxt.equals("Y") || !nxt.equals("y")) {
                            System.out.println("잘못 입력하셨습니다.");
                            break;
                        }
                    }
                    flag = 1;
                }
            }
            if (flag == 0) System.out.println("변경할 학생이 존재하지 않습니다.");
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다.");
        }
    }

    public static void search_information(ArrayList<Student> Database) {
        try {
            clearScreen();
            System.out.println("1. 개별조회");
            System.out.println("2. 전체조회");
            System.out.print(">>> ");
            int choice = Integer.parseInt(sc.nextLine());
            clearScreen();
            if (choice == 1) {
                System.out.println("조회할 학생의 학번을 입력하세요");
                System.out.print(">>> ");
                int searched = Integer.parseInt(sc.nextLine());
                int flag = 0;
                for (Student s : Database) {
                    if (s.num == searched) {
                        System.out.println("학생의 학번: " + s.num);
                        System.out.println("학생의 이름: " + s.name);
                        System.out.println("학생의 성별: " + s.sex);
                        System.out.println("학생의 성적: 국어=" + s.score[0] + "영어=" + s.score[1] + "수학=" + s.score[2] + "과학=" + s.score[3]);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.println("찾으시는 학생이 존재하지 않습니다.");
                }
            } else if (choice == 2) {
                for (Student s : Database) {
                    System.out.println("학생의 학번: " + s.num);
                    System.out.println("학생의 이름: " + s.name);
                    System.out.println("학생의 성별: " + s.sex);
                    System.out.println("학생의 성적: 국어=" + s.score[0] + "영어=" + s.score[1] + "수학=" + s.score[2] + "과학=" + s.score[3]);
                    System.out.println();
                }
                System.out.println("전체 조회를 완료하였습니다");
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다");
        }
    }

    public static void input_information(ArrayList<Student> Database) {
        try {
            clearScreen();
            System.out.println("학생의 이름을 입력하세요:");
            String name = sc.nextLine();
            System.out.println("학생의 학번을 입력하세요:");
            int num = Integer.parseInt(sc.nextLine());
            System.out.println("학생의 성별을 입력하세요:");
            String sex = sc.nextLine();
            System.out.println("학생의 각 과목 점수를 입력하세요.(국어 영어 수학 과학 순서로 입력하시오.)");
            int[] score = new int[4];
            String[] s_score = sc.nextLine().split(" ");
            for (int i = 0; i < 4; i++) {
                score[i] = Integer.parseInt(s_score[i]);
            }
            Student student = new Student(num, name, sex, score);

            Database.add(student);
            System.out.println("입력 완료 되었습니다!");
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다.");
        }
    }

    public static void delete_information(ArrayList<Student> Database) {
        try {
            System.out.println("삭제할 학생의 학번을 입력하세요");
            System.out.print(">>> ");
            int deleted = Integer.parseInt(sc.nextLine());
            int flag = 0;
            int idx = -1;
            for (Student s : Database) {
                idx++;
                if (s.num == deleted) {
                    Database.remove(idx);
                    flag = 1;
                    break;
                }
            }
            clearScreen();
            if (flag == 0) {
                System.out.println("삭제할 학생이 존재하지 않습니다.");
            } else {
                System.out.println("삭제가 완료되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다.");
        }
    }
}
