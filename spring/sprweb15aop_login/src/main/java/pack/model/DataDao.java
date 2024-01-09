package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInterface mappingInterface;
	
	//직원자료 읽기
	public ArrayList<JikwonDto> jikwonListAll(){
		ArrayList<JikwonDto> jlist=(ArrayList<JikwonDto>)mappingInterface.jikwonList();
		return jlist;
	}
	
	//직원로그인
	public JikwonDto jikwonLogin(String jikwon_no) {
		JikwonDto dto=mappingInterface.jikwonLogin(jikwon_no);
		return dto;
	}
}
