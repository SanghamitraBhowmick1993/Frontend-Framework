package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	// 1. By locators or OR
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?111");

	
	//2. Constructor of page class
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//3. Page Actions
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isForgotpwdLinkExts(){
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String userName){
		driver.findElement(emailID).sendKeys(userName);
	}
	public void enterPassword(String pwd){
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnLogin(){
		driver.findElement(signInButton).click();
	}
	public AccountsPage doLogin(String unm, String pwd){
		System.out.println("Login with : " + unm + " and " + pwd);
		driver.findElement(emailID).sendKeys(unm);		
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);


	}
}
