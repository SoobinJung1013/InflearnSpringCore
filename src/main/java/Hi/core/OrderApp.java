package Hi.core;

import Hi.core.member.Grade;
import Hi.core.member.Member;
import Hi.core.member.MemberService;
import Hi.core.member.MemberServiceImpl;
import Hi.core.order.Order;
import Hi.core.order.OrderService;
import Hi.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        //MemberService memberService = new MemberServiceImpl(null);
        //OrderService orderService = new OrderServiceImpl(null, null);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "dpr ian", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "love", 300000);

        System.out.println("order = " + order);
        System.out.println("oder.calCulatePrice=" + order.calculatePrice());

    }
}
