package com.universidad.productosservice.service;

import com.universidad.productosservice.domain.Producto;
import com.universidad.productosservice.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void listarTodos_retornaListaProductos() {
        when(productoRepository.findAll()).thenReturn(List.of(
                new Producto(1L, "Laptop", 1500.0, 10)
        ));

        List<Producto> productos = productoService.listarTodos();

        assertEquals(1, productos.size());
        assertEquals("Laptop", productos.get(0).getNombre());
    }

    @Test
    void crear_datosValidos_guardaProducto() {
        Producto productoGuardado = new Producto(1L, "Tablet", 800.0, 5);

        when(productoRepository.save(any(Producto.class))).thenReturn(productoGuardado);

        Producto resultado = productoService.crear("Tablet", 800.0, 5);

        assertNotNull(resultado.getId());
        assertEquals("Tablet", resultado.getNombre());
    }

    @Test
    void buscarPorId_existente_retornaProducto() {
        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(new Producto(1L, "Mouse", 50.0, 100)));

        Producto resultado = productoService.buscarPorId(1L);

        assertEquals("Mouse", resultado.getNombre());
    }

    @Test
    void buscarPorId_noExistente_lanzaRuntimeException() {
        when(productoRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> productoService.buscarPorId(99L)
        );

        assertEquals("Producto no encontrado: 99", exception.getMessage());
    }
}