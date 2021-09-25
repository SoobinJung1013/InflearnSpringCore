package Hi.core;

import Hi.core.member.Grade;
import Hi.core.member.Member;
import Hi.core.member.MemberService;
import Hi.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //전자가 인터페이스 후자가 구현
        //MemberService memberService = new MemberServiceImpl();
        //member 인스턴스 생성 및 값 넣어줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "soobin", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member : " + member.getName());
        System.out.println("find Member : " + findMember.getName());
    }
}
