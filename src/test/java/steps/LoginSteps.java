package steps;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;


import core.Driver;
import enums.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;
import pages.NewAccountPage;

public class LoginSteps {

	LoginPage loginPage;
	NewAccountPage newAccountPage;
	String username;


	@Dado("que a modal esteja sendo exibida")
	public void queAModalEstejaSendoExibida() {
		Driver.getDriver().get("https://www.advantageonlineshopping.com/");
		loginPage = new LoginPage();
		loginPage.clickBtnLogin();
		loginPage.visibilityOfBtnFechar();
		loginPage.aguardaLoader();
		
	}

	@Quando("for realizado um clique fora da modal")
	public void forRealizadoUmCliqueForaDaModal() {
		loginPage.clickDivFechaModal();
	}

	@Entao("a janela modal deve ser fechada")
	public void aJanelaModalDeveSerFechada() throws Exception {
		try {
			loginPage.invisibilityOfBtnFechar();
		} catch (Exception e) {
			throw new Exception("A janela modal não foi fechada");
		}

	}

	@Quando("for realizado um clique icone de fechar da modal")
	public void forRealizadoUmCliqueIconeDeFecharDaModal() {
		loginPage.clickBtnFechar();
	}

	@Quando("for realizado um clique em Create New Account")
	public void forRealizadoUmCliqueEmCreateNewAccount() {
		loginPage.clickLinkCreateAccount();
	}

	@Entao("a pagina Create Account deve ser exibida")
	public void aPaginaCreateAccountDeveSerExibida() {
		newAccountPage = new NewAccountPage();

		assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
	}

	@Quando("os campos de login forem preenchidos com os valores")
	public void osCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) throws IOException {
		username = map.get("usuario");
		String password = map.get("senha");
		boolean remember = Boolean.parseBoolean(map.get("remember"));

		loginPage.setInpUserName(username);
		loginPage.setInpPassword(password);

		if (remember) loginPage.clickInpRemember();
		
		Driver.printScreenCenario("preenchimento dos campos de login");

	}

	@Quando("for realizado o clique no botao sign in")
	public void forRealizadoOCliqueNoBotaoSignIn() {
		loginPage.clickBtnSignIn();
	}

	@Entao("deve ser possivel logar no sistema")
	public void deveSerPossivelLogarNoSistema() throws IOException {
		assertEquals(username, loginPage.getTextLogado());
		
		Driver.printScreenCenario("logado no sistema");
	}

	@Entao("o sistema devera exibir uma mensagem de erro")
	public void oSistemaDeveraExibirUmaMensagemDeErro() throws IOException {
		assertEquals("Incorrect user name or password.", loginPage.getErroLogin());
		Driver.printScreenCenario("Incorrect user name or password");

	}

	@Entao("o botao sign in deve permanecer desabilitado")
	public void oBotaoSignInDevePermanecerDesabilitado() throws IOException {
		boolean enabled = loginPage.isBtnSignIn();
		assertFalse(enabled);
		Driver.printScreenCenario("botão sign in permanece desabilitado");

	}

}
