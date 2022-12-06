package Requerimiento10;

import java.io.File;
import java.util.HashMap;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author antho
 */
public class Requerimiento10 {

//    El usuario requiere que al llenar un formulario para descargar 
//    un brochure este le permita descargarlo después de completarlo.
    private WebDriver driver;
    private static final String TIPO_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_DRIVER = ".\\src\\test\\resources\\chromeDriver\\chromedriver.exe";
    private final String URL = "https://ufidelitas.ac.cr/carrera/ingenieria-mecatronica/";
//    private final String URL = "https://ufidelitas.ac.cr/carrera/bachillerato-ingenieria-sistemas-de-computacion/";
    private final String downloadFilePath = "C:\\Users\\antho\\Desktop\\Prueba";

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Inicio del TEST");
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);
    }

    @Before
    public void setUp() {
        //Definicion de preferencias de carpeta de descarga de Chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);

        //Ejecutar las preferencias
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void testBrochurePdf() throws InterruptedException {

        Wait<WebDriver> fwait = new FluentWait<>(driver)
                .withTimeout(120, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        try {
            WebElement w = fwait.until((WebDriver driver1) -> driver1.findElement(By.xpath("//div[@style='display: block;']")));
            System.out.println("Formulario abierto");
            try {
                System.out.println("Llenar campos");
                driver.findElement(By.id("nf-field-128")).sendKeys("Jose");
                driver.findElement(By.id("nf-field-133")).sendKeys("Lopez Villalobos");
                driver.findElement(By.id("nf-field-129")).sendKeys("#########");
                driver.findElement(By.id("nf-field-130")).sendKeys("jlv2@gmail.com");
                driver.findElement(By.id("nf-field-221")).sendKeys("00000000");
                driver.findElement(By.id("nf-field-781")).sendKeys("Heredia");
                driver.findElement(By.id("nf-field-475")).sendKeys("Virtual");
                WebElement wT = fwait.until((WebDriver driver1) -> driver1.findElement(By.className("nf-checked-label")));
                if (wT.isEnabled() == true) {
                    System.out.println("Terminos aceptados");
                    WebElement wP = fwait.until((WebDriver driver1) -> driver1.findElement(By.id("download_file")));

                    if (wP.isEnabled() == true) {
                        System.out.println("Aparece ventana para descargar brochure");
                        Thread.sleep(20000);
//                        File folder = new File(downloadFilePath);
//                        File[] listFiles = folder.listFiles();
//                        if (listFiles.length > 0) {
//                            System.out.println("Se descargó el archivo");
//                        } else {
//                            System.out.println("No se descarga el archivo");
//                            System.out.println("Ruta de descarga: "+downloadFilePath+", cantidad de archivos: "+listFiles.length);
//                        }
                    } else {
                        System.out.println("No aparece ventana para descargar brochure");
                    }

                } else {
                    System.out.println("Terminos no aceptados");
                }

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
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
