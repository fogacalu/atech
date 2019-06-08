package atechpckg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidCitiesTest extends FunctionalTest {
	
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void validCitiesTest(){
		driver.get("https://atech-airlines-ui-staging.herokuapp.com/");
		
		String[] Cidade = { "Guarulhos", "Nova Iorque", "São José dos Campos", "Tóquio" };
		
		InputPage InputPage = new InputPage(driver);
		
		sa.assertTrue(InputPage.isInitialized());	
		
		for (String s: Cidade) {
			for (String s1: Cidade) {
				if (s != s1) {
					System.out.printf("Testing with city: %s as origin \n", s);
					System.out.printf("Testing with city: %s as destination \n", s1);
					
					InputPage.enterDates("", "");
					
					InputPage.selectCity(s, s1);
		
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
							sa.assertTrue(origem.contains(s));
							sa.assertTrue(destino.contains(s1));
						}	
					} else {
						System.out.println("No flights were found for the given cities!");
				}
					
				}
			}
		}
		sa.assertAll();
	}
}	
