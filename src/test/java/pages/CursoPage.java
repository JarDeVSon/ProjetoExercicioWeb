package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import maps.CursoMap;

public class CursoPage {
	private WebDriver driver;
	private CursoMap cursoMap;
	
	public CursoPage(WebDriver driver) {
		this.driver = driver;
		cursoMap = new CursoMap();
		PageFactory.initElements(driver, cursoMap);
	}

	public String getTitle() {
		return cursoMap.h2Titulo.getText();
	}

}
