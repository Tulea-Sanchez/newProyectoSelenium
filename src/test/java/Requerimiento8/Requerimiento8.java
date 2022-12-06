package Requerimiento8;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Requerimiento8 {

	private WebDriver driver;
	By tecnicosLocator=By.id("menu-item-6259");
	By logoLocator=By.xpath("//img[@src='https://cdn.ufidelitas.ac.cr/wp-content/uploads/2020/10/07082046/logo.png']");
	By botonLocator=By.id("tecnicos");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ufidelitas.ac.cr/");	
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void comprasHome() throws InterruptedException {
		
		driver.findElement(tecnicosLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(botonLocator).isDisplayed()) {
		driver.findElement(logoLocator).click();
		Thread.sleep(2000);	
		}
		else {
			System.out.print("Página principal no encontrada");
		}
		WebElement resultado= driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/h2"));
		String mensaje=("OFERTA ACADÉMICA");
		assertEquals(mensaje,resultado.getText().toString());
	}
	
}