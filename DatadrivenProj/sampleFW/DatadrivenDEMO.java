package sampleFW;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//using JExcel JExcel does not support .xlsx format.
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class DatadrivenDEMO 
{
			@Test(dataProvider="MyFriends")
			public void GmailLogin(String emailid,String passwd) throws InterruptedException
			{
				// Open Driver
				WebDriver d=new FirefoxDriver();
				// Open URL
				Thread.sleep(4000);		
				d.get("https://www.google.co.in/?gws_rd=ssl");
				
				// Click on Sign In		
				Thread.sleep(7000);
				d.findElement(By.id("gb_70")).click();
				
				
				// send email id the text box
				Thread.sleep(7000);
				d.findElement(By.id("Email")).sendKeys(emailid);
				
				
				// Click on next button
				Thread.sleep(7000);
				d.findElement(By.id("next")).click();
				
				
				// send password 
				Thread.sleep(7000);
				d.findElement(By.id("Passwd")).sendKeys(passwd);
				
				
				// click on sign in
				Thread.sleep(7000);
				d.findElement(By.id("signIn")).click();
				
				
				// click on gmail link
				Thread.sleep(7000);
				d.findElement(By.linkText("Gmail")).click();
				
				
				// click on profile image
				Thread.sleep(7000);
				d.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
				
				
				// click on logout button
				Thread.sleep(7000);
				d.findElement(By.id("gb_71")).click();
				
				
				// close browser
				Thread.sleep(7000);
				d.close();
				
				
				
			}

			
			@DataProvider(name="MyFriends")
			public Object[][] TestData() throws BiffException, IOException
			{
				
				// take file path
				File f=new File("C:\\Users\\USER\\Desktop\\Book1.xls");
				
				// Get Work
				Workbook wb=Workbook.getWorkbook(f);
				
				// Get Sheet
				Sheet sh=wb.getSheet(0);
				
				
				// Get Row and Column Column
				int rcount=sh.getRows();
				int ccount=sh.getColumns();
				
			    // Using loop get sheet data
				String[][] GData=new String[rcount-1][ccount];
				
				for(int r=1;r<rcount;r++)
				{
					for(int c=0;c<ccount;c++)
					{
						
						// get cell value
						Cell cvalue=sh.getCell(c, r);
						String getdata=cvalue.getContents();
						System.out.println(getdata);
						GData[r-1][c]=getdata;
					}
				}
				
				
				// End Loop
				
				return GData;
				
			}
		
	}
