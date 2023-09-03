package com.uniquindio.guauma.interfaz.controlador;

import an.awesome.pipelinr.Pipeline;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.ActualizarProductoComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarCategoriasComando;
import com.uniquindio.guauma.aplicacion.util.Constantes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Controlador o Controller para manejar las peticiones API REST para la palicación GuauMa
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api/v1/producto")
@RestController
public class ProductoControlador {

    @Autowired
    private Pipeline pipeline;

    /**
     * Método que obtiene la lista de categorías
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de categorías
     */
    @Operation(summary = "Listar todas las categorías")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarCategoriasComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/categorias")
    public ResponseEntity<RespuestaComando> consultarCategorias() {
        RespuestaComando respuesta = pipeline.send(new ConsultarCategoriasComando());
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

    /**
     * Método que guarda o actualiza un producto
     * @return ResponseEntity<RespuestaComando> Respuesta con el resultado de la petición
     */
    @Operation(summary = "Guardar o actualizar un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ActualizarProductoComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @PostMapping
    public ResponseEntity<RespuestaComando> actualizarProducto(@RequestBody ActualizarProductoComando comando) {
        RespuestaComando respuesta = pipeline.send(comando);
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }
}
