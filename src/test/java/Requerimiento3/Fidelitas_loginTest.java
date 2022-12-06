package Requerimiento3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fidelitas_loginTest {
	
	 		//encontrar la pagina de Login
	
			private WebDriver driver;
			By registerLinkLocator = By.linkText("Iniciar Sesión");
			By identifyTextLocator = By.linkText("Iniciar sesión a través de enlace inteligente.");
			
			//Identificadores del Login
			By usernameLocator = By.id("id_username");
			By passwordLocator = By.id("id_password");
			// identificador de boton
			By loginBtnLocator = By.name("btn btn-primary");
			
			

			@Before
			public void setUp() throws Exception {
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				//driver.get("https://ufidelitas.ac.cr/");
				driver.get("https://compras.ufidelitas.ac.cr/accounts/shop/login/");
			}

			@After
			public void tearDown() throws Exception {
				//driver.quit();
			}

			@Test
			public void login() throws InterruptedException {
				driver.findElement(registerLinkLocator).click();
				Thread.sleep(2000);
				if(driver.findElement(identifyTextLocator).isDisplayed())
				{
					driver.findElement(usernameLocator).sendKeys("qualitytestfide@gmail.com");
					driver.findElement(passwordLocator).sendKeys("Quality*22");

					
					driver.findElement(passwordLocator).submit();
				}
				else 
				{
					System.out.print("Register pages was not found");
				}
				
			}
	

}
