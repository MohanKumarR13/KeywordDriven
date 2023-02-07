package com.excecution;

import java.io.IOException;

import Keyword.ActionKeyword;
import Utillity.Utill;

public class Engine {
public static void main(String[] args) throws IOException {
	Utill util=new Utill();
	util.fileLoc("C:\\Users\\Mohan\\eclipse-workspace\\KeywordDrivenFramework\\Sheets\\Keyworddriven.xlsx");
	
	for(int row=1;row<=5;row++){
		String keyWord=util.getCellValueExcelSheet(row, 3);
		
		if(keyWord.equalsIgnoreCase("openBrowser")){
			ActionKeyword.openBrowser();
		}else if(keyWord.equalsIgnoreCase("gotoUrl")){
			ActionKeyword.gotoUrl();
		}else if(keyWord.equalsIgnoreCase("enterUserName")){
			ActionKeyword.enterUserName();
		}else if(keyWord.equalsIgnoreCase("enterPassword")){
			ActionKeyword.enterPassword();
		}else if(keyWord.equalsIgnoreCase("clickSignIn")){
			ActionKeyword.clickSignIn();;
		}
	}
}
}