package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import maps.PrincipalMap;

public class PrincipalPage {
	private WebDriver driver;
	private PrincipalMap principalMap;

	public PrincipalPage(WebDriver driver) {
		this.driver = driver;
		principalMap = new PrincipalMap();
		PageFactory.initElements(driver, principalMap);
	}
	
	public String getTitle() {
		
		return principalMap.h4Titulo.getText();
	}
	public CursoPage btnCursos() {
		principalMap.btn.click();
		return new CursoPage(driver);
		
	}
	
}
