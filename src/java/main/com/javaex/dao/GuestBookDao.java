package com.javaex.dao;

import java.util.List;

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
