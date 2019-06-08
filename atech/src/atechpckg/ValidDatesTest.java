package atechpckg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidDatesTest extends FunctionalTest {
	
	SoftAssert sa = new SoftAssert();

	@Test
	public void validDatesTest(){
		
		driver.get("https://atech-airlines-ui-staging.herokuapp.com/");
		
		String[] Data = { "04/15/2018", "04/16/2018", "03/01/2018", "04/01/2018", "04/02/2018", "04-15-2018" , "04-16-2018" };
		
		InputPage InputPage = new InputPage(driver);
		sa.assertTrue(InputPage.isInitialized());
		
		for (String s: Data) {
			for (String s1: Data) {
					System.out.printf("Testing with date: %s as takeoff \n", s);
					System.out.printf("Testing with date: %s as arrival \n", s1);
					
					InputPage.enterDates(s, s1);
					
					InputPage.selectCity("Escolha uma cidade", "Escolha uma cidade");

					InputPage.submit();
					
					sa.assertTrue(InputPage.isTableDisplayed());
					
					int rowsnumber = InputPage.countRows();
					
					if (rowsnumber != 0) {
						for (int i = 1; i <= rowsnumber; ++i) {
							String partida = InputPage.getDynamicElement(i, 1);
							String chegada = InputPage.getDynamicElement(i, 2);
							String origem = InputPage.getDynamicElement(i, 3);
							String destino = InputPage.getDynamicElement(i, 4);						
							System.out.println("Partida : "+partida);
							System.out.println("Chegada : "+chegada);
							System.out.println("Origem : "+origem);
							System.out.println("Destino : "+destino);
							sa.assertTrue(partida.contains(s), "Validate if inputDate Partida is the same as returned Partida for record "+ i +" \n");
							sa.assertTrue(chegada.contains(s1), "Validate if inputDate Chegada is the same as returned Chegada for record "+ i +" \n");
						}	
					} else {
						System.out.println("No flights were found for the given dates!");
				}
			}
		}
		sa.assertAll();	
	}
}	
