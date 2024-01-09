package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb17jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb17jpaApplication.class, args)
		.getBean(Sprweb17jpaApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository repository;
	
	private void myExecute() {
		System.out.println("독립 프로그램으로 실행이 됨");
		
		//insertData();
		
		deleteData();
		
		selectData();
	}
	
	private void insertData() {
		// 엔티티 생성
		ProductVo productVo = new ProductVo();
		productVo.setSang("지우개2");
		productVo.setSu(20);
		productVo.setDan(2000);
		productVo=repository.save(productVo); //insert
		System.out.println("등록 데이터 :"+productVo);
		
		productVo.setCode(3);
		productVo.setSang("신상");
		productVo.setSu(6);
		productVo.setDan(5000);
		productVo=repository.save(productVo); //update
		System.out.println("등록 데이터 :"+productVo);
	}
	
	private void deleteData() {
		repository.deleteById(5);
	}
	
	private void selectData() {
		System.out.println("전체 레코드 읽기");
		List<ProductVo> list=repository.findAll();
		
		for(ProductVo vo:list) {
			System.out.println(vo.getCode()+" "+vo.getSang()+" "+vo.getDan()+" "+vo.getSu());
		}
		
		//System.out.println("특정 레코드 한 개 읽기");
		//ProductVo vo=repository.findById(1).get();
		//System.out.println(vo.getCode()+" "+vo.getSang()+" "+vo.getDan()+" "+vo.getSu());
		
		System.out.println("JPQL: (java persistence query language)");
		
		List<ProductVo> list2=(List<ProductVo>)repository.findAllData();
		
		for(ProductVo vo:list2) {
			System.out.println(vo.getCode()+" "+vo.getSang()+" "+vo.getDan()+" "+vo.getSu());
		}
		
		ProductVo vo2=repository.findByCode(2);
		
		
		System.out.println();
		List<ProductVo> list3=repository.findData(2,"우산");
		for(ProductVo vo3:list3) {
			System.out.println(vo3.getCode()+" "+vo3.getSang()+" "+vo3.getDan()+" "+vo3.getSu());
		}
	}

}
