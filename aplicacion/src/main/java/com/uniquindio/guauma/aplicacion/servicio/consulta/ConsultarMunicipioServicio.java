package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.MunicipioDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.MunicipioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene los departamentos
 */
@Service
public class ConsultarMunicipioServicio {

    @Autowired
    private MunicipioRepositorio repositorio;

    /**
     * Metodo que obtiene la lista de municipios
     * @return  Lista con los municipios
     */
    public List<MunicipioDTO> obtenerMunicipios(Long codigoDepartamento){
        if (codigoDepartamento != 0) {
            return ObjectMapperUtils.mapAll(repositorio.findByDepartamento_Codigo(codigoDepartamento), MunicipioDTO.class);
        } else {
            return ObjectMapperUtils.mapAll(repositorio.findAll(), MunicipioDTO.class);
        }
    }
}