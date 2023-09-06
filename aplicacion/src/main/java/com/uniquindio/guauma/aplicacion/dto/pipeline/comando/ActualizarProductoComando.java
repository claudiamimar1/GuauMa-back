package com.uniquindio.guauma.aplicacion.dto.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.CategoriaDTO;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para guardar o actualizar un producto
 */
@Getter
@Setter
public class ActualizarProductoComando implements Command<RespuestaComando> {

    private Long idProducto;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private String nombreCategoria;

    private UsuarioDTO usuario;
}
