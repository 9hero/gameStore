package com.hope.kgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.service.AdminService;

@Controller	
public class AdminController {
	
	ModelAndView mav;

	@Autowired
	AdminService asvc;
	
	@RequestMapping(value="/Adminmanage")
	public String Adminmanage() {
		return "admin/management";
	}
	@RequestMapping(value="/sellerApprove")
	public String sellerApprove(@RequestParam("mbcode") String mbcode) {
		asvc.sellerApprove(mbcode);
		return "done";
	}
}
