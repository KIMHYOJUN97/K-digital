package cbg.chap04.model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@NoArgsConstructor
public class MemberListPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    /**
     * 생성자 의존성 주입
     * 객체가 변질되는 것을 막기 위해 final을 이용한 ㄱ
     * @param memberDao
     * @param memberPrinter
     */

//    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
//        this.memberDao = memberDao;
//        this.memberPrinter = memberPrinter;
//    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m->memberPrinter.print(m));
    }
}
