package com.uniquindio.guauma.aplicacion.dto.pipeline.comando;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para crear una reseña
 */
@Getter
@Setter
public class CrearReseniaComando implements Command<RespuestaComando> {
    private Integer puntaje;
    private String comentario;
    private Long idProducto;
}
