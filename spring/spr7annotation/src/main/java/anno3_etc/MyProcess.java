package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("anno3_other")
public class MyProcess {
	@Value("#{dataInfo.name}") // spEL : 동적으로 표현식을 해석 #{표현식} DataInfo 클래스의 getName() 호출
	private String name;
	private String part;
	
	
	public MyProcess() {
		// TODO Auto-generated constructor stub
	}
	
	@Value("1,2,3,4,5")
	private int arr[];
	
	@Value("#{dataInfo.job}")
	private String myJob;
	
	@Autowired
	//public MyProcess(@Value("총무부") String part){ //우선순위는 환경설정파일보다 낮다
	public MyProcess(@Value("#{dataInfo.name}") String part){ 
		this.part=part;
	}
	
	public void showResult() {
		System.out.println("part : "+ part);
		System.out.println("name : "+ name);
		System.out.println("job : "+ myJob);
		System.out.println(arr[0]+arr[3]);
	}
	
}
