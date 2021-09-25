package Hi.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//구현체가 하나만 있을때는 인터페이스 명 뒤에 임플이라고 관례상 많이 씀
public class MemberServiceImpl implements MemberService{

    //memberRepository 인터페이스가 필요함.
    //인터페이스만 있으면 널포인트 익셉션 남 -> 구현 객체를 선택을 해줘야 함.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();


    //디카프리오 오드리햅번
    private final MemberRepository memberRepository;

    //생성자를 만듬
    //메모리 구현체에 뭐가 들어갈지를 생성자를 통해서 만듬
    @Autowired //ac.getBean(MemoryReopsitory.class) //알아서 MemoryMemberRepository
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //조인해서 세이브를 호출하면 다형성에 의해서 이 MemoryMemberRepository 에 있는 (인터페이스가 아니라) save(오버라이드한게)가 호출이됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
