package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.ProductoDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarProductoComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener el usuario
 */
@Component
public class ConsultarProductoManejador implements Command.Handler<ConsultarProductoComando, RespuestaComando> {

    @Autowired
    private ConsultarProductoServicio service;

    /**
     * Manejador para traer la lista de productos
     * @param comando Comando de Consultar Producto
     * @return RespuestaComando Retorna la lista de productos
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarProductoComando comando){
        List<ProductoDTO> productos = service.consultarProductos(comando);

        if (productos == null || productos.isEmpty()){
            return new RespuestaComando(false,"No se encuentran productos", productos, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", productos, HttpStatus.ACCEPTED);
    }
}
