package atechpckg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InputPage extends PageObject {

	@FindBy(xpath="//h4[contains(text(), 'Partida')]/following-sibling::md-datepicker//input[contains(@class, 'md-datepicker-input')]")
	private WebElement inputPartida;
	
	@FindBy(xpath="//h4[contains(text(), 'Chegada')]/following-sibling::md-datepicker//input[contains(@class, 'md-datepicker-input')]")
	private WebElement inputChegada;
	
	@FindBy(xpath="//h4[contains(text(), 'Origem')]/following-sibling::select[@name='grupo']")
	private WebElement inputOrigem;
	
	Select dropdownOrigem = new Select(inputOrigem);
	
	@FindBy(xpath="//h4[contains(text(), 'Destino')]/following-sibling::select[@name='grupo']")
	private WebElement inputDestino;
	
	Select dropdownDestino = new Select(inputDestino);
	
	@FindBy(xpath="//table[@class=\"table table-striped table-bordered table-hover ng-scope\"]")
	private WebElement table;
	
	public String getDynamicElement(int row, int column){
		String xpathcell = "//table[@class=\"table table-striped table-bordered table-hover ng-scope\"]/tbody["+row+"]/tr/td["+column+"]";
		WebElement element = driver.findElement(By.xpath(xpathcell));
		return element.getText();
	}
	
	@FindBy(xpath="//button[text()='Filtrar']")
	private WebElement filtrarButton;

	public InputPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return filtrarButton.isDisplayed();
	}
	
	public boolean isTableDisplayed() {
		return table.isDisplayed();
	}
	
	public void enterDates(String dataPartida, String dataChegada){
		this.inputPartida.clear();
		this.inputPartida.sendKeys(dataPartida);

		this.inputChegada.clear();
		this.inputChegada.sendKeys(dataChegada);
	}


	public void selectCity(String origem, String destino){
		this.dropdownOrigem.selectByVisibleText(origem);
		
		this.dropdownDestino.selectByVisibleText(destino);
	}
	
	public int countRows(){
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"table table-striped table-bordered table-hover ng-scope\"]/tbody/tr"));
		int count = rows.size();
		System.out.println("ROW COUNT : "+count);
		return count;
	}
	
	public void submit(){
		filtrarButton.click();
	}
}


