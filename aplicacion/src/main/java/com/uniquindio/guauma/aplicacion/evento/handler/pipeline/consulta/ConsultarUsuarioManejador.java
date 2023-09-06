package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.PaisDTO;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarPaisComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarUsuarioComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarPaisServicio;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarUsuarioServicio;
import com.uniquindio.guauma.dominio.modelo.Usuario;
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
public class ConsultarUsuarioManejador implements Command.Handler<ConsultarUsuarioComando, RespuestaComando> {

    @Autowired
    private ConsultarUsuarioServicio service;

    /**
     * Manejador para obtener la información del usuario
     * @param comando Comando de Consultar Usuario
     * @return RespuestaComando Retorna el usuario consultado por correo
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarUsuarioComando comando){
        UsuarioDTO usuario = service.consultarUsuario(comando.getCorreo());

        if (usuario == null){
            return new RespuestaComando(false,"No se encuentra el usuario", usuario, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", usuario, HttpStatus.ACCEPTED);
    }
}
