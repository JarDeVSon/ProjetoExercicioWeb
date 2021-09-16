package pages;

import org.openqa.selenium.support.PageFactory;

import core.Driver;
import maps.LoginMap;

public class LoginPage {
	 LoginMap loginMap;

	    public LoginPage() {
	       loginMap = new LoginMap();
	        PageFactory.initElements(Driver.getDriver(), loginMap);
	    }

	    public void clickBtnLogin(){

	        loginMap.btnLogin.click();
	    }

	    public void clickBtnFechar(){
	        loginMap.btnFechar.click();
	    }

	    public void clickDivFechaModal(){
	    	Driver.visibilityOf(loginMap.divFechaModal);
	        loginMap.divFechaModal.click();
	    }

	    public void setInpUserName(String username){
	    	Driver.visibilityOf(loginMap.inpUserName);
	        if(username != null){
	            loginMap.inpUserName.sendKeys(username);
	        }

	    }

	    public void setInpPassword(String password){
	    	Driver.visibilityOf(loginMap.inpPassword);
	        if (password != null){
	            loginMap.inpPassword.sendKeys(password);
	        }
	    }

	    public void clickInpRemember(){
	        loginMap.inpRemember.click();
	    }

	    public void clickBtnSignIn(){
	        loginMap.btnSignIn.click();
	    }

	    public void clickLinkCreateAccount(){
	        loginMap.linkCreateAccount.click();
	    }

	    public boolean isBtnSignIn(){
	        return loginMap.btnSignIn.isEnabled();
	    }

	    public void visibilityOfBtnFechar(){
	        Driver.visibilityOf(loginMap.btnFechar);
	    }

	    public void invisibilityOfBtnFechar(){
	        Driver.invisibilityOf(loginMap.btnFechar);
	    }

	    public void aguardaLoader(){
	        Driver.attributeChange(loginMap.divLoader, "display", "none");
	    }

	    public String getTextLogado(){
	        return loginMap.textLogado.getText();
	    }

	    public String getErroLogin(){
	        return loginMap.textErroLogin.getText();
	    }
	
}
