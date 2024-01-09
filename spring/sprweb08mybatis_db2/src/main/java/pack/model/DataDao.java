package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInterface dataMapper;
	// HikariCP는 스프링부트에 기본으로 내장되어 있는 JDBC 데이터베이스 커넥션 풀링 프레임워크이다.
	
	public DataDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<JikwonDto> getDataAll() {
		List<JikwonDto> list = dataMapper.selectAll();
		logger.info("datas : "+list.size() + "개");
		return list;
	}
	
	public List<JikwonDto> getDataSearch(String svalue) {
		List<JikwonDto> list = dataMapper.selectSearch(svalue);
		logger.info("searchdatas : "+list.size() + "개");
		return list;
	}
}
