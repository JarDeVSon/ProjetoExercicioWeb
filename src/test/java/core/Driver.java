package core;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static String nomeCenario;
	private static File diretorio;
	private static int numPrint;
	
	
	public static File getDiretorio() {
		return diretorio;
	}

	public static void setDiretorio(File diretorio) {
		Driver.diretorio = diretorio;
	}

	public static String getNomeCenario() {
		return nomeCenario;
	}

	public static void setNomeCenario(String nomeCenario) {
		Driver.nomeCenario = nomeCenario;
	}

	public static void criaDiretorio() {
		String path = "src/test/resources/evidencias";
		diretorio = new File(path+"/"+nomeCenario);
		diretorio.mkdir();
		numPrint = 0;
	}
	public static void printScreenCenario(String passo) throws IOException {
		numPrint++;
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String caminho = diretorio.getPath()+"/"+numPrint+" - "
				+ ""+passo+".png";
		FileUtils.copyFile(file, new File(caminho));
	}
	
	public Driver(Browser navegador) {
		switch (navegador) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().setSize(new Dimension(1280, 720));
		
	}

	public static WebDriver getDriver() {
		return driver;
	}
	public static void visibilityOf(WebElement element) {
		 wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void invisibilityOf(WebElement element) {
		 wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static void attributeChange(WebElement element, String attribute, String value) {
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
}
