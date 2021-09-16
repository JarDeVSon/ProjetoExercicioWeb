package steps;

import java.io.IOException;

import core.Driver;
import enums.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import pages.LoginPage;

public class GenericSteps {
	@Before
	public void iniciaNavegador(Scenario cenario) {
		new Driver(Browser.FIREFOX);
		Driver.setNomeCenario(cenario.getName());
		Driver.criaDiretorio();
	}
	
	@After
	public void fechaNavegador(Scenario cenario) throws IOException {
		if (cenario.isFailed()) {
			Driver.printScreenCenario("Erro no cenário");
		}
		Driver.getDriver().quit();
	}
	
	
}
