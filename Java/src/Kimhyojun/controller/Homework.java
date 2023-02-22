package Kimhyojun.controller;

import Kimhyojun.domain.Student;
import Kimhyojun.service.HomeworkService;

import java.util.*;

import static Kimhyojun.service.HomeworkService.main_step;

public class Homework {
    public static ArrayList<Student> Database = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static HomeworkService homeworkService;

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            main_step();
            int choice = sc.nextInt();
            int exit = 0;
            switch (choice) {
                case 1:
                    homeworkService.input_information(Database);
                    break;
                case 2:
                    homeworkService.search_information(Database);
                    break;
                case 3:
                    homeworkService.change_information(Database);
                    break;
                case 4:
                    homeworkService.delete_information(Database);
                    break;
                case 5:
                    exit = 1;
                    break;
                default:
                    main_step();
                    break;
            }
            if(exit==1) break;
        }
    }
}
