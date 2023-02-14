package com.excecution;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import Keyword.ActionKeyword;
import Utillity.Locators;
import Utillity.Utill;

public class Engine {
	static ActionKeyword actionKeyword;
	static Method[] methods;
	static String keyWord;
	public static By loct;
	public static void getActionKeyword() {
		 actionKeyword=new ActionKeyword();
		 methods=actionKeyword.getClass().getMethods();
	}
	
	public static void getExcecuteKeyword() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(int i=0;i<methods.length;i++) {
			if(methods[i].getName().equalsIgnoreCase(Utill.keywordColumnValue)) {
				methods[i].invoke(actionKeyword);
				break;
			}
		}
	}
	
	public void findWebElement() {
		switch (Utill.locatorName) {
		case "name":
				loct=Locators.getName(Utill.locatorValue);
			break;
			
	case "xpath":
		loct=Locators.getXpath(Utill.locatorValue);

			break;

		default:
			break;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Utill util = new Utill();
		//Utill.fileLoc("C:\\KeywordDrivenFramework\\KeywordDriven\\KeywordDrivenFramework\\Sheets\\Keyworddriven.xlsx");
		 Utill.fileLoc("C:\\KeywordDrivenFramework\\KeywordDriven\\KeywordDrivenFramework\\Sheets\\Keyworddriven.xlsx");
		 Engine engine=new Engine();
		 int locatorcolumn=3;
		 int keywordColumn=locatorcolumn+1;
		 int dataColumn=locatorcolumn+2; 

		 
		 Engine.getActionKeyword();
		for (int row = 1; row <= Utill.totalRows; row++) {
			util.getCellValueExcelSheet(row, locatorcolumn,keywordColumn,dataColumn);
			engine.findWebElement();
			 engine.getExcecuteKeyword(); 


		}
	}
}
