package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.PaisDTO;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.PaisRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene la información del usuario
 */
@Service
public class ConsultarUsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    /**
     * Metodo que obtiene el usuario
     * @return  Usuario
     */
    public UsuarioDTO consultarUsuario(String correo){
        return ObjectMapperUtils.map(repositorio.findByCorreo(correo), UsuarioDTO.class);
    }
}