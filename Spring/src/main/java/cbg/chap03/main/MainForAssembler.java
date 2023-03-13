package cbg.chap03.main;

import cbg.chap03.assembler.Assembler;
import cbg.chap03.exception.DuplicateMemberException;
import cbg.chap03.exception.MemberNotFoundException;
import cbg.chap03.exception.WrongIdPasswordException;
import cbg.chap03.model.ChangePasswordService;
import cbg.chap03.model.MemberRegisterService;
import cbg.chap03.model.RegisterRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {

    private static Assembler assembler = new Assembler();

    private static void printHelp() {
        System.out.println("\n잘못된 명령입니다. 아래 사용법을 확인하세요");
        System.out.println("\n ### 명령어 사용법 ###");
        System.out.println("\n 명령어를 입력하세요: new 이메일 이름 암호 암호확인 ###");
        System.out.println("\n 명령어를 입력하세요: change 이메일 현재암호 변경암호 ###\n");
        System.out.println("\n 명령어를 입력하세요: exit\n");
    }

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }

        RegisterRequest req = new RegisterRequest();
        MemberRegisterService regSvc = assembler.getRegSvc();

        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 암호확인이 일치하지 않습니다.");
            return;
        }

        try {
            regSvc.regist(req);
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }


    }

    private static void processChangeCommand(String[] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService pwdSvc = assembler.getPwdSvc();

        try {
            pwdSvc.changePassword(args[1], args[2], args[3]);
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.\n");
        } catch (WrongIdPasswordException e) {
            System.out.println("잘못된 아이디 또는 패스워드 입니다.\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        System.out.println("\n ### 회원 관리 프로그램");

        while (true) {
            System.out.println("명령어를 입력하세요: ");
            command = br.readLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            } else if (command.startsWith("new")) {
                processNewCommand(command.split(""));
            } else if (command.startsWith("change")) {
                processChangeCommand(command.split(""));
            }

            printHelp();
        }
    }
}
