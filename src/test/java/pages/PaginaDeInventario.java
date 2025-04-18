package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaginaDeInventario {  

    WebDriver driver;

    // Construtor
    public PaginaDeInventario(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public void adicionarProdutoAoCarrinho(String productName) {  
        WebElement addToCartButton = driver.findElement(
            By.xpath("//div[contains(@class, 'inventory_item_name') and text()='" + productName + "']/ancestor::div[@class='inventory_item']//following-sibling::div/button")
        );
        addToCartButton.click();
    }
    
    
    public void irParaOCarrinho() { 
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
