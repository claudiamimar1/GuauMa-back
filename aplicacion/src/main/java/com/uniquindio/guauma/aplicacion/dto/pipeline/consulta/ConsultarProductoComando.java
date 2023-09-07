package com.uniquindio.guauma.aplicacion.dto.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para consultar los productos
 */
@Getter
@Setter
public class ConsultarProductoComando implements Command<RespuestaComando> {
    private String nombreCategoria;
    private String tipoIdentificacion;
    private Long numeroIdentificacion;
}
