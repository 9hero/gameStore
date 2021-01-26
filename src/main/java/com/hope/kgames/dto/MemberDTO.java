package com.hope.kgames.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String MB_CODE;
	private String MB_ID;
	private String MB_PWD;
	private String MB_NAME;
	private String MB_EMAIL;
	private String MB_BIRTH;
	private String MB_BGCODE;
}
