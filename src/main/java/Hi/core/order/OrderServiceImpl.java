package Hi.core.order;

import Hi.core.discount.DiscountPolicy;
import Hi.core.discount.FixDiscountPolicy;
import Hi.core.discount.RateDiscountPolicy;
import Hi.core.member.Member;
import Hi.core.member.MemberRepository;
import Hi.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{

    //final 이면 무조건 생성자를 통해서 할당이 되어야함
    private final MemberRepository memberRepository;
    //= new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy; //인터페이스에만 의존하도록 설계와 코드를 변경함
    //근데 이렇게만 하면 널포인트 익셉션 (세상에서 제일 무서운?)


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보를 조회를 하고
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정책에다가 회원정보를 그냥 넘김
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
