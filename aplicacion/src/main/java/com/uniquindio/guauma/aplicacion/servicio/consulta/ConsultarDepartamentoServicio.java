package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.DepartamentoDTO;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.infraestructura.persistencia.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene los departamentos
 */
@Service
public class ConsultarDepartamentoServicio {

    @Autowired
    private DepartamentoRepositorio repositorio;

    /**
     * Metodo que obtiene la lista de departamentos
     * @return  Lista con los departamentos
     */
    public List<DepartamentoDTO> obtenerDepartamentos(Long codigoPais){
        return ObjectMapperUtils.mapAll(repositorio.findByPais_Codigo(codigoPais), DepartamentoDTO.class);
    }
}