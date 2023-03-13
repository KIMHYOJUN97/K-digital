package cbg.chap02;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /**
         * spring container를 만드는 객체
         * spring 내에서 설정 클래스에 등록된 Bean들이 자동 관리됨.
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter greeter = context.getBean("greeter", Greeter.class);

        String msg = greeter.greet("스프링");
        System.out.println(msg);

        context.close();
    }
}
