package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMappingInterface {
	
	//추상 메소드의 이름은 mapper.xml의 id명과 일치시킨다.
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	
	int insert(BoardBean bean); //mapper의 아이디 명과 맞아야 한ㄷ다. insert가
	void updateReadcnt(String num);
	int update(BoardBean bean); //mapper의 아이디 명과 맞아야 한ㄷ다. insert가
	int delete(String num); 
	
	
}
