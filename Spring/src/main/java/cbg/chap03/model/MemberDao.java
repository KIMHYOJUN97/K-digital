package cbg.chap03.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDao {

    //Id값 자동증가 변수
    private static long nextId = 0;
    //Map은 Interface기 때문에 class가 따로 필요함
    private Map<String, Member> members;

    public MemberDao() {
        this.members = new HashMap<>();
    }

    public Member selectByEmail(String email) {
        return members.get(email);
    }

    public void insert(Member member) {
        member.setId(++MemberDao.nextId);
        members.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll() {
        return members.values();
    }

    public void update(Member member) {
        members.put(member.getEmail(), member);
    }
}
