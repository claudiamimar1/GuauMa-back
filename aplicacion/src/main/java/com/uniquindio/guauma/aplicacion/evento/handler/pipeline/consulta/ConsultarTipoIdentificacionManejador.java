package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.TipoIdentificacionDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarTipoIdentificacionComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarTipoIdentificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener los tipos de identificacion
 */
@Component
public class ConsultarTipoIdentificacionManejador implements Command.Handler<ConsultarTipoIdentificacionComando, RespuestaComando> {

    @Autowired
    private ConsultarTipoIdentificacionServicio service;

    /**
     * Manejador para obtener la lista de tipos de identificación
     * @param comando Comando de Consultar tipos de identificacion
     * @return RespuestaComando Retorna la lista de paises
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarTipoIdentificacionComando comando){
        List<TipoIdentificacionDTO> tiposIdentificacion = service.obtenerTiposIdentificacion();

        if (tiposIdentificacion == null || tiposIdentificacion.isEmpty()){
            return new RespuestaComando(false,"No se encuentran tipos de identificación", tiposIdentificacion, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", tiposIdentificacion, HttpStatus.ACCEPTED);
    }
}
