package com.uniquindio.guauma.aplicacion.evento.handler.pipeline.consulta;

import an.awesome.pipelinr.Command;
import com.uniquindio.guauma.aplicacion.dto.CategoriaDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.RespuestaComando;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarCategoriasComando;
import com.uniquindio.guauma.aplicacion.servicio.consulta.ConsultarCategoriasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Handler o manejador para obtener las categorias
 */
@Component
public class ConsultarCategoriasManejador implements Command.Handler<ConsultarCategoriasComando, RespuestaComando> {

    @Autowired
    private ConsultarCategoriasServicio consultarCategoriasServicio;

    /**
     * Manejador para obtener la lista de categorias
     * @param comando Comando de Consultar Categorias
     * @return RespuestaComando Retorna la lista de categorias
     * si es exitoso o false en caso contrario
     */
    public RespuestaComando handle(ConsultarCategoriasComando comando){
        List<CategoriaDTO> categorias = consultarCategoriasServicio.obtenerCategorias();
        RespuestaComando respuesta = new RespuestaComando(false,
                "No se encuentran categorías", categorias, HttpStatus.ACCEPTED);

        if (categorias == null || categorias.isEmpty()){
            return respuesta;
        }
        return new RespuestaComando(true,"Consulta exitosa", categorias,
                HttpStatus.ACCEPTED);
    }
}
