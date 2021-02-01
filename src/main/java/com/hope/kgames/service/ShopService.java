package com.hope.kgames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dao.ShopDAO;
import com.hope.kgames.dto.BoardDTO;

@Service
public class ShopService {
	
	ModelAndView mav;
	
	@Autowired
	ShopDAO sdao;
	
	
	public ModelAndView joinSeller(BoardDTO joinForm) {
		mav = new ModelAndView();
		int result = sdao.joinSeller(joinForm);
		if(result>0) {
			mav.setViewName("done");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}

}
