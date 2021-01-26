package com.hope.kgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dto.MemberDTO;
import com.hope.kgames.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService msvc;
	
	ModelAndView mav;
	
	@RequestMapping(value="/doJoin")
	public String doJoin (@ModelAttribute MemberDTO mdto) {
		
		return "";
	}
}
