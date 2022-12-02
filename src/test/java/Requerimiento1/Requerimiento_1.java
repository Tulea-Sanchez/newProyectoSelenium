package Requerimiento1;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Requerimiento_1 {

	private WebDriver driver;
	
	By carrerasLocator = By.id("menu-item-6257");
	By IngSistemasLocator = By.xpath("//a[@href='https://ufidelitas.ac.cr/carrera/bachillerato-ingenieria-sistemas-de-computacion/']");
	By formLocator = By.id("nf-field-5");
	By errorLocator = By.id("nf-error-9");
	By nombreLocator = By.id("nf-field-5");
	By apellidosLocator = By.id("nf-field-6");
	By telefonoLocator = By.id("nf-field-8");
	By correoLocator = By.xpath("//input[@id='nf-field-9']");
	By provinciaLocator = By.name("nf-field-776");
	By campusLocator = By.name("nf-field-15");
	By carreraLocator = By.xpath("//label[@id='nf-label-field-17-14']");
	By herediaLocator = By.xpath("//label[@id='nf-label-field-17-14']id=nf-field-776");
	By terminosLocator = By.xpath("//label[@id='nf-label-field-242']");
	By sendLocator = By.id("nf-field-11");
	By frame2Locator = By.name("a-b0fykqrt2aba");
	By frame3Locator = By.xpath("a-cxp0f1t02m9j");
	
	By errorNombreLocator = By.xpath("//div[@id='nf-error-5']/div");
	By errorApellidosLocator = By.xpath("//div[@id='nf-error-6']/div");
	By errorTelefonoLocator = By.xpath("//div[@id='nf-error-8']/div");
	By errorCorreoLocator = By.xpath("//div[@id='nf-error-9']/div");
	By errorCarreraLocator = By.xpath("//div[@id='nf-error-17']/div");
	By errorTerminosLocator = By.xpath("//div[@id='nf-error-242']/div");
	By exitoLocator = By.xpath("/html/body/div[1]/div/div/div/div/h1");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	//nf-label-field-17-14
	
	public Requerimiento_1() {};
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tuleaa\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ufidelitas.ac.cr/carrera/bachillerato-ingenieria-sistemas-de-computacion/");
		
	}
	
	

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void FormText() throws InterruptedException {
		driver.findElement(carrerasLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(carrerasLocator).isDisplayed()) 
		{
			driver.findElement(IngSistemasLocator).click();
			
			if (driver.findElement(formLocator).isDisplayed())
			{
				Thread.sleep(2000);
				driver.findElement(nombreLocator).sendKeys("");
				JavascriptExecutor js = (JavascriptExecutor)driver;
				//JOptionPane.showMessageDialog(null, "Realize la Captcha y seleccione ok para continuar la prueba.");
				js.executeScript("arguments[0].click()", driver.findElement(sendLocator));
				Thread.sleep(5000);
				if (driver.findElement(errorNombreLocator).isDisplayed()
						&& driver.findElement(errorApellidosLocator).isDisplayed()
						&& driver.findElement(errorTelefonoLocator).isDisplayed()
						&& driver.findElement(errorCorreoLocator).isDisplayed()
						&& driver.findElement(errorCarreraLocator).isDisplayed()
						&& driver.findElement(errorTerminosLocator).isDisplayed())
				{
					driver.findElement(nombreLocator).sendKeys("pruebaSelenium");
					Thread.sleep(1000);
					driver.findElement(apellidosLocator).sendKeys("prueba prueba");
					Thread.sleep(1000);
					driver.findElement(telefonoLocator).sendKeys("8367-0247");
					Thread.sleep(1000);
					driver.findElement(correoLocator).sendKeys("tulea@correo.com");
					Thread.sleep(1000);
					js.executeScript("arguments[0].click()", driver.findElement(carreraLocator));
					js.executeScript("arguments[0].click()", driver.findElement(terminosLocator));
					JOptionPane.showMessageDialog(null, "Realize la Captcha y seleccione ok para continuar la prueba.");
					Thread.sleep(1000);
					js.executeScript("arguments[0].click()", driver.findElement(sendLocator));
					
					Thread.sleep(5000);
					WebElement resultado = driver.findElement(exitoLocator);
					String message = "¡Su solicitud de información ha sido enviada!";
					assertEquals(message,resultado.getText().toString());
				}
				
			}
			else {System.out.println("Registro fallido, pagina no existente");}
		}
	}
	
	

}
 //src="https://cdn.ufidelitas.ac.cr/wp-content/uploads/2021/04/07082018/descargar-1.png"
