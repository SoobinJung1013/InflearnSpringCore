package Hi.core.scan.filter;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { //얘네가 붙으면 컴포넌트 스캔에서 제외할겁니다.

}
