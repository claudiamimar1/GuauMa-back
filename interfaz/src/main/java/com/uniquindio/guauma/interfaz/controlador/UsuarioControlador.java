package com.uniquindio.guauma.interfaz.controlador;

import an.awesome.pipelinr.Pipeline;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.*;
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
 * Clase Controlador o Controller para manejar las peticiones API REST relacionadas al usuario
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api/v1/usuario")
@RestController
public class UsuarioControlador {

    @Autowired
    private Pipeline pipeline;

    /**
     * Método que obtiene los roles
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de roles
     */
    @Operation(summary = "Listar todos los roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarRolComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/roles")
    public ResponseEntity<RespuestaComando> consultarRoles() {
        RespuestaComando respuesta = pipeline.send(new ConsultarRolComando());
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

    /**
     * Método que obtiene los tipos de documentos
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de tipos de documentos
     */
    @Operation(summary = "Listar todos los tipos de documentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarTipoIdentificacionComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/tipo-dentificacion")
    public ResponseEntity<RespuestaComando> consultarTipoDocumentos() {
        RespuestaComando respuesta = pipeline.send(new ConsultarTipoIdentificacionComando());
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

    /**
     * Método que obtiene los municipios
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de municipios
     */
    @Operation(summary = "Listar todos los municipios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarMunicipioComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/municipios")
    public ResponseEntity<RespuestaComando> consultarMunicipios(@RequestParam Long codigoDepartamento) {
        ConsultarMunicipioComando comando = new ConsultarMunicipioComando();
        comando.setCodigoDepartamento(codigoDepartamento);
        RespuestaComando respuesta = pipeline.send(comando);
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

    /**
     * Método que obtiene los departamentos
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de departamentos
     */
    @Operation(summary = "Listar todos los departamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarDepartamentoComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/departamentos")
    public ResponseEntity<RespuestaComando> consultarDepartamentos(@RequestParam Long codigoPais) {
        ConsultarDepartamentoComando comando = new ConsultarDepartamentoComando();
        comando.setCodigoPais(codigoPais);
        RespuestaComando respuesta = pipeline.send(comando);
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

    /**
     * Método que obtiene los paises
     * @return ResponseEntity<RespuestaComando> Respuesta con la lista de paises
     */
    @Operation(summary = "Listar todos los paises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constantes.OK_200, content = { @Content(mediaType = Constantes.APPLICATION_JSON, schema =
            @Schema(implementation = ConsultarPaisComando.class))}, description = Constantes.RESPUESTA_OK),
            @ApiResponse(responseCode = Constantes.NOT_FOUND_404, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.RESPUESTA_NOT_FOUND),
            @ApiResponse(responseCode = Constantes.INTERNAL_SERVER_ERROR_500, content = { @Content(mediaType = Constantes.APPLICATION_JSON)}, description =
                    Constantes.INTERNAL_SERVER_ERROR_500)
    })
    @GetMapping("/pais")
    public ResponseEntity<RespuestaComando> consultarPaises() {
        RespuestaComando respuesta = pipeline.send(new ConsultarPaisComando());
        return new ResponseEntity<>(respuesta, respuesta.getEstadoHttp());
    }

}
