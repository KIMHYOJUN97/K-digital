package cbg.chap04.model;

import cbg.chap04.exception.DuplicateMemberException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@Component
public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

//    public MemberRegisterService(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }

    /**
     * Exception을 Dao에 넣어놓는것?
     * @param req
     * @return
     */
    public long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new DuplicateMemberException();
        }
        member = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(member);
        return member.getId();
    }
}
