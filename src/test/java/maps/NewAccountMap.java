package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountMap {
	
	@FindBy(xpath = "//h3[contains(text(), 'CREATE ACCOUNT')]")
	public WebElement textCreateAccount; //click
	
	
}
