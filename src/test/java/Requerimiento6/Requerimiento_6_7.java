package Requerimiento6;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.Duration;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Requerimiento_6_7 {

private WebDriver driver;
	
	By cedulaLocator = By.id("document_id");
	By verifyLocator = By.id("verify");
	By formLocator = By.xpath("//input[@id='id_student_id']");
	By carnetLocator = By.xpath("/html/body/div[1]/main/section/div[2]/form/div[1]/div/div/label/input");
	By nombresLocator = By.xpath("//input[@id='id_first_name']");
	By apellidosLocator = By.xpath("//input[@id='id_last_name']");
	By cedulaformLocator = By.xpath("//input[@id='id_document_id']");
	By telefonoLocator = By.xpath("//input[@id='id_telephone']");
	By nacimientoLocator = By.xpath("//input[@id='id_birth_date']");
	By correoLocator = By.xpath("//input[@id='id_username']");
	By carritoLocator = By.xpath("//shopping-cart");
	By registroLocator = By.xpath("//a[contains(text(),'Registrarse')]");
	By estudianteLocator = By.xpath("//a[contains(text(),'Registro como estudiante regular')]");
	String Carnet = "TS21022220";
	String Nombres = "SANCHEZ MEJIA MICHAEL";
	String Apellidos = "SANCHEZ MEJIA";
	String Cedula = "4-0213-0063";
	String Telefono = "83670242";
	String fechaNacimiento = "15/11/1991";
	String Correo = "tuleajr@icloud.com";
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tuleaa\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://compras.ufidelitas.ac.cr/cart/detail/?source=52998197b4fd439ca97e29e2cbac8622&site=https://ufidelitas.ac.cr/");
		
	}
	

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	
		
	public void FormText() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		js.executeScript("arguments[0].click()", driver.findElement(registroLocator));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", driver.findElement(estudianteLocator));
		Thread.sleep(2000);
		driver.findElement(cedulaLocator).sendKeys("402130063");
		js.executeScript("arguments[0].click()", driver.findElement(verifyLocator));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(formLocator));
		WebElement form = driver.findElement(formLocator);
		
		if (form.isDisplayed()) 
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.presenceOfElementLocated(carnetLocator));
			WebElement carnet = driver.findElement(carnetLocator);
			//JOptionPane.showMessageDialog(null, carnet.getAttribute("value"));
			assertEquals("TS21022220",carnet.getAttribute("value").toString());
			
			WebElement nombres = driver.findElement(nombresLocator);
			assertEquals(Nombres,nombres.getAttribute("value").toString());
			
			/*WebElement apellidos = driver.findElement(apellidosLocator);
			assertEquals(Apellidos,apellidos.getAttribute("value").toString());*/
			
			WebElement cedula = driver.findElement(cedulaformLocator);
			assertEquals(Cedula,cedula.getAttribute("value").toString());
			
			WebElement telefono = driver.findElement(telefonoLocator);
			assertEquals(Telefono,telefono.getAttribute("value").toString());
			
			WebElement fechanacimiento = driver.findElement(nacimientoLocator);
			assertEquals(fechaNacimiento,fechanacimiento.getAttribute("value").toString());
			
			WebElement correo = driver.findElement(correoLocator);
			assertEquals(Correo,correo.getAttribute("value").toString());
			
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath("/html/body/div[1]/main/section/div[2]/form/div[2]/div[9]/div/label/input")).sendKeys("12345678");
			driver.findElement(By.xpath("/html/body/div[1]/main/section/div[2]/form/div[2]/div[10]/div/label/input")).sendKeys("12345678");
			WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
		    Actions builder = new Actions(driver);
		    builder.moveToElement(element).perform();
		    driver.findElement(By.cssSelector(".btn-primary")).click();
		    Thread.sleep(2000);
			WebElement respuesta = driver.findElement(By.xpath("/html/body/div[1]/main/section/div[2]/form/div[4]/div/div/ul/li[2]"));
			String message = "This password is entirely numeric.";
			assertEquals(message,respuesta.getText().toString());
		}
		
	}
	
	

}
