package  stepsPO;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import pages.*;
import hooks.Hooks;
import org.openqa.selenium.By;


public class ComprarProdutoPO {

    LoginPage loginPage;
    PaginaDeInventario PaginaDeInventario;
    PaginaDoCarrinho PaginaDoCarrinho;
    PaginaDeCheckout PaginaDeCheckout;
    PaginaDeConfirmacao PaginaDeConfirmacao;

    @Dado("que estou na pagina de login")
    public void que_estou_na_pagina_de_login() {
        // Não é mais necessário inicializar o WebDriver aqui
        loginPage = new LoginPage(Hooks.getDriver());
        Hooks.getDriver().get("https://www.saucedemo.com/");
    }

    @Quando("eu faco login com credenciais validas")
    public void eu_faco_login_com_credenciais_validas() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @E("eu adiciono os produtos {string} ao carrinho")
    public void eu_adiciono_os_produtos_ao_carrinho(String string) {
        PaginaDeInventario = new PaginaDeInventario(Hooks.getDriver());
        PaginaDeInventario.adicionarProdutoAoCarrinho(string);
    }

    @E("eu visualizo o carrinho")
    public void eu_visualizo_o_carrinho() {
        PaginaDeInventario.irParaOCarrinho();
        PaginaDoCarrinho = new PaginaDoCarrinho(Hooks.getDriver());
    }

    @E("eu prossigo para o checkout")
    public void eu_prossigo_para_o_checkout() {
        PaginaDoCarrinho.prosseguirParaCheckout();
        PaginaDeCheckout  = new PaginaDeCheckout (Hooks.getDriver());
    }

    @E("eu preencho as informacoes de checkout")
    public void eu_preencho_as_informacoes_de_checkout() {
        PaginaDeCheckout.preencherInformacoesDeCheckout("Teste", "Usuario", "12345");
    }

    @E("eu confirmo a compra")
    public void eu_confirmo_a_compra() {
        Hooks.getDriver().findElement(By.id("finish")).click();
        PaginaDeConfirmacao = new PaginaDeConfirmacao(Hooks.getDriver());
    }

    @Então("a compra deve ser concluída com sucesso")
    public void a_compra_deve_ser_concluida_com_sucesso() {
        PaginaDeConfirmacao.verificarCompraConcluida();  // Chama o método da página para fazer a asserção
    }
}