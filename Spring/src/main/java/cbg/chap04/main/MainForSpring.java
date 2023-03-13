package cbg.chap04.main;

import cbg.chap04.config.AppContext;
import cbg.chap04.exception.DuplicateMemberException;
import cbg.chap04.exception.MemberNotFoundException;
import cbg.chap04.exception.WrongIdPasswordException;
import cbg.chap04.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {
    private static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppContext.class);


    private static void printHelp() {
        System.out.println("\n잘못된 명령입니다. 아래 사용법을 확인하세요");
        System.out.println("\n ### 명령어 사용법 ###");
        System.out.println("\n 명령어를 입력하세요: new 이메일 이름 암호 암호확인");
        System.out.println("\n 명령어를 입력하세요: change 이메일 현재암호 변경암호");
        System.out.println("\n 명령어를 입력하세요: list");
        System.out.println("\n 명령어를 입력하세요: info");
        System.out.println("\n 명령어를 입력하세요: version");
        System.out.println("\n 명령어를 입력하세요: exit");
    }

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }

        RegisterRequest req = new RegisterRequest();
        MemberRegisterService regSvc = context.getBean("memberRegSvc",MemberRegisterService.class);

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

        ChangePasswordService pwdSvc = context.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            pwdSvc.changePassword(args[1], args[2], args[3]);
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.\n");
        } catch (WrongIdPasswordException e) {
            System.out.println("잘못된 아이디 또는 패스워드 입니다.\n");
        }
    }

    private static void processListCommand() {
        MemberListPrinter listPrinter = context.getBean("listPrinter", MemberListPrinter.class);

        listPrinter.printAll();
    }

    private static void processInfoCommand(String[] args) {
        if (args.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter infoPrinter = context.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(args[1]);
    }

    private static void processVersionCommand(){
        VersionPrinter versionPrinter = context.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
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
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            } else if (command.startsWith("list")) {
                processListCommand();
                continue;
            }else if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
                continue;
            } else if (command.startsWith("version")) {
                processVersionCommand();
                continue;
            }
        }

            printHelp();
        }


}
