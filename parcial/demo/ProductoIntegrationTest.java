package com.example.demo;

import com.example.demo.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCrearProducto() {
        Producto producto = new Producto(null, "Celular", 1500.0);
        webTestClient.post().uri("/api/productos")
                .body(Mono.just(producto), Producto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Celular");
    }

    @Test
    void testObtenerProductoPorId() {
        String id = "1"; // Usa un ID válido
        webTestClient.get().uri("/api/productos/" + id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(id);
    }

    @Test
    void testEliminarProducto() {
        String id = "1"; // Usa un ID válido
        webTestClient.delete().uri("/api/productos/" + id)
                .exchange()
                .expectStatus().isNoContent();
    }
}
