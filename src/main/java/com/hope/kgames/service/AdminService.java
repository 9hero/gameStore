package com.hope.kgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dao.AdminDAO;
import com.hope.kgames.dto.BoardDTO;

@Service
public class AdminService {

	ModelAndView mav;

	@Autowired
	AdminDAO adao;

	public void sellerApprove(String mbcode) {
		int result = adao.sellerApprove(mbcode);
		if(result>0){
			
		}else {
			
		}
	}

}
