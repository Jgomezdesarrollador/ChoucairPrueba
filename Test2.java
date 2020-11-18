import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class opensourcecms_dev2 {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-admin/edit.php");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WebElement usuario = driver.findElement(By.name("log"));
		usuario.clear();
		usuario.sendKeys("opensourcecms");
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys("opensourcecms");
		password.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement addNew = driver.findElement(By.className("page-title-action"));
		addNew.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement titulo = driver.findElement(By.id("post-title-0"));
		Date date = new Date();
		titulo.sendKeys("Prueba " + date);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement closeEmergente = driver.findElement(By.className("dashicon dashicons-no-alt"));
		closeEmergente.click();
		
		WebElement addParrafo = driver.findElement(By.className("components-button components-icon-button editor-inserter__toggle block-editor-inserter__toggle"));
		addParrafo.click();
		
		WebElement parrafo = driver.findElement(By.className("editor-block-types-list__item-icon block-editor-block-types-list__item-icon"));
		parrafo.click();
		
		WebElement contenido = driver.findElement(By.className("block-editor-rich-text__editable editor-rich-text__editable wp-block-paragraph"));
		contenido.sendKeys("Mensaje de prueba de la fecha: "+ date );
		
		WebElement publicar = driver.findElement(By.className("components-button editor-post-publish-panel__toggle is-button is-primary"));
		publicar.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
