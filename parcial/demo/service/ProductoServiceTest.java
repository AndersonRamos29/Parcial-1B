package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.MockitoAnnotations;

import java.util.List;

@SpringBootTest
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    public ProductoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarProductos() {
        when(productoRepository.findAll()).thenReturn(Flux.just(new Producto("1", "Laptop", 1000.0)));

        productoService.listarProductos().subscribe(producto -> {
            assertEquals("Laptop", producto.getNombre());
        });
    }

    @Test
    public void testObtenerProductoPorId() {
        when(productoRepository.findById("1")).thenReturn(Mono.just(new Producto("1", "Mouse", 20.0)));

        productoService.obtenerProductoPorId("1").subscribe(producto -> {
            assertEquals("Mouse", producto.getNombre());
        });
    }

    @Test
    public void testCrearProducto() {
        Producto p = new Producto("2", "Teclado", 50.0);
        when(productoRepository.save(p)).thenReturn(Mono.just(p));

        productoService.crearProducto(p).subscribe(producto -> {
            assertEquals("Teclado", producto.getNombre());
        });
    }
}
