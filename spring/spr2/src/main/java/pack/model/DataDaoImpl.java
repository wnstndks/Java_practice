package pack.model;

public class DataDaoImpl implements DataDao{
	@Override
	public void selectData() {
		System.out.println("db와 연결한 후 selectData 수행");
	}
}
