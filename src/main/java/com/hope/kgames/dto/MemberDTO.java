package com.hope.kgames.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String userCode;
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userBirth;
	private String userBagcode;
	private String isCompany;
}
