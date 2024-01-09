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
public class JikwonImpl implements JikwonInter {

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectList() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;

		try {
			
			SqlMapperInter inter=(SqlMapperInter)session.getMapper(SqlMapperInter.class);
			list= inter.selectAll();
		} catch (Exception e) {
			System.out.println("selectList err:" + e);
		} finally {
			if (session != null)
				session.close();
		}

		return list;
	}

	@Override
	public List<JikwonDto> selectList2() {
		SqlSession session2 = factory.openSession();
		List<JikwonDto> list2 = null;

		try {
			SqlMapperInter inter=(SqlMapperInter)session2.getMapper(SqlMapperInter.class);
		} catch (Exception e) {
			System.out.println("selectList2 err:" + e);
		} finally {
			if (session2 != null)
				session2.close();
		}

		return list2;
	}

	@Override
	public List<JikwonDto> selectList3() {
		SqlSession session3 = factory.openSession();
		List<JikwonDto> list3 = null;

		try {
			SqlMapperInter inter=(SqlMapperInter)session3.getMapper(SqlMapperInter.class);
		} catch (Exception e) {
			System.out.println("selectList3 err:"+e);
		}finally {
			if(session3!=null)session3.close();
		}
		
		return list3;
	}
}
