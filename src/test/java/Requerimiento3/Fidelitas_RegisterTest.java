package Requerimiento3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fidelitas_RegisterTest {

	//encontrar la pagina de registro
	
		private WebDriver driver;
		By shopcartLinkLocator = By.linkText("cart-detail-container show");
		By registrationLocator = By.linkText("Ver carrito");
		By registerLinkLocator = By.linkText("Registrarse");
		By identifyTextLocator = By.linkText("Registro como estudiante regular");
		
		//Identificadores del registro
		By usernameLocator = By.id("id_first_name");
		By lastnameLocator = By.id("id_last_name");
		By emailLocator = By.id("id_username");
		By passwordLocator = By.id("id_password1");
		By passwordConfirmLocator = By.id("id_password2");
		// identificador de boton
		By registerBtnLocator = By.id("btn-register");
		
		

		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("https://ufidelitas.ac.cr/");
			driver.get("https://compras.ufidelitas.ac.cr/cart/detail/?source=5db9764981874d5ea1bef0209e71ee34&site=https://ufidelitas.ac.cr/");
		}

		@After
		public void tearDown() throws Exception {
			//driver.quit();
		}

		@Test
		public void registerUser() throws InterruptedException {
			driver.findElement(registerLinkLocator).click();
			Thread.sleep(2000);
			if(driver.findElement(identifyTextLocator).isDisplayed())
			{
				driver.findElement(usernameLocator).sendKeys("Prueba1");
				driver.findElement(lastnameLocator).sendKeys("Test");
				driver.findElement(emailLocator).sendKeys("qualitytestfide1@gmail.com");
				driver.findElement(passwordLocator).sendKeys("Quality*22");
				driver.findElement(passwordConfirmLocator).sendKeys("Quality*22");
				
				driver.findElement(registerBtnLocator).click();
			}
			else 
			{
				System.out.print("Register pages was not found");
			}
			
		}

}
