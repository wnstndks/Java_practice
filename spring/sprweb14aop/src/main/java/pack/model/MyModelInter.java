package pack.model;

public interface MyModelInter {
	String processMsg();  // 인터페이스의 추상메소드가 주로 포인트컷의 대상임
	String businessMsg();  // 관심사항이 인터셉트 되는 곳,,,
}
