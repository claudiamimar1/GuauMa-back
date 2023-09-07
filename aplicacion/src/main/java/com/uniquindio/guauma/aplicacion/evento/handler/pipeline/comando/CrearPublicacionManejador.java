package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearPublicacionComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.servicio.comando.CrearPublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para crear una publicación
 */
@Component
public class CrearPublicacionManejador implements Command.Handler<CrearPublicacionComando, RespuestaComando> {

    @Autowired
    private CrearPublicacionServicio servicio;

    /**
     * Manejador para crear una publicación
     * @param comando Comando de Crear una publicación
     * @return RespuestaComando Retorna la respuesta de la petición
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(CrearPublicacionComando comando){
        try {
            servicio.crearPublicacion(comando);
            return new RespuestaComando(true,"Se guardo correctamente", comando, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new RespuestaComando(false,"Se presento error al crear la publicación: " + e, comando, HttpStatus.CONFLICT);
        }
    }
}
