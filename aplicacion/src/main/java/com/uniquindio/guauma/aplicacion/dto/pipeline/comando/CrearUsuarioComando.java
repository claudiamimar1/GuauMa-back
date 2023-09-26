package com.uniquindio.guauma.aplicacion.dto.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.DireccionDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para guardar o actualizar un producto
 */
@Getter
@Setter
public class CrearUsuarioComando implements Command<RespuestaComando> {

    private Long idUsuario;

    private String tipoIdentificacion;

    private Long numeroIdentificacion;

    private String nombreRazonSocial;

    private String correo;

    private String contrasenia;

    private String celular;

    private DireccionDTO direccion;

    private String rol;
}
