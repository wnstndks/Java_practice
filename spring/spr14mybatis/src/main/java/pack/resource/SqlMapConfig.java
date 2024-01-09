package pack.resource;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	public static SqlSessionFactory sqlSession; // DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.

	static {
		String resource = "pack/resource/Configuration.xml"; //db연결과 select등과 같은 sql문이 들어있음 이 모든 것을 하는 이유는 java에서 sql문을 빼내기 위함임
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("SqlMapConfig 오류 : " + e);
		}
	}

	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
}

//mybatis 환경설정 완, web이 아닌 application에서 만든것