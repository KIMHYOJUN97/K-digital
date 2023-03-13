package cbg.chap04.model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class MemberInfoPrinter {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("멤버가 존재하지 않습니다.");
            return;
        }
        memberPrinter.print(member);
        System.out.println();
    }

//    public void setMemberDao(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }
//
//    public void setMemberPrinter(MemberPrinter memberPrinter) {
//        this.memberPrinter = memberPrinter;
//    }
}
