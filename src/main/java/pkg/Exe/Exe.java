package pkg.Exe;

import java.io.FileNotFoundException;
import java.io.IOException;

import pkg.BaseClass.Cls_Base;
import pkg.Util.Cls_readData;
import pkg.Util.Cls_writeData;

public class Exe extends Cls_Base {
	
	public Exe() throws FileNotFoundException {
		super();
		}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Exe e1 = new Exe(); 
		//driver.findElement(By.xpath("//div[@class='select2-container hotelsearch locationlistthhotels']//span[@class='select2-chosen']")).click();
		//driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Marriot");
/*		driver.findElement(By.xpath("//input[@class='form form-control input-lg hcheckin']")).click();
		selectDate("28");
		System.out.println("Vivek");*/
		
		String filepath = prop.getProperty("FILEPATH");
		Cls_readData cdp = new Cls_readData();
			
		//cdp.getData(filepath, 0);
		
		Cls_writeData cwd = new Cls_writeData();
		//cwd.copysheet(prop.getProperty("FILEPATH"), prop.getProperty("OUTFILEPATH"));
		Cls_writeData.addnewcolumn(prop.getProperty("OUTFILEPATH"), "Test");
		driver.quit();
	}

}
