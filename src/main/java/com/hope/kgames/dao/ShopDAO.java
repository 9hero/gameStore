package com.hope.kgames.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hope.kgames.dto.BoardDTO;

@Repository
public class ShopDAO {
	
	@Autowired
	SqlSessionTemplate sql;
	
	public int joinSeller(BoardDTO joinForm) {
		// TODO Auto-generated method stub
		return sql.insert("shop.joinSeller",joinForm);
	}

}
