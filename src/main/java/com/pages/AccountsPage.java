package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;

public class AccountsPage {
	

	private WebDriver driver;
	
	private By accountSection = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
	}
	public String getAccPageTitle(){
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount(){
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountsSectionList(){
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accountSectionList = driver.findElements(accountSection);
		for(WebElement e : accountSectionList ){
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}
}
