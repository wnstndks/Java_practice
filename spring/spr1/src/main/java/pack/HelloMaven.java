package pack;

public class HelloMaven implements HelloInter{
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕"+name+"님");
		
	}
}
