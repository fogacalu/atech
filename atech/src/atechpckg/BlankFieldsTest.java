package atechpckg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlankFieldsTest extends FunctionalTest {
	
/* 
 * 	
 */
	
	SoftAssert sa = new SoftAssert();

	@Test
	public void blankFieldsTest(){
		driver.get("https://atech-airlines-ui-staging.herokuapp.com/");
		
		InputPage InputPage = new InputPage(driver);
		
		sa.assertTrue(InputPage.isInitialized());

		InputPage.enterDates("", "");
		
		InputPage.selectCity("Escolha uma cidade", "Escolha uma cidade");

		InputPage.submit();
		
		sa.assertTrue(InputPage.isTableDisplayed());
		
		sa.assertAll();
	}	
}