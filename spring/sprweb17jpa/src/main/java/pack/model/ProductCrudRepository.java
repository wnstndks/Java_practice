package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer>{
	@Query(value="select p from ProductVo as p")
	List<ProductVo> findAllData();
	
	@Query(value="select p from ProductVo as p where p.code=:code")
	ProductVo findByCode(int code);
	
	@Query(value="select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findData(int code,String sang);
	
	@Query(value="select code,sang,su,dan from Product where code<=5",nativeQuery=true)
	List<ProductVo> findData2();
	
}
