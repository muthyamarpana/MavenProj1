package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DatePicker {

	WebDriver driver;
	//08/20/2025
	@Test
	public void selDate()
	{
		driver = new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Integer yr = 2026;
		driver.findElement(By.id("datepicker")).click();
		
		while(true)
		{
			String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			System.out.println("Month="+month+"\t"+"Year="+year);
			if(year.equals(String.valueOf(yr)) && month.equals("August"))
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();
				break;
				
			}
			if(yr<=2025)  //if(yr>=2025)
			{
				//previous
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
				
			}
			else
			{
				//next
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
				
			}
			
		}
		driver.quit();
		
	}
	
	
}
