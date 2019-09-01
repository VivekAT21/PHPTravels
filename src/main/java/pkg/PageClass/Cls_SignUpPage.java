package pkg.PageClass;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pkg.BaseClass.Cls_Base;

public class Cls_SignUpPage extends Cls_Base {

	public Cls_SignUpPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//public static Cls_HomePage obj_hp;
	
	@FindBy(xpath="//div[@class='go-text-right panel-heading']")
	WebElement we_titleSignUp;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement we_firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement we_lastname;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement we_phone;	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement we_email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement we_password;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	WebElement we_confirmpassword;
	
	@FindBy(xpath="//form[@id='headersignupform']//button")
	WebElement we_submit;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement we_validation;
	
	@FindBy(xpath="//button[@id='cookyGotItBtn']")
	WebElement we_cookieBtn;
	
	//This method is OVERRIDDEN of mtd_getTitle method of base class
	//Major difference in both is, we are saving title value
	public String mtd_getTitle() {
		String title = mtd_getText(we_titleSignUp).toLowerCase();
		return title;
	}
	
	public void mtd_clickCookie() {
		mtd_explictWait(we_cookieBtn, 10);
		mtd_clickcookieBtn();
	}
	
	public Cls_DashboardPage mtd_signUp(String arg_fstName, String arg_lstName, String arg_phone, String arg_email, String arg_password, String arg_confrmpassword) throws FileNotFoundException {
		mtd_enterValue(we_firstname, arg_fstName);
		mtd_enterValue(we_lastname, arg_lstName);
		mtd_enterValue(we_phone, arg_phone);
		mtd_enterValue(we_email, arg_email);
		mtd_enterValue(we_password, arg_password);
		mtd_enterValue(we_confirmpassword, arg_confrmpassword);
		mtd_click_submit();
		return new Cls_DashboardPage();
	}
	

	public void mtd_clickcookieBtn() {
		mtd_clickLink(we_cookieBtn);
	}
	
	public boolean mtd_validation() {
		boolean value = mtd_wbElement(we_validation);
		return value;
	}
	
	public void mtd_click_submit() throws FileNotFoundException {
		mtd_clickLink(we_submit);
	}	
	
}