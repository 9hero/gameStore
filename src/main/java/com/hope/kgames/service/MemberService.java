package com.hope.kgames.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dao.MemberDAO;

@Service
public class MemberService {
	ModelAndView mav;
	@Autowired
	MemberDAO mdao;
	
	@Autowired
	HttpSession session;
}
