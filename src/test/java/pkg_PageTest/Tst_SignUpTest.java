package pkg_PageTest;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pkg.BaseClass.Cls_Base;
import pkg.PageClass.Cls_HomePage;
import pkg.PageClass.Cls_SignUpPage;

public class Tst_SignUpTest extends Cls_Base {
	
	public Cls_HomePage obj_home = new Cls_HomePage();
	public Cls_SignUpPage obj_signup;
	
	public Tst_SignUpTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeTest
	public void initilize() throws FileNotFoundException {
		obj_signup = obj_home.mtd_redirectSignUp();
	}
	
	@Test (priority = 1)
	public void verifyTitle() {
		String title = "Sign Up".toLowerCase();
		assertEquals(obj_signup.mtd_getTitle(), title);
	}
	
	@Test
	public void blankSubmittion() throws FileNotFoundException {
		obj_signup.mtd_click_submit();
		assertEquals(obj_signup.mtd_validation(), true);
	}
	
	@Test
	public void validSignUp() throws FileNotFoundException {
		System.out.println("test Case");
		
		obj_signup.mtd_clickCookie();
		obj_signup.mtd_signUp("Vivek", "Garg", "9898989898", "vivek.garg@mailinator.com", "Blue2001", "Blue2001");
	}
	
	/*@AfterTest
	public void end() {
		driver.quit();
	}*/
}
