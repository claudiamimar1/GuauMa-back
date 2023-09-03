package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.DepartamentoDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarDepartamentoComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarDepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener los departamentos
 */
@Component
public class ConsultarDepartamentoManejador implements Command.Handler<ConsultarDepartamentoComando, RespuestaComando> {

    @Autowired
    private ConsultarDepartamentoServicio service;

    /**
     * Manejador para obtener la lista de departamentos
     * @param comando Comando de Consultar departamentos
     * @return RespuestaComando Retorna la lista de departamentos
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarDepartamentoComando comando){
        List<DepartamentoDTO> departamentos = service.obtenerDepartamentos(comando.getCodigoPais());

        if (departamentos == null || departamentos.isEmpty()){
            return new RespuestaComando(false,"No se encuentran departamentos asociados al país",
                    departamentos, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", departamentos, HttpStatus.ACCEPTED);
    }
}
