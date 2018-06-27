import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TatocJsExecutor {

	public static void main(String[] arg) throws InterruptedException{

		WebDriver driver=new ChromeDriver();

		JavascriptExecutor js= (JavascriptExecutor)driver; 
		driver.get("http://10.0.1.86/tatoc");

		WebElement BasicCourse = driver.findElement(By.linkText("Basic Course"));
		js.executeScript("arguments[0].click();", BasicCourse);


		WebElement greenBox = driver.findElement(By.className("greenbox"));
		js.executeScript("arguments[0].click();", greenBox);

		driver.switchTo().frame("main");
		String box1 = driver.findElement(By.id("answer")).getAttribute("class");
		
		WebElement proceed=driver.findElement(By.linkText("Proceed"));
		while(true){
				WebElement repaintBox=driver.findElement(By.linkText("Repaint Box 2"));
				js.executeScript("arguments[0].click();", repaintBox);
				driver.switchTo().frame("child"); 
				String box2 = driver.findElement(By.id("answer")).getAttribute("class");
				driver.switchTo().parentFrame(); 

				if(box1.equals(box2))
				{
					js.executeScript("arguments[0].click();", proceed);
					break;
				}
		     }	
				driver.switchTo().defaultContent();
				
				Actions act=new Actions(driver);
				
				WebElement dg=driver.findElement(By.id("dragbox"));
				WebElement dp=driver.findElement(By.id("dropbox"));
				act.dragAndDrop(dg, dp).build().perform();
				 
				 WebElement drag_proceed = driver.findElement(By.linkText("Proceed"));
				 js.executeScript("arguments[0].click();",drag_proceed);
				 
				 WebElement popup =  driver.findElement(By.linkText("Launch Popup Window"));
				 js.executeScript("arguments[0].click();",popup);
				 
				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                 driver.switchTo().window(tabs2.get(1));
                 
                 WebElement sc = driver.findElement(By.cssSelector("#name"));
                 js.executeScript("document.getElementById('name').value='hello world';");
                 
                 WebElement sub = driver.findElement(By.cssSelector("#submit"));
                 js.executeScript("arguments[0].click();",sub);
                 driver.switchTo().window(tabs2.get(0));
                 
                 WebElement pro = driver.findElement(By.linkText("Proceed"));
                 js.executeScript("arguments[0].click();",pro);
                 
                 WebElement token = driver.findElement(By.linkText("Generate Token"));
                 js.executeScript("arguments[0].click();",token);
                 
                 String Token = driver.findElement(By.id("token")).getText();
                 String[] splited = Token.split("\\s+"); 
                 Cookie token1 = new Cookie("Token", splited[1]);
                 driver.manage().addCookie(token1);
                 WebElement tok = driver.findElement(By.linkText("Proceed"));
                 js.executeScript("arguments[0].click();",tok);
                 
                 Thread.sleep(1000);
                 driver.close();	
	}
}