package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.CategoriaDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene las categorías
 */
@Service
public class ConsultarCategoriasServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    /**
     * Metodo que obtiene la lista de categorías
     * @return  Lista con las categorías
     */
    public List<CategoriaDTO> obtenerCategorias(){
        return ObjectMapperUtils.mapAll(categoriaRepositorio.findAll(), CategoriaDTO.class);
    }
}