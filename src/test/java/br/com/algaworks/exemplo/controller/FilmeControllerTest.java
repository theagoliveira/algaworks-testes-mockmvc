package br.com.algaworks.exemplo.controller;

import br.com.algaworks.exemplo.model.Filme;
import br.com.algaworks.exemplo.service.FilmeService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.*;

@WebMvcTest
public class FilmeControllerTest {

    @Autowired
    private FilmeController filmeController;

    @MockBean
    private FilmeService filmeService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.filmeController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarFilme() {
        when(this.filmeService.obterFilme(1L)).thenReturn(new Filme(
                1L,
                "O Poderoso Chefão",
                "Filme norte-americano de 1972, dirigido por Francis Ford Coppola"
        ));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {
        when(this.filmeService.obterFilme(101L)).thenReturn(null);

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 101L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarBadRequest_QuandoBuscarFilme() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", -1L)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

        verify(this.filmeService, never()).obterFilme(-1L);
    }

}
