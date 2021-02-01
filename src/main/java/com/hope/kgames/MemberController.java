package com.hope.kgames;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dto.MemberDTO;
import com.hope.kgames.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService msvc;
	
	ModelAndView mav;
	
	@RequestMapping(value="/doJoin")
	public ModelAndView doJoin (@ModelAttribute MemberDTO mib) {
		mav = msvc.doJoin(mib);
		return mav;
	}
	@RequestMapping(value="/doLogin")
	public ModelAndView doLogin(@ModelAttribute MemberDTO mib){
		mav = msvc.doLogin(mib);
		return mav;
	}
	@RequestMapping(value="/logout")
	public String logout(){
		msvc.logout();
		return "home";
	}
	
	@RequestMapping(value="/idCheck")
	public @ResponseBody String idCheck(@RequestParam("userId") String id) {		
		String checkedId = msvc.idCheck(id); 
		return checkedId;
	}
	@RequestMapping(value= "/joinAndlogin")
	public String join() {
		return "member/Join_login";
	}
}
