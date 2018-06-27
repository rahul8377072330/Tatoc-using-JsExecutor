import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTatoc {


	TatocJsExecutor tat =new TatocJsExecutor();
	
	@Test(priority = 0)
	public void testOpenBrowserAndChooseBasic() {
		tat.openBrowserAndChooseBasic();
		Assert.assertTrue(tat.getCurrentLink().contains("grid/gate"));
	}
	
	@Test(priority = 1)
	public void testGreenBox() {
		tat.greenBox();
		Assert.assertTrue(tat.getCurrentLink().contains("frame/dungeon"));
		
	}
	
	@Test(priority = 2)
	public void testFrameDungeon() {
		tat.frameDungeon();
		Assert.assertTrue(tat.getCurrentLink().contains("basic/drag"));
	}
	@Test(priority = 3)
	public void testDragAndDrop() {
		tat.dragAndDrop();
		Assert.assertTrue(tat.getCurrentLink().contains("basic/windows"));
	}
	
	@Test(priority = 4)
	public void testPopUpWindow() {
		tat.popUpWindow();
		Assert.assertTrue(tat.getCurrentLink().contains("basic/cookie"));
	}
	
	@Test(priority = 5)
	public void testCookie() {
		tat.cookie();
		Assert.assertTrue(tat.getCurrentLink().contains("tatoc/end"));
	}

}
