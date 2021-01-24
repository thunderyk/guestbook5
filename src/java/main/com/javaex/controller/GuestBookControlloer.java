package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping("/guest")
public class GuestBookControlloer {

	@Autowired
	private GuestBookDao guestbookDao;
	
	@RequestMapping(value = "/addList", method= {RequestMethod.GET,RequestMethod.POST})
	public String addList(Model model) {
		
		List<GuestBookVo> guestBookList = guestbookDao.getGuestBookList();
		
		model.addAttribute("guestbookList",guestBookList);
		
		return "addList";
	}
	
	@RequestMapping(value = "/add", method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@RequestParam("name") String name,
					  @RequestParam("password") String password,
					  @RequestParam("content") String content) {
		
		GuestBookVo guestBookVo = new GuestBookVo(name,password,content);
		
		guestbookDao.guestInsert(guestBookVo);
		
		return "redirect:./addList";
	} //add 방법 1
	
	@RequestMapping(value = "/add2", method= {RequestMethod.GET,RequestMethod.POST})
	public String add2(@ModelAttribute GuestBookVo guestBookVo) {
		
		guestbookDao.guestInsert(guestBookVo);
		
		return "redirect:./addList";
	} //add 방법 2
	
	@RequestMapping(value = "/deleteForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String deleteForm() {
		
		return "deleteForm";
	}
	
	@RequestMapping(value = "/delete", method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("password") String password,
			 			 @RequestParam("no") int no,
			 			 Model model) {
		
		
		GuestBookVo guestBookVo = guestbookDao.getGuestBook(no);
		
		if(password.equals(guestBookVo.getPassword())) {
			//비밀번호가 맞으면 삭제
			guestbookDao.deleteGuestBook(no);
			return "redirect:./addList";
		}else {
			//비밀번호가 틀리면 alert페이지로 포워드
			model.addAttribute("alert","wrong");
			return "alert";
		}
		
	}
}
