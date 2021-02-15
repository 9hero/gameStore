package com.hope.kgames;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dto.BoardDTO;
import com.hope.kgames.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	@Autowired
	ShopService ssvc;
	
	ModelAndView mav;
	
	@RequestMapping(value="joinSeller")
	public String joinSeller(){
		return "shop/JoinSellerForm";
	}
	@RequestMapping(value="doJoinSeller")
	public ModelAndView joinSeller(@ModelAttribute BoardDTO joinForm){
		mav = ssvc.joinSeller(joinForm);
		return mav;
	}
	@RequestMapping(value="myCompany")
	public String myCompany(){
		return "shop/MyCompany";
		
	}
	@RequestMapping(value="test")
	public void test() {
		System.out.println("test람쥐");
	}
}
