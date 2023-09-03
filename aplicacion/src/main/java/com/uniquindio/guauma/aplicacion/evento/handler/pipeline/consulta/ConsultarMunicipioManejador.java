package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.MunicipioDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarMunicipioComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarMunicipioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener los municipios
 */
@Component
public class ConsultarMunicipioManejador implements Command.Handler<ConsultarMunicipioComando, RespuestaComando> {

    @Autowired
    private ConsultarMunicipioServicio service;

    /**
     * Manejador para obtener la lista de municipios
     * @param comando Comando de Consultar municipios
     * @return RespuestaComando Retorna la lista de municipios
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarMunicipioComando comando){
        List<MunicipioDTO> municipios = service.obtenerMunicipios(comando.getCodigoDepartamento());

        if (municipios == null || municipios.isEmpty()){
            return new RespuestaComando(false,"No se encuentran municipios asociados al departamento",
                    municipios, HttpStatus.ACCEPTED);
        }
        return new RespuestaComando(true,"Consulta exitosa", municipios, HttpStatus.ACCEPTED);
    }
}
