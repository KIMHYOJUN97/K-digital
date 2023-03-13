package cbg.chap03.model;

import cbg.chap03.exception.DuplicateMemberException;

import java.time.LocalDateTime;

public class MemberRegisterService {

    private final MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

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
