package com.hope.kgames.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hope.kgames.dto.BoardDTO;

@Repository
public class AdminDAO {

	@Autowired
	SqlSessionTemplate sql;


	public int sellerApprove(String mbcode) {
		// TODO Auto-generated method stub
		return sql.update("admin.Approve",mbcode);
	}

}
