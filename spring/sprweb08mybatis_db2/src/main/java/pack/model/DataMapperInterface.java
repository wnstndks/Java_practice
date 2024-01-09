package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select jikwon_no, jikwon_name, jikwon_jik, buser_name, jikwon_pay from jikwon inner join buser on buser_no = buser_num")
	List<JikwonDto> selectAll();
	
	@Select("select jikwon_no, jikwon_name, jikwon_jik, buser_name, jikwon_pay from jikwon inner join buser on buser_no = buser_num where jikwon_name like concat(#{svalue},'%')")
	List<JikwonDto> selectSearch(String svalue);
}
