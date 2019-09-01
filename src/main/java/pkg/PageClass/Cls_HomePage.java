package pkg.PageClass;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pkg.BaseClass.Cls_Base;

public class Cls_HomePage extends Cls_Base {

	public Cls_HomePage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='navbar-brand go-right']")
	WebElement we_imgLogo;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//li[@id='li_myaccount']")
	WebElement we_dropdownMyAccount;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//ul[@class='dropdown-menu']//li[1]")
	WebElement we_linkLogin;
	
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//ul[@class='dropdown-menu']//li[2]")
	WebElement we_linkSignUp;
	
	@FindBy(xpath="//div[@class='col-md-12']//a[@title='Hotels']")
	WebElement we_titleHotel;
	
	@FindBy(xpath="//div[@class='select2-container hotelsearch locationlistthhotels']//span[@class='select2-chosen']")
	WebElement we_clickHotelField;
	
	@FindBy(xpath="//div[@id='select2-drop']//input")
	WebElement we_enterHotel; //search via: marriott
	
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul[@class='select2-results']//li[@class='select2-no-results']")
	WebElement we_textnoHotelFound;
	
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul[@class='select2-result-sub']")
	WebElement we_selectHotel; 
	
	public boolean mtd_verifyLogo() {
		return mtd_verifyImage(we_imgLogo);
	}
	
	public void mtd_openMyAccount() {
		mtd_clickLink(we_dropdownMyAccount);
	}
	
	public Cls_LoginPage mtd_redirectLogin() {
		mtd_openMyAccount();
		mtd_clickLink(we_linkLogin);
		return new Cls_LoginPage();
	}
	
	public Cls_SignUpPage mtd_redirectSignUp() throws FileNotFoundException {
		mtd_openMyAccount();
		mtd_clickLink(we_linkSignUp);
		return new Cls_SignUpPage();
	}
	
	public void mtd_clickHotels() {
		mtd_clickLink(we_titleHotel);
	}
	
	public void mtd_searchHotel(String arg_HotelName) {
		mtd_clickLink(we_clickHotelField);
		mtd_enterValue(we_enterHotel, arg_HotelName);
	}
	
	public void mtd_getNoHotel() {
		mtd_getText(we_textnoHotelFound);
	}
	
	public void mtd_getHotel() {
		mtd_getText(we_selectHotel);
	}
	
	public void mtd_selectHotel() {
		mtd_clickLink(we_selectHotel);
	}
	
}