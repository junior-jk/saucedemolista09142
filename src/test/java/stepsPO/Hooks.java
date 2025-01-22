package stepsPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Configuração do WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofMillis(8000));
    }

    @After
    public void tearDown() {
        // Fecha o WebDriver após cada teste
                driver.quit();
            
            }
    }
