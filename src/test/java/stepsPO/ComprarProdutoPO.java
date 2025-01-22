package stepsPO;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class ComprarProdutoPO {

    WebDriver driver;
    LoginPage loginPage;
    PaginaDeInventario PaginaDeInventario;
    PaginaDoCarrinho PaginaDoCarrinho;
    PaginaDeCheckout PaginaDeCheckout;
    PaginaDeConfirmacao PaginaDeConfirmacao;

    @Dado("que estou na pagina de login")
    public void que_estou_na_pagina_de_login() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Quando("eu faco login com credenciais validas")
    public void eu_faco_login_com_credenciais_validas() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @E("eu adiciono os produtos {string} ao carrinho")
    public void eu_adiciono_os_produtos_ao_carrinho(String string) {
        PaginaDeInventario = new PaginaDeInventario(driver);
        PaginaDeInventario.adicionarProdutoAoCarrinho(string);
    }

    @E("eu visualizo o carrinho")
    public void eu_visualizo_o_carrinho() {
        PaginaDeInventario.irParaOCarrinho();
        PaginaDoCarrinho = new PaginaDoCarrinho(driver);
    }

    @E("eu prossigo para o checkout")
    public void eu_prossigo_para_o_checkout() {
        PaginaDoCarrinho.prosseguirParaCheckout();
        PaginaDeCheckout  = new PaginaDeCheckout (driver);
    }

    @E("eu preencho as informacoes de checkout")
    public void eu_preencho_as_informacoes_de_checkout() {
        PaginaDeCheckout .preencherInformacoesDeCheckout("Teste", "Usuario", "12345");
    }

    @E("eu confirmo a compra")
    public void eu_confirmo_a_compra() {
        driver.findElement(By.id("finish")).click();
        PaginaDeConfirmacao = new PaginaDeConfirmacao(driver);
    }

    @Então("a compra deve ser concluída com sucesso")
    public void a_compra_deve_ser_concluida_com_sucesso() {
        PaginaDeConfirmacao.verificarCompraConcluida();  // Chama o método da página para fazer a asserção
    driver.quit();
}

}