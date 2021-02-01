package com.hope.kgames.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hope.kgames.dao.BoardDAO;
import com.hope.kgames.dto.BoardDTO;
import com.hope.kgames.dto.PageDTO;
import com.hope.kgames.dto.UploadFileDTO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO bdao;
	
	ModelAndView mav;
	
	//페이징
	private static final int rowPP = 10; //rowPerPage 페이지 당 게시글 갯수
	private static final int pbuttonPP = 5; //pageButtomPerPage 페이지 버튼 갯수 1~5, 6~10
	public PageDTO paging(int totalRowNum,int page) {
		PageDTO pto = new PageDTO();
		int gRow_lo = (page-1)*rowPP+1; //getRow_lowRange
		pto.setGRow_lo(gRow_lo);
		// 가져올 범위중 높은 숫자 10,20,30......
		int gRow_Hi = page*rowPP; //getRow_HighRange
		pto.setGRow_Hi(gRow_Hi);
		int lastPage = (int)Math.ceil((double)totalRowNum/(double)rowPP);
		pto.setLastPage(lastPage);
		int pageBtnStart = (int)Math.ceil((double)page/(double)pbuttonPP)*pbuttonPP-pbuttonPP+1; //1,6,11버튼
		int pageBtnEnd = (int)Math.ceil((double)page/(double)pbuttonPP)*pbuttonPP; // 5,10,15...마지막		
		pto.setPageBtnStart(pageBtnStart);
		pto.setPageBtnEnd(pageBtnEnd);
		if(pageBtnEnd >= lastPage) {
			pto.setPageBtnEnd(lastPage);
		}pto.setPage(page);
		return pto;
	}
	//게시판 목록가져오기
	public ModelAndView boardList(int page, String type) {
		mav = new ModelAndView();
		HashMap<String,Object> map= new HashMap<String,Object>();
		
		List<BoardDTO> boardList = null;
		PageDTO pto = null;
		
		//게시판 타입에 맞는 총 글 갯수 
		int totalRowNum = bdao.getCountRow(type);
		
		// 페이징
		pto = paging(totalRowNum,page);
		
		// type에 따라 가져올 게시판 목록 종류 변경
		map.put("pto", pto);
		map.put("type", type);
		
		boardList = bdao.getBoard(map);
		
		if(boardList != null) {
		mav.addObject("BoardList", boardList);
		mav.addObject("page",pto);
		mav.addObject("type", type);
		mav.setViewName("board/BoardPage");
		}else{
			mav.setViewName("Fail");
		}
		return mav;		
	}
	
	public ModelAndView BoardView(String bnum, int page, String type) {
		// 게시글에서 다른 글 보기 살펴보기
		mav = boardList(page, type);
		
		// 게시판 글 내용가져오기
		BoardDTO boardInfo = bdao.BoardView(bnum);
		if(boardInfo != null) {			
			bdao.viewHit(bnum); // 조회수 상승
			mav.addObject("id", type); // 타입 저장
			mav.addObject("BoardInfo", boardInfo); // 
			mav.setViewName("board/view");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
		
	}
	public ModelAndView boardWrite(BoardDTO writeInfo) {
		mav = new ModelAndView();
		int result = bdao.boardWrite(writeInfo);
		if(result>0) {
			mav.setViewName("done");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
		
	}
	public UploadFileDTO imgStore(MultipartFile file) {
		UploadFileDTO saveFile = new UploadFileDTO();
		

		String originName = file.getOriginalFilename();		
		String saveFileName = System.currentTimeMillis() + "_" + originName;
		String savePath = "G:\\project\\kgames\\src\\main\\webapp\\resources\\File" + saveFileName;
		if(!file.isEmpty()) {
			file.transferTo(new File(savePath));
		}		
		saveFile.setFI_NAME(saveFileName);
		saveFile.setFI_ONAME(originName);
		saveFile.setFI_URL(savePath);
		saveFile.setFI_SIZE(file.getSize());
		
		saveFile = bdao.imgStore(saveFile);
		return saveFile;
	}

	
	
}
