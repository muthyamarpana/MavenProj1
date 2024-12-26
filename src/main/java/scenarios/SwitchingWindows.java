package scenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {
WebDriver driver;
	@Test
	public void switchwin()
	{
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allwinIds=driver.getWindowHandles();
		System.out.println("Total windows -- "+allwinIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allwinIds.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window ID1="+win1);
		System.out.println("Window ID2="+win2);
		System.out.println("Window1 title-"+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title- "+driver.getTitle());
		boolean chkEnble=driver.findElement(By.linkText("Log in")).isEnabled();
		System.out.println(chkEnble);
		if(chkEnble==true)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		driver.quit();
	}
}
