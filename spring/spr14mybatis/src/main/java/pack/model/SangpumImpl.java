package pack.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.resource.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter {

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<SangpumDto> selectList() {
		SqlSession session = factory.openSession();
		List<SangpumDto> list = null;
		try {
			list=session.selectList("selectDataAll"); //결과가 넘어옴
		} catch (Exception e) {
			System.out.println("selectList err:"+e);
		}finally {
			if(session!=null)session.close();
		}
		
		return list;
	}
}
