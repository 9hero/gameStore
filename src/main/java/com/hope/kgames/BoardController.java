package com.hope.kgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView boardWrite(@ModelAttribute BoardDTO writeInfo) {
		mav = bsvc.boardWrite(writeInfo);
		return mav;
		
	}
	@PostMapping(value="/imgStore")
	@ResponseBody
	public ResponseEntity<?> imgStore(@RequestParam("uploadFile") MultipartFile file) {
		bsvc.imgStore(file);
		return null;
	}
}
