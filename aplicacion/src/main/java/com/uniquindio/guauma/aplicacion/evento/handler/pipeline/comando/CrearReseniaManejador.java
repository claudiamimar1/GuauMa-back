package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearReseniaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearUsuarioComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.servicio.comando.CrearReseniaServicio;
import com.uniquindio.guauma.aplicacion.servicio.comando.CrearUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para crear una reseña
 */
@Component
public class CrearReseniaManejador implements Command.Handler<CrearReseniaComando, RespuestaComando> {

    @Autowired
    private CrearReseniaServicio servicio;

    /**
     * Manejador para crear una reseña
     * @param comando Comando de Crear una reseña
     * @return RespuestaComando Retorna la respuesta de la petición
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(CrearReseniaComando comando){
        try {
            servicio.crearResenia(comando);
            return new RespuestaComando(true,"Se guardo correctamente", comando, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new RespuestaComando(false,"Se presento error al crear la reseña: " + e, comando, HttpStatus.CONFLICT);
        }
    }
}
