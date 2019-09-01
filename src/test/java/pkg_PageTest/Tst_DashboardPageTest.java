package pkg_PageTest;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pkg.BaseClass.Cls_Base;
import pkg.PageClass.Cls_DashboardPage;
import pkg.PageClass.Cls_HomePage;
import pkg.PageClass.Cls_SignUpPage;

public class Tst_DashboardPageTest extends Cls_Base {
	
	public Tst_DashboardPageTest() throws FileNotFoundException {
		super();
	}

	public Cls_HomePage obj_home = new Cls_HomePage();
	public Cls_SignUpPage obj_signup;
	public Cls_DashboardPage obj_dashboard;
	
	@BeforeTest
	public void initilize() throws FileNotFoundException {
		obj_signup = obj_home.mtd_redirectSignUp();
		obj_signup.mtd_clickCookie();
		obj_dashboard = obj_signup.mtd_signUp("Vivek", "Garg3", "979797979", "vivek.garg8@mailinator.com", "Blue2001", "Blue2001");	
	}
	
	@Test
	public void verifyTitle() {
		mtd_impl_wait(10);
		assertEquals(obj_dashboard.mtd_getTitle().toLowerCase(), "My Account".toLowerCase());
	}

}
