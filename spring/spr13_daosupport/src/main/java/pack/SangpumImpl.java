package pack;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

//spring framework이 지원하는 jdbcDaosupport

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	@Autowired

	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<SangpumDto> selectList() {
	
		RowMapper rowMapper= new SangpumRowMapper();
		return getJdbcTemplate().query("select*from sangdata", rowMapper);

	}

	class SangpumRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs,int rowNum) throws SQLException{
			System.out.println("rowNum :"+rowNum);
			
			SangpumDto dto=new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
		
	}
}
