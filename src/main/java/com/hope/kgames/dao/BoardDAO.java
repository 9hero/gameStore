package com.hope.kgames.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hope.kgames.dto.BoardDTO;
import com.hope.kgames.dto.PageDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sql;

	public BoardDTO BoardView(String bnum) {
		// TODO Auto-generated method stub
		return sql.selectOne("board.View",bnum);
	}

	public int viewHit(String bnum) {
		// TODO Auto-generated method stub
		return sql.update("board.upHit",bnum);
	}

	public int getCountRow(String type) {
		// TODO Auto-generated method stub
		return sql.selectOne("board.CountRow",type);
		
	}

	public List<BoardDTO> getBoard(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.selectList("board.getBoard", map);
	}

	public int boardWrite(BoardDTO writeInfo) {
		// TODO Auto-generated method stub
		return sql.insert("board.Write",writeInfo);
	}
	
	
}
