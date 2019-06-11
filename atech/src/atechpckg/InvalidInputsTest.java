package atechpckg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InvalidInputsTest extends FunctionalTest {
	
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void invalidInputsTest(){
		driver.get("https://atech-airlines-ui-staging.herokuapp.com/");
		
		//Invalid Dates for testing "Partida" and "Chegada" fields
		String[] invalidDates = { "aaaa" , "abc!%123", "00/00/0000" , "15/15/2015" };
		
		InputPage InputPage = new InputPage(driver);
		sa.assertTrue(InputPage.isInitialized());

		//Test Invalid Values for "Partida" Field
		System.out.printf("Testing invalid values for field Partida: \n");
		for (String s: invalidDates) {	
		   InputPage.enterDates(s, "01-01-2010");
		   System.out.printf("Testing with invalid value: %s \n", s);
		   
		   InputPage.selectCity("Escolha uma cidade", "Escolha uma cidade");

		   InputPage.submit();
			
		   sa.assertFalse(InputPage.isTableDisplayed());
		 }
		
		//Test Invalid Values for "Chegada" Field
		System.out.printf("Testing invalid values for field Chegada: \n");
		for (String s: invalidDates) {
		   InputPage.enterDates("01-01-2010", s);
		   System.out.printf("Testing with invalid value: %s \n", s);
		   
		   InputPage.selectCity("Escolha uma cidade", "Escolha uma cidade");

		   InputPage.submit();
			
		   sa.assertFalse(InputPage.isTableDisplayed());
		 }
	sa.assertAll();	
	}	
}