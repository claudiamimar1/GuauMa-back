package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.PublicacionDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que consulta las publicaciones
 */
@Service
public class ConsultarPublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    /**
     * Metodo que consulta los publicaciones
     * @return  List<ProductoDTO>
     */
    public List<PublicacionDTO> consultarPublicaciones(){
        return ObjectMapperUtils.mapAll(publicacionRepositorio.findAll(), PublicacionDTO.class);
    }
}