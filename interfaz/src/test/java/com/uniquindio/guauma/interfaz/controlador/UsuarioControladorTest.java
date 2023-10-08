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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UsuarioControladorTest {

    @Autowired
    private MockMvc mocMvc;

    String responseConsultarUsuario = "{\"exitoso\":true,\"mensajes\":[\"Consulta exitosa\"],\"data\":{\"idUsuario\":29,\"tipoIdentificacion\":{\"idTipoIdentificacion\":1,\"nombre\":\"CC\",\"descripcion\":\"Cedula\"},\"numeroIdentificacion\":1094957383,\"nombreRazonSocial\":\"Carolina MarÃ\u00ADn HincapiÃ©\",\"correo\":\"cmarinh@uqvirtual.edu.co\",\"contrasenia\":\"4d6a21f24f9e2986949c99f6fff26b3\",\"celular\":\"3116595201\",\"direccion\":{\"idDireccion\":26,\"descripcion\":\"test\",\"codigoMunicipio\":null},\"rol\":{\"idRol\":3,\"nombre\":\"Consumidor\",\"descripcion\":\"Consumidor\"}},\"codigoHttp\":202,\"estadoHttp\":\"ACCEPTED\"}";

    String responseConsultarProveedores = "{\"exitoso\":true,\"mensajes\":[\"Consulta exitosa\"],\"data\":[{\"idUsuario\":30,\"tipoIdentificacion\":{\"idTipoIdentificacion\":1,\"nombre\":\"CC\",\"descripcion\":\"Cedula\"},\"numeroIdentificacion\":1234,\"nombreRazonSocial\":\"Carolina MarÃ\u00ADn HincapiÃ©\",\"correo\":\"cmarinhincapie@gmail.com\",\"contrasenia\":\"4d6a21f24f9e2986949c99f6fff26b3\",\"celular\":\"3116595201\",\"direccion\":{\"idDireccion\":27,\"descripcion\":\"Carrera 6\",\"codigoMunicipio\":null},\"rol\":{\"idRol\":4,\"nombre\":\"Proveedor\",\"descripcion\":\"Proveedor\"}}],\"codigoHttp\":202,\"estadoHttp\":\"ACCEPTED\"}";

    String bodyRegistarUsuario = "{\"idUsuario\": 1,\"tipoIdentificacion\": \"C\",\"numeroIdentificacion\": 1094957383,\"nombreRazonSocial\": \"Carolina\",\"correo\": \"cmarinhincapie@gmail.com\",\"contrasenia\": \"prueba\",\"celular\": \"3116595201\",\"direccion\": {\"idDireccion\": 1,\"descripcion\": \"1\",\"codigoMunicipio\": 1},\"rol\": 1}";

    String responseRoles = "{\"exitoso\":true,\"mensajes\":[\"Consulta exitosa\"],\"data\":[{\"idRol\":3,\"nombre\":\"Consumidor\",\"descripcion\":\"Consumidor\"},{\"idRol\":4,\"nombre\":\"Proveedor\",\"descripcion\":\"Proveedor\"}],\"codigoHttp\":202,\"estadoHttp\":\"ACCEPTED\"}";

    String responseTipoDocumentos = "{\"exitoso\":true,\"mensajes\":[\"Consulta exitosa\"],\"data\":[{\"idTipoIdentificacion\":4,\"nombre\":\"P\",\"descripcion\":\"Pasaporte\"},{\"idTipoIdentificacion\":1,\"nombre\":\"CC\",\"descripcion\":\"Cedula\"},{\"idTipoIdentificacion\":2,\"nombre\":\"CE\",\"descripcion\":\"Cedula Extranjeria\"},{\"idTipoIdentificacion\":3,\"nombre\":\"NIT\",\"descripcion\":\"Nit\"}],\"codigoHttp\":202,\"estadoHttp\":\"ACCEPTED\"}";

    String responseInicioSesion = "{\"exitoso\":true,\"mensajes\":[\"Consulta exitosa\"],\"data\":{\"idUsuario\":29,\"tipoIdentificacion\":{\"idTipoIdentificacion\":1,\"nombre\":\"CC\",\"descripcion\":\"Cedula\"},\"numeroIdentificacion\":1094957383,\"nombreRazonSocial\":\"Carolina MarÃ\u00ADn HincapiÃ©\",\"correo\":\"cmarinh@uqvirtual.edu.co\",\"contrasenia\":null,\"celular\":\"3116595201\",\"direccion\":{\"idDireccion\":26,\"descripcion\":\"test\",\"codigoMunicipio\":null},\"rol\":{\"idRol\":3,\"nombre\":\"Consumidor\",\"descripcion\":\"Consumidor\"}},\"codigoHttp\":202,\"estadoHttp\":\"ACCEPTED\"}";
    @Test
    @DisplayName("Deberia consultar usuario")
    void consultarUsuarioTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario")
                        .param("correo", "cmarinh@uqvirtual.edu.co")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(content().string(responseConsultarUsuario))
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar proveedores")
    void consultarListaProveedoresTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/lista-proveedores")
                        .param("nombre_rol", "Proveedor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(content().string(responseConsultarProveedores))
                .andReturn();
    }

    @Test
    @DisplayName("Deberia registrar usuario")
    void registrarUsuarioTest() throws Exception {
        mocMvc.perform(post("/api/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(bodyRegistarUsuario))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar roles")
    void consultarRolesTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/roles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(content().string(responseRoles))
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar tipos de identificacion")
    void consultarTipoDocumentosTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/tipo-identificacion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(content().string(responseTipoDocumentos))
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar municipios")
    void consultarMunicipiosTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/municipios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("codigoDepartamento", "1"))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar departamentos")
    void consultarDepartamentosTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/departamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("codigoPais", "1"))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia consultar paises")
    void consultarPaisesTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/pais")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia iniciar sesion")
    void iniciarSesionTest() throws Exception {
        mocMvc.perform(get("/api/v1/usuario/iniciar-sesion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("correo","cmarinh@uqvirtual.edu.co")
                        .param("contrasenia","prueba"))
                .andExpect(status().isAccepted())
                .andExpect(content().string(responseInicioSesion))
                .andReturn();
    }
}