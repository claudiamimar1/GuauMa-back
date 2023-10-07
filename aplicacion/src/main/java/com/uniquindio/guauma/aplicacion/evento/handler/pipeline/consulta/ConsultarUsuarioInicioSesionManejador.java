package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarUsuarioComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarUsuarioInicioSesionComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener el usuario
 */
@Component
public class ConsultarUsuarioInicioSesionManejador implements Command.Handler<ConsultarUsuarioInicioSesionComando, RespuestaComando> {

    @Autowired
    private ConsultarUsuarioServicio service;

    /**
     * Manejador para obtener la información del usuario
     * @param comando Comando de Consultar Usuario
     * @return RespuestaComando Retorna el usuario consultado por correo
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarUsuarioInicioSesionComando comando) {

        UsuarioDTO usuario;
        try {
            usuario = service.consultarUsuarioInicioSesion(comando.getCorreo(), comando.getContrasenia());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException |
                 IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }

        if (usuario == null){
            return new RespuestaComando(false,"El correo y la constraseña no coinciden", usuario, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", usuario, HttpStatus.ACCEPTED);
    }
}
