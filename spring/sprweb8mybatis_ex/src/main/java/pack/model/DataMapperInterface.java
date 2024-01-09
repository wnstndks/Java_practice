package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select *from jikwon join buser on buser.buser_no=jikwon.buser_num")
	List<JikwonDto> selectAll();

	//MariaDb, MySql인 경우 where sang like concat('%',#{svalue},'%')
	//Oracle인 경우 where sang like '%'||#{svalue}||'%'
	
	@Select("select jikwon_no,jikwon_name,jikwon_jik,buser_name,jikwon_pay from jikwon join buser on buser.buser_no=jikwon.buser_num where jikwon_name like concat(#{svalue},'%')")
	List<JikwonDto> selectSearch(String svalue);
	

}
