package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.PaisDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarPaisComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarPaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener los paises
 */
@Component
public class ConsultarPaisManejador implements Command.Handler<ConsultarPaisComando, RespuestaComando> {

    @Autowired
    private ConsultarPaisServicio service;

    /**
     * Manejador para obtener la lista de paises
     * @param comando Comando de Consultar Paises
     * @return RespuestaComando Retorna la lista de paises
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarPaisComando comando){
        List<PaisDTO> paises = service.obtenerPaises();

        if (paises == null || paises.isEmpty()){
            return new RespuestaComando(false,"No se encuentran países", paises, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", paises, HttpStatus.ACCEPTED);
    }
}
