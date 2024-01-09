package pack;

/*
 AOP는 Aspect Oriented Programming의 약자로 관점 지향 프로그래밍이라고 불린다. 관점 지향은 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 모듈화 하겠다는 것이다.
	모듈화 : 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것 
	예를 들어 핵심적인 관점은 비즈니스 로직이 될 수 있고, 부가적인 관점은 핵심 로직을 실행하기 위해 행해지는 데이터베이스 연결(트랜잭션), 로깅, 파일 입출력, 보안 등이 될 수 있다. 
*/

//핵심 로직 클래스 : AOP 입장에서 Target
public class MessageImpl implements MessageInter {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHi() {
		System.out.println("안녕 " + name + "님 핵심 로직 처리 중");
		// 처리가 다소 길다는 가정하에 시간끌기
		int t = 0;
		while (t < 5) {
			try {
				Thread.sleep(1000);
				System.out.print(".");
				t++;

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("sayHi처리완료");
		System.out.println();
	}
}
