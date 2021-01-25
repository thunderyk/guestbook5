package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sql;
	
	public void guestInsert(GuestBookVo guestBookVo) {
		sql.insert("guestbook.insert", guestBookVo);
	}
	public void guestInsertMap(String name, String password, String content) {
		
		Map<String,Object> mapInsert = new HashMap<String,Object>() ;
		mapInsert.put("name", name);
		mapInsert.put("password", password);
		mapInsert.put("content", content);
		
		sql.insert("guestbook.insertMap",mapInsert);
	}
	
	public List<GuestBookVo> getGuestBookList(){
		
		return sql.selectList("guestbook.getAllList");
	}
	public GuestBookVo getGuestBook(int num) {
		return sql.selectOne("guestbook.getVo",num);
	}
	
	public void deleteGuestBook(int num) {
		sql.delete("guestbook.delete", num);
	}
}
