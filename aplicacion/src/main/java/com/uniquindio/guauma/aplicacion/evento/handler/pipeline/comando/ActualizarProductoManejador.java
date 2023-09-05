package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.ActualizarProductoComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.servicio.comando.ActualizarProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para crear o actualizar un producto
 */
@Component
public class ActualizarProductoManejador implements Command.Handler<ActualizarProductoComando, RespuestaComando> {

    @Autowired
    private ActualizarProductoServicio actualizarProductoServicio;

    /**
     * Manejador para crear o actualizar un producto
     * @param comando Comando de Crear o actualizar un producto
     * @return RespuestaComando Retorna la respuesta de la petición
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ActualizarProductoComando comando){
        try {
            actualizarProductoServicio.actualizarProducto(comando);
            return new RespuestaComando(true,"Se guardo correctamente", comando, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new RespuestaComando(false,"Se presento error al guardar producto: " + e, comando, HttpStatus.CONFLICT);
        }
    }
}
