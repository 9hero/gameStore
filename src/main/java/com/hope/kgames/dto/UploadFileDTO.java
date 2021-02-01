package com.hope.kgames.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UploadFileDTO {

	String FI_CODE;
	String FI_ONAME;
	String FI_NAME;
	long FI_SIZE;
	String FI_GOCODE;
	String FI_BONUM;
	String FI_URL;
}
