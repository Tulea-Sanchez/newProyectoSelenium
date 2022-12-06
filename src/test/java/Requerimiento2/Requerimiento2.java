package Requerimiento2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author antho
 */
public class Requerimiento2 {

//    Al dar clic a un contacto de la universidad sea redireccionado al contacto seleccionado.
    private WebDriver driver;
    private static final String TIPO_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_DRIVER = ".\\src\\test\\resources\\chromeDriver\\chromedriver.exe";
    private final String URL = "https://ufidelitas.ac.cr/";

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Inicio del TEST");
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);
    }

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void testEnlaces() throws InterruptedException {

        Wait<WebDriver> fwait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        String mainTab = driver.getWindowHandle();

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        driver.findElement(By.xpath("//a[@aria-label='Whatsapp']")).click();
        List<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        System.out.println("Cantidad de pestañas: " + newTab.size());
        System.out.println("Pestaña 1 Universidad Fidélitas : " + newTab.get(0));
        System.out.println("Pestaña 2 WhatsApp: " + newTab.get(1));
        try {
            WebElement w = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//a[@href='https://web.whatsapp.com/send/?phone=50686068600&text&app_absent=0']")));
            System.out.println("Prueba de enlace Whatsapp aprobada");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Prueba de enlace Whatsapp desaprobada");
        }
        Thread.sleep(5000);
        driver.switchTo().window(newTab.get(1)).close();
        driver.switchTo().window(mainTab);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        driver.findElement(By.xpath("//a[@aria-label='Facebook']")).click();
        List<String> newTab2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab2.get(1));

        System.out.println("Cantidad de pestañas: " + newTab2.size());
        System.out.println("Pestaña 1 Universidad Fidélitas : " + newTab2.get(0));
        System.out.println("Pestaña 2 Facebook: " + newTab2.get(1));
        try {
            WebElement w2 = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//head[title='Universidad Fidélitas - Inicio | Facebook']")));
            System.out.println("Prueba de enlace Facebook aprobada");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Prueba de enlace Facebook desaprobada");
        }
        Thread.sleep(5000);
        driver.switchTo().window(newTab2.get(1)).close();
        driver.switchTo().window(mainTab);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        driver.findElement(By.xpath("//a[@aria-label='Linkedin']")).click();
        List<String> newTab3 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab3.get(1));
        Thread.sleep(2000);
        System.out.println("Cantidad de pestañas: " + newTab3.size());
        System.out.println("Pestaña 1 Universidad Fidélitas : " + newTab3.get(0));
        System.out.println("Pestaña 2 Linkedin: " + newTab3.get(1));
        try {
            WebElement w3 = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//head[title='Universidad Fidélitas | LinkedIn']")));
            
            if(w3.isEnabled()){
                System.out.println("Prueba de enlace Linkedin aprobada");
            }else{
                driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/form/p/button")).click();
                driver.findElement(By.id("session_key")).sendKeys("anthonydfv17@gmail.com");
                driver.findElement(By.id("session_password")).sendKeys("antho78?");
                driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/form/button")).click();
                driver.getTitle();
//                driver.findElement(By.xpath("//head[title='Universidad Fidélitas | LinkedIn']"));
                
            }       
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Prueba de enlace Linkedin desaprobada");
        }
        Thread.sleep(5000);
        driver.switchTo().window(newTab3.get(1)).close();
        driver.switchTo().window(mainTab);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        driver.findElement(By.xpath("//a[@aria-label='Instagram']")).click();
        List<String> newTab4 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab4.get(1));
        Thread.sleep(2000);
        System.out.println("Cantidad de pestañas: " + newTab4.size());
        System.out.println("Pestaña 1 Universidad Fidélitas : " + newTab4.get(0));
        System.out.println("Pestaña 2 Instagram: " + newTab4.get(1));
        try {
            WebElement w4 = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//head[title='Universidad Fidélitas (@ufidelitas) • Fotos y vídeos de Instagram']")));
            System.out.println("Prueba de enlace Instagram aprobada");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Prueba de enlace Instagram desaprobada");
        }
        Thread.sleep(5000);
        driver.switchTo().window(newTab4.get(1)).close();
        driver.switchTo().window(mainTab);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        driver.findElement(By.xpath("//a[@aria-label='Twitter']")).click();
        List<String> newTab5 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab5.get(1));
        Thread.sleep(2000);
        System.out.println("Cantidad de pestañas: " + newTab5.size());
        System.out.println("Pestaña 1 Universidad Fidélitas : " + newTab5.get(0));
        System.out.println("Pestaña 2 Twitter: " + newTab5.get(1));
        try {
            WebElement w5 = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//head[title='Universidad Fidélitas (@ufidelitas_cr) / Twitter']")));
            System.out.println("Prueba de enlace Twitter aprobada");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Prueba de enlace Twitter desaprobada");
        }
        Thread.sleep(5000);
        driver.switchTo().window(newTab5.get(1)).close();
        driver.switchTo().window(mainTab);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finaliza TEST");
    }
}
