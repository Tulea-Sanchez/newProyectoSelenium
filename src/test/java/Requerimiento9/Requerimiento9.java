package Requerimiento9;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Requerimiento9 {

	private WebDriver driver;
	By registerLocator= By.linkText("Registrarse");
	By nombresLocator= By.cssSelector("input[name='first_name']");
	By apellidosLocator=By.cssSelector("input[name='last_name']");
	By correoLocator=By.cssSelector("input[name='username']");
	By contraLocator=By.cssSelector("input[name='password1']");
	By confirmLocator=By.cssSelector("input[name='password2']");
	By btnLocator=By.id("btn-register");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://compras.ufidelitas.ac.cr/accounts/shop/login/");	
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(btnLocator).isDisplayed()) {
		driver.findElement(nombresLocator).sendKeys("Mónica");
		driver.findElement(apellidosLocator).sendKeys("Monterrosa Barrantes");
		driver.findElement(correoLocator).sendKeys("monimonte131@gmail.com");
		driver.findElement(contraLocator).sendKeys("123");
		driver.findElement(confirmLocator).sendKeys("123");
		driver.findElement(btnLocator).click();
		Thread.sleep(2000);
		}
		else {
			System.out.print("Página no encontrada");
		}
		
//List<WebElement> fonts =driver.findElements(By.tagName("font"));
		
		//assertEquals("La contraseña debe ser de al menos 8 caracteres",fonts.get(5).getText());
		WebElement resultado= driver.findElement(By.xpath("//form[@id='register']/div[2]/div/div/ul/li"));
		String mensaje=("La contraseña debe ser de al menos 8 caracteres");
		assertEquals(mensaje,resultado.getText().toString());
	}

	/*@Test
	public void registerCorrecto() throws InterruptedException {
		driver.findElement(registerLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(btnLocator).isDisplayed()) {
		driver.findElement(nombresLocator).sendKeys("Mónica");
		driver.findElement(apellidosLocator).sendKeys("Monterrosa Barrantes");
		driver.findElement(correoLocator).sendKeys("monimonte13@gmail.com");
		driver.findElement(contraLocator).sendKeys("monica.123456");
		driver.findElement(confirmLocator).sendKeys("monica.123456");
		driver.findElement(btnLocator).click();
		Thread.sleep(2000);
		}
		else {
			System.out.print("Página no encontrada");
		}
	List<WebElement> fonts =driver.findElements(By.tagName("font"));
	
	assertEquals("¡El carrito de compras está vacío!",fonts.get(5).getText());
	}*/
	
}
