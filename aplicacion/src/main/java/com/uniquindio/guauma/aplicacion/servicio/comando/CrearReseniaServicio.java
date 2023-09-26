package com.uniquindio.guauma.aplicacion.servicio.comando;

import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearReseniaComando;
import com.uniquindio.guauma.dominio.modelo.Resenia;
import com.uniquindio.guauma.infraestructura.persistencia.ProductoRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ReseniaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que crea una reseña
 */
@Service
public class CrearReseniaServicio {

    @Autowired
    private ReseniaRepositorio reseniaRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    /**
     * Metodo que crea un usuario
     */
    public void crearResenia(CrearReseniaComando comando){
        Resenia resenia = new Resenia();
        resenia.setComentario(comando.getComentario());
        resenia.setPuntaje(comando.getPuntaje());
        resenia.setProducto(productoRepositorio.findByIdProducto(comando.getIdProducto()));
        reseniaRepositorio.save(resenia);
    }
}