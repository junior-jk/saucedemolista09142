package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaginaDeInventario {  // A classe não é pública

    WebDriver driver;

    // Construtor
    public PaginaDeInventario(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Método sem 'public void'
    public void adicionarProdutoAoCarrinho(String productName) {  // Método sem 'public' e sem 'void'
        WebElement addToCartButton = driver.findElement(
            By.xpath("//div[contains(@class, 'inventory_item_name') and text()='" + productName + "']/ancestor::div[@class='inventory_item']//following-sibling::div/button")
        );
        addToCartButton.click();
    }
    
    // Método sem 'public void'
    public void irParaOCarrinho() {  // Método sem 'public' e sem 'void'
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
