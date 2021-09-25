package Hi.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    //저장소 만듬
    //HashMap을 썼는데, 실무에는 동시성 이슈가 있기때문에 컨커런트 해시맵을 써야됨
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
    //회원 저장소는 다 만들얼음. 이제 회워 서비스 만들차례
}
