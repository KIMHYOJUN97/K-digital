package cbg.chap03.main;

import cbg.chap03.config.AppConf1;
import cbg.chap03.config.AppConf2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForGetBean {

    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);

    public static void main(String[] args) {
        AppConf1 conf1 = context.getBean(AppConf1.class);

        if (conf1 != null) {
            System.out.println("conf1 빈이 존재합니다.");
        }
        else{
            System.out.println("conf1 빈이 존재하지 않습니다.");
        }
    }
}
