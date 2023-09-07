package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.ProductoDTO;
import com.uniquindio.guauma.aplicacion.dto.PublicacionDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarProductoComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarPublicacionComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarProductoServicio;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarPublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para consultar las publicaciones
 */
@Component
public class ConsultarPublicacionManejador implements Command.Handler<ConsultarPublicacionComando, RespuestaComando> {

    @Autowired
    private ConsultarPublicacionServicio service;

    /**
     * Manejador para traer la lista de publicaciones
     * @param comando Comando de Consultar Publicación
     * @return RespuestaComando Retorna la lista de publicaciones
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarPublicacionComando comando){
        List<PublicacionDTO> publicaciones = service.consultarPublicaciones();

        if (publicaciones == null || publicaciones.isEmpty()){
            return new RespuestaComando(false,"No se encuentran publicaciones", publicaciones, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", publicaciones, HttpStatus.ACCEPTED);
    }
}
