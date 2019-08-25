package pkg.Exe;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import pkg.BaseClass.Cls_Base;

public class Exe extends Cls_Base {
	
	public Exe() throws FileNotFoundException {
		super();
		}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Exe e1 = new Exe(); 
		//driver.findElement(By.xpath("//div[@class='select2-container hotelsearch locationlistthhotels']//span[@class='select2-chosen']")).click();
		//driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Marriot");
		driver.findElement(By.xpath("//input[@class='form form-control input-lg hcheckin']")).click();
		selectDate("28");
		System.out.println("Vivek");
	}

}
