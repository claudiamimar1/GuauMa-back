package com.uniquindio.guauma.aplicacion.dto.pipeline.comando;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para crear una publicación
 */
@Getter
@Setter
public class CrearPublicacionComando implements Command<RespuestaComando> {
    private String titulo;
    private String descripcion;
    private Date fecha;
    private Long idUsuario;
}
