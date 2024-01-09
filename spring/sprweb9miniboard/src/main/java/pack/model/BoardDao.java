package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMappingInterface mappingInterface;
	
	public List<Board> list(){ //전체 자료 읽기
		List<Board> list=null;
		
		try {
			list=mappingInterface.selectList();
			logger.info("list size :"+list.size());
		} catch (Exception e) {
			logger.info("list err :"+e);
		}
		
		return list;
	}
	
	@Transactional
	public boolean insertData(BoardBean bean) {
		boolean b=false;
		int re=mappingInterface.insert(bean);
		if(re>0)b=true;
		return b;
	}
	
	public List<Board> search(BoardBean bean){
		List<Board> slist=mappingInterface.selectSearch(bean);
		
		return slist;
	}
	
	public Board detail(String num) { //상세보기용
		mappingInterface.updateReadcnt(num); //조회수 증가
		Board board=mappingInterface.selectOne(num);
		return board;
	}
	
	@Transactional
	public boolean update(BoardBean bean) {
		boolean b=false;
		int re=mappingInterface.update(bean);
		if(re>0)b=true;
		return b;	
	}
	
	@Transactional
	public boolean delete(String num) {
		boolean b=false;
		int re=mappingInterface.delete(num);
		if(re>0)b=true;
		return b;	
	}
	
}

















