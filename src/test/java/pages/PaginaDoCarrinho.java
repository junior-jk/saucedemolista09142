package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaginaDoCarrinho {
    WebDriver driver;

    public PaginaDoCarrinho(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void prosseguirParaCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
