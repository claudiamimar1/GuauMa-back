package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.comando;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearUsuarioComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.servicio.comando.CrearUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para crear un usuario
 */
@Component
public class CrearUsuarioManejador implements Command.Handler<CrearUsuarioComando, RespuestaComando> {

    @Autowired
    private CrearUsuarioServicio servicio;

    /**
     * Manejador para crear un usuario
     * @param comando Comando de Crear un usuario
     * @return RespuestaComando Retorna la respuesta de la petición
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(CrearUsuarioComando comando){
        try {
            servicio.registrarUsuario(comando);
            return new RespuestaComando(true,"Se guardo correctamente", comando, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new RespuestaComando(false,"Se presento error al guardar el usuario: " + e, comando, HttpStatus.CONFLICT);
        }
    }
}
