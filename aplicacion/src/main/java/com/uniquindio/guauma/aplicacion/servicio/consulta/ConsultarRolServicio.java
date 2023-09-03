package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.RolDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene los roles
 */
@Service
public class ConsultarRolServicio {

    @Autowired
    private RolRepositorio repositorio;

    /**
     * Metodo que obtiene la lista de roles
     * @return  Lista con los roles
     */
    public List<RolDTO> obtenerRoles(){
        return ObjectMapperUtils.mapAll(repositorio.findAll(), RolDTO.class);
    }
}