package com.hope.kgames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dto.BoardDTO;
import com.hope.kgames.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bsvc;
	
	ModelAndView mav;

	@RequestMapping(value="/boardList")	
	public ModelAndView sellerConfirm(@RequestParam (value="page", required=false,defaultValue="1") int page,
									  @RequestParam ("id") String type) {
		
		mav = bsvc.boardList(page,type);		
		return mav;
	}
	@RequestMapping(value="/boardView")
	public ModelAndView BoardView(@RequestParam("bnum") String bnum,
								  @RequestParam (value="page", required=false,defaultValue="1") int page,
								  @RequestParam (value="id") String type										)
								 {
		
		mav = bsvc.BoardView(bnum,page,type);		
		return mav;
	}
	@RequestMapping(value="/goWriteForm")
	public ModelAndView goWriteForm(@RequestParam("type") String type) {
		mav.addObject("type",type);
		mav.setViewName("board/BoardWrite");
		return mav;
	}
	@RequestMapping(value="/boardWrite")
	public ModelAndView boardWrite(
			@ModelAttribute BoardDTO writeInfo,
			MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		List<MultipartFile> files = request.getFiles("BFILE");
		mav = bsvc.boardWrite(writeInfo,files);
		System.out.println("제발" + files);
		for(MultipartFile mf : files) {
			System.out.println("제발시발!"+ mf.getOriginalFilename());
		}
		
		//해야될것 인펏파일을 폼에다 넣기 따로말고
		//파일리스트는 못건들고 따로 빼서 데이터폼에 append 시키고 이름값 삭제하면 될듯 더좋은데?
		// 근데 문제 생김: append한 것을 못받아옴
		//mav = bsvc.boardWrite(writeInfo);
		return mav;
		
	}
}
