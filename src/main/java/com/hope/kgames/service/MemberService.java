package com.hope.kgames.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dao.MemberDAO;
import com.hope.kgames.dto.CompanyDTO;
import com.hope.kgames.dto.MemberDTO;

@Service
public class MemberService {
	ModelAndView mav;
	@Autowired
	MemberDAO mdao;
	
	@Autowired
	HttpSession session;
	
	public ModelAndView doJoin(MemberDTO mib){
		mav = new ModelAndView();		
		int result  = mdao.doJoin(mib);
		if(result>0) {
			mav.addObject("joinDone", "wellDone");
			mav.setViewName("member/Join_login");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}
	
	public String idCheck(String id) {
		String checkedId = mdao.idCheck(id);
		return checkedId;
	}


	public ModelAndView doLogin(MemberDTO mib) {
		mav = new ModelAndView();
		MemberDTO userInfo = mdao.doLogin(mib);
		
		if(userInfo != null) {	
			System.out.println("값들어옴");
		session.setAttribute("userName", userInfo.getUserName());
		session.setAttribute("userID", userInfo.getUserId());
		session.setAttribute("userCode", userInfo.getUserCode());
		session.setAttribute("isCompany", userInfo.getIsCompany());
		mav.setViewName("home");
		System.out.println(userInfo.getIsCompany() + "iscom");
		if(userInfo.getIsCompany().equals("1")) {
			System.out.println("in the if");
			CompanyDTO com  = mdao.getCompany(userInfo.getUserCode());
			session.setAttribute("coCode", com.getCO_CODE());
			session.setAttribute("coName", com.getCO_NAME());
		}
		}else {			
			mav.addObject("loginFail","아이디나 비밀번호가 틀렸습니다");
			mav.setViewName("member/Join_login");
		}
		return mav;
	}

	public void logout() {
		session.invalidate();		
	}
}
