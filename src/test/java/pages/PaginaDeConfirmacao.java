package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDeConfirmacao {
    WebDriver driver;

    public PaginaDeConfirmacao(WebDriver driver) {
        this.driver = driver;
    }

    // Método para verificar se a compra foi concluída com sucesso
    public void verificarCompraConcluida() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".complete-header"));
        // Verifica se a mensagem de sucesso está presente
        confirmationMessage.getText().contains("THANK YOU FOR YOUR ORDER");
        // Se não for encontrada, uma exceção será lançada automaticamente
    }

    // Método para fechar o navegador
    public void fecharSite() {
        driver.quit();
    }
}
