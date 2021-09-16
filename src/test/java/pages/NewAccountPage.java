package pages;

import org.openqa.selenium.support.PageFactory;

import core.Driver;
import maps.NewAccountMap;

public class NewAccountPage {
	
	 NewAccountMap newAccountMap;

	    public NewAccountPage(){
	        newAccountMap = new NewAccountMap();
	        PageFactory.initElements(Driver.getDriver(), newAccountMap);
	    }

	    public String getTextNewAccount(){
	        return newAccountMap.textCreateAccount.getText();
	    }
	
}
