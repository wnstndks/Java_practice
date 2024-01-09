package pack;

public class MyProcessService {
	private int nai;
	private String name;
	private ShowData showData;
	
	public MyProcessService() {
		
	}
	
	
	public void setNai(int nai) { //private 멤버값은 외부에서 setter를 사용해 입력(setter injection)
		this.nai = nai;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " +name+", 나이는 "+nai+", 별명은 "+showData.processName()+", 취미는 "+showData.processHobby());
	}
	
}
