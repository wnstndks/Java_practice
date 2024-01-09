package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArrangeMain {

   public static void main(String[] args) {
      // spring이 생성한 객체를 호출 후 실행
      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
      
      /*
      // singleton 확인
      MessageImpl impl1 = new MessageImpl("tom");
      impl1.sayHi();

      MessageImpl impl2 = new MessageImpl("oscar");
      impl2.sayHi();
      
      System.out.println("객체 주소 : " + impl1.toString() + " " + impl2);
      // 객체 주소 : pack.MessageImpl@1573f9fc pack.MessageImpl@6150c3ec 객체가 별도로 생성
      
      System.out.println("-----------");
      MessageImpl spr_impl1 = (MessageImpl)context.getBean("msgImpl");
      spr_impl1.sayHi();
   
      MessageImpl spr_impl2 = (MessageImpl)context.getBean("msgImpl");
      spr_impl2.sayHi();
      
      System.out.println("객체 주소(spring) : " + spr_impl1.toString() + " " + spr_impl2);
      // 객체 주소(spring) : pack.MessageImpl@44c03695 pack.MessageImpl@44c03695 두 변수의 주소가 동일 (기본이 싱글톤이라는 의미)
      */
      
      System.out.println("다형성 캐스팅 관련 ....");
      MessageImpl spr_impl3 = (MessageImpl)context.getBean("msgImpl");
      spr_impl3.sayHi();
      
      System.out.println(); //MessageImpl의 super 클래스를 사용
      MessageInter inter1= (MessageInter)context.getBean("msgImpl");
      inter1.sayHi();
      MessageInter inter2= (MessageInter)context.getBean("msgImpl");
      inter2.sayHi();
      
   }
}












