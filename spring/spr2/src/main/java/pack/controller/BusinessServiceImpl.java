package pack.controller;

import pack.model.DataDao;

public class BusinessServiceImpl implements BusinessService{
	private DataDao dataDao;
	
	
	
	public BusinessServiceImpl() {
		//파라미터가 없는 생성자, 파라미터가 있는 생성자가 둘다 있어야 할 경우 생략하면 안된다.
	}
	
	
	public BusinessServiceImpl(DataDao dataDao) {
		//생성자를 통해 DB 처리용 영역 클래스의 객체 주소를 치환(injection) , 파라미터가 있는 생성자
		this.dataDao = dataDao;
	}
	
	
	
	
	
	@Override
	public void selectProcess() {
		// DB와 연결해 자료를 읽는 DataDaoImpl 클래스의 selectData method 실행용
		// extends는 단일 상속밖에 안되고 강결합이므로 포오기, 다형성 잊지 말기
		dataDao.selectData();
	}
}
