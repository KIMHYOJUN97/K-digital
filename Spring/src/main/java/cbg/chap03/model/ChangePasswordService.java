package cbg.chap03.model;

import cbg.chap03.exception.MemberNotFoundException;
import cbg.chap03.exception.WrongIdPasswordException;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {

    private MemberDao memberDao;

    public ChangePasswordService() {

    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void changePassword(String email, String oldPassword, String newPassword) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }

        if (oldPassword.equals(newPassword)) {
            throw new WrongIdPasswordException();
        }

        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
    }
}
