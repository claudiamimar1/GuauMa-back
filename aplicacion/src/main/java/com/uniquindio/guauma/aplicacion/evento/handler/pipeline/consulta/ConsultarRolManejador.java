package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.RolDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarRolComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarRolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener los roles
 */
@Component
public class ConsultarRolManejador implements Command.Handler<ConsultarRolComando, RespuestaComando> {

    @Autowired
    private ConsultarRolServicio service;

    /**
     * Manejador para obtener la lista de roles
     * @param comando Comando de Consultar roles
     * @return RespuestaComando Retorna la lista de roles
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarRolComando comando){
        List<RolDTO> roles = service.obtenerRoles();

        if (roles == null || roles.isEmpty()){
            return new RespuestaComando(false,"No se encuentran roles", roles, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", roles, HttpStatus.ACCEPTED);
    }
}
