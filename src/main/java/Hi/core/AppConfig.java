package Hi.core;

import Hi.core.discount.DiscountPolicy;
import Hi.core.discount.FixDiscountPolicy;
import Hi.core.discount.RateDiscountPolicy;
import Hi.core.member.MemberRepository;
import Hi.core.member.MemberService;
import Hi.core.member.MemberServiceImpl;
import Hi.core.member.MemoryMemberRepository;
import Hi.core.order.OrderService;
import Hi.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//AppConfig는 애플리케이션의 실제 동작ㅇ에 필요한 구현 객체를 생성한다.
//AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)헤준다.

@Configuration //설정정보
public class AppConfig {

    @Bean
    //전에는 일플레서 직접 섭외(?) 설정함.
    public MemberService memberService() {
        //난 멤버 서비스 임플인데, 난 메모리멤머리포지터리를 쓸거야 !
        return new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    //생성자 주입
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
//역할이 다 드러남
}
