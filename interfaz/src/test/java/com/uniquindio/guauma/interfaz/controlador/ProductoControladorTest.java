package com.uniquindio.guauma.interfaz.controlador;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductoControladorTest {

    @Autowired
    private MockMvc mocMvc;

    String bodyGuardarProducto = "{\"idProducto\": 2,\"nombre\": \"Cuido\",\"descripcion\": \"Virbac\",\"precio\": 80000,\"nombreCategoria\": \"Veterinaria\",\"usuario\": {\"tipoIdentificacion\": {\"idTipoIdentificacion\": 1,\"nombre\": \"CC\",\"descripcion\": \"Cedula\"},\"numeroIdentificacion\": \"1094957383\"}}";

    String bodyCrearResenia = "{\"puntaje\": 3,\"comentario\": \"Prueba comentario\",\"idProducto\": 1}";

    String bodyCrearPublicacion ="{\"titulo\": \"Prueba\",\"descripcion\": \"Prueba descripcion publicacion\",\"fecha\": \"1696740861092\",\"idUsuario\": 29}";

    @Test
    @DisplayName("Deberia consultar categorias")
    void consultarCategoriasTest() throws Exception {
        mocMvc.perform(get("/api/v1/producto/categorias")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia guardar producto")
    void registrarUsuarioTest() throws Exception {
        mocMvc.perform(post("/api/v1/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyGuardarProducto))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar productos por proveedor")
    void consultarProductosProveedorTest() throws Exception {
        mocMvc.perform(get("/api/v1/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("tipoIdentificacion","C")
                        .param("numeroIdentificacion","1094957383"))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar productos por categoria")
    void consultarProductosCategoriaTest() throws Exception {
        mocMvc.perform(get("/api/v1/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("nombreCategoria","Entretenimiento"))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia crear reseña")
    void crearReseniaTest() throws Exception {
        mocMvc.perform(post("/api/v1/producto/resenia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyCrearResenia))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia crear publicacion")
    void crearPublicacionTest() throws Exception {
        mocMvc.perform(post("/api/v1/producto/publicacion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyCrearPublicacion))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar publicaciones")
    void consultarPublicacionTest() throws Exception {
        mocMvc.perform(get("/api/v1/producto/publicacion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }
}