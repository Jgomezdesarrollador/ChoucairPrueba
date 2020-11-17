import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPagesPublicadas {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-admin/edit.php?post_type=page");
		
	}
	
	@Test
	public void testPagesUpdate() {
		WebElement usuario = driver.findElement(By.name("log"));
		usuario.clear();
		usuario.sendKeys("opensourcecms");
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys("opensourcecms");
		password.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
