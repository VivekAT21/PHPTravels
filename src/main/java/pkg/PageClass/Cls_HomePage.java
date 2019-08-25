package pkg.PageClass;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pkg.BaseClass.Cls_Base;

public class Cls_HomePage extends Cls_Base {

	public Cls_HomePage() throws FileNotFoundException {
		super();
	}

	@FindBy(xpath="//a[@class='navbar-brand go-right']")
	WebElement imgLogo;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//li[@id='li_myaccount']")
	WebElement dropdownMyAccount;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//ul[@class='dropdown-menu']//li[1]")
	WebElement linkLogin;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//ul[@class='dropdown-menu']//li[1]")
	WebElement linkSignUp;
	
	@FindBy(xpath="//div[@class='col-md-12']//a[@title='Hotels']")
	WebElement titleHotel;
	
	@FindBy(xpath="//div[@class='select2-container hotelsearch locationlistthhotels']//span[@class='select2-chosen']")
	WebElement clickHotelField;
	
	@FindBy(xpath="//div[@id='select2-drop']//input")
	WebElement enterHotel; //search via: marriott
	
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul[@class='select2-results']//li[@class='select2-no-results']")
	WebElement textnoHotelFound;
	
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul[@class='select2-result-sub']")
	WebElement selectHotel; 
	
	public boolean verifyLogo() {
		return verifyImage(imgLogo);
	}
	
	public void openMyAccount() {
		clickLink(dropdownMyAccount);
	}
	
	public Cls_LoginPage redirectLogin() {
		clickLink(linkLogin);
		return new Cls_LoginPage();
	}
	
	public Cls_SignUpPage redirectSignUp() {
		clickLink(linkSignUp);
		return new Cls_SignUpPage();
	}
	
	public void clickHotels() {
		clickLink(titleHotel);
	}
	
	public void searchHotel(String HotelName) {
		clickLink(clickHotelField);
		enterValue(enterHotel, HotelName);
	}
	
	public void getNoHotel() {
		getText(textnoHotelFound);
	}
	
	public void getHotel() {
		getText(selectHotel);
	}
	
	public void selectHotel() {
		clickLink(selectHotel);
	}
	
}
