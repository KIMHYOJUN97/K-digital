package cbg.chap04.config;

import cbg.chap04.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppContext {

    /**
     * @Bean Method가 붙어있는 경우 싱글톤으로 스프링 컨테이너가 관리해준다.
     * 동일 Type의 메서드가 존재할 때 @Qulifier("지정할 이름")을 중심으로 먼저 찾는다.
     * Qulifier=>한정자를 메서드의 매개변수 이름으로 사용할 수 없다.
     * @return
     */

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }


    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberSummaryPrinter memberSummaryPrinter() {
        return new MemberSummaryPrinter();
    }

    @Bean
//    public MemberRegisterService memberRegSvc() {
//        return new MemberRegisterService(memberDao());
//    }
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
//        pwdSvc.setMemberDao(this.memberDao());
        return pwdSvc;
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter();
    }
//    public MemberListPrinter listPrinter() {
//        return new MemberListPrinter(memberDao(),memberPrinter());
//    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
//        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//        memberInfoPrinter.setMemberPrinter(memberPrinter());
//        memberInfoPrinter.setMemberDao(memberDao());
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
