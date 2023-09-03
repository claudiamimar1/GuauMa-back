package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.PaisDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene los paises
 */
@Service
public class ConsultarPaisServicio {

    @Autowired
    private PaisRepositorio repositorio;

    /**
     * Metodo que obtiene la lista de paises
     * @return  Lista con los paises
     */
    public List<PaisDTO> obtenerPaises(){
        return ObjectMapperUtils.mapAll(repositorio.findAll(), PaisDTO.class);
    }
}