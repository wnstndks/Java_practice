package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMapperInterface dataMapperInterface;

	public List<SangpumDto> getSangpumAll() {
		List<SangpumDto> slist = dataMapperInterface.selectAll();

		return slist;
	}
}
