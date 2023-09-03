package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.TipoIdentificacionDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.TipoIdentificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene los tipos de identificación
 */
@Service
public class ConsultarTipoIdentificacionServicio {

    @Autowired
    private TipoIdentificacionRepositorio repositorio;

    /**
     * Metodo que obtiene la lista de tipos de identificacion
     * @return  Lista con los paises
     */
    public List<TipoIdentificacionDTO> obtenerTiposIdentificacion(){
        return ObjectMapperUtils.mapAll(repositorio.findAll(), TipoIdentificacionDTO.class);
    }
}