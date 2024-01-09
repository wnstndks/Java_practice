package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.model.JikwonDto;

public interface SqlMapperInter {
   @Select("select jikwon_no, jikwon_name, ifnull(buser_name,'무소속') as buser_name, substr(jikwon_ibsail,1,4) as jikwon_year from jikwon left outer join buser on buser_num=buser_no")
   List<JikwonDto> selectAll();
   
   @Select("select buser_name, count(*) as jikwon_su from buser join jikwon on buser_no=buser_num group by buser_name")
   List<JikwonDto> select();
   
   @Select("select buser.buser_name, jikwon_name, jikwon_pay from jikwon inner join buser on buser.buser_no = buser_num where (jikwon_pay, jikwon.buser_num) in (select max(jikwon_pay), buser_num from jikwon group by buser_num)")
   List<JikwonDto> selectbuser();   
}

   