package pkg.PageClass;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;

import pkg.BaseClass.Cls_Base;

public class Cls_DashboardPage extends Cls_Base{
	
	public Cls_DashboardPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);;
		// TODO Auto-generated constructor stub
	}

	public String mtd_getTitle() {
		 String dashboardtitle = super.mtd_getTitle();
		 return dashboardtitle;
	}

}
