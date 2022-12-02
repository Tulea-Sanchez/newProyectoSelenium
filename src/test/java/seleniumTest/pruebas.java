package seleniumTest;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pruebas {

private WebDriver driver;
	
	By carrerasLocator = By.id("menu-item-6257");
	By IngSistemasLocator = By.xpath("//a[@href='https://ufidelitas.ac.cr/carrera/bachillerato-ingenieria-sistemas-de-computacion/']");
	By planLocator = By.xpath("//div[@id='cta_section']/a");
	By nombreLocator = By.id("nf-field-128");
	By apellidosLocator = By.id("nf-field-133");
	By cedulaLocator = By.id("nf-field-129");
	By correoLocator = By.id("nf-field-130");
	By telefonoLocator = By.id("nf-field-221");
	By terminosLocator = By.id("nf-label-field-131");
	By descargarLocator = By.id("nf-field-132");
	By errorLocator = By.xpath("//*[@id=\"nf-form-errors-9\"]/nf-errors/nf-section/div");
	By okLocator = By.xpath("//a[contains(text(),'Descargar Brochure')]");
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
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(carrerasLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(carrerasLocator).isDisplayed()) 
		{
			driver.findElement(IngSistemasLocator).click();
			Thread.sleep(2000);
			
			js.executeScript("arguments[0].click()", driver.findElement(planLocator));
			
			Thread.sleep(1000);
			driver.findElement(nombreLocator).sendKeys("pruebaSelenium");
			Thread.sleep(1000);
			driver.findElement(apellidosLocator).sendKeys("prueba prueba");
			Thread.sleep(1000);
			driver.findElement(cedulaLocator).sendKeys("402220777");
			Thread.sleep(1000);
			driver.findElement(correoLocator).sendKeys("tulea@correo.com");
			Thread.sleep(1000);
			driver.findElement(telefonoLocator).sendKeys("12345678");
			//String dato = driver.findElement(By.xpath("//*[@id=\"nf-field-128-wrap\"]/div[2]")).getCssValue(css=#nf-field-128);
			//JOptionPane.showMessageDialog(null, dato);
			Thread.sleep(1000);
			js.executeScript("arguments[0].click()", driver.findElement(terminosLocator));
			Thread.sleep(1000);
			js.executeScript("arguments[0].click()", driver.findElement(descargarLocator));
			Thread.sleep(10000);
			js.executeScript("arguments[0].click()", driver.findElement(okLocator));
			
			
			
		}
	}
	
	

}