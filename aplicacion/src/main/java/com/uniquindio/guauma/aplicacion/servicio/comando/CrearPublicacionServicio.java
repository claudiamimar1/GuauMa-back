package com.uniquindio.guauma.aplicacion.servicio.comando;

import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearPublicacionComando;
import com.uniquindio.guauma.dominio.modelo.Publicacion;
import com.uniquindio.guauma.infraestructura.persistencia.PublicacionRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que crea una reseña
 */
@Service
public class CrearPublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /**
     * Metodo que crea un usuario
     */
    public void crearPublicacion(CrearPublicacionComando comando){
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(comando.getTitulo());
        publicacion.setDescripcion(comando.getDescripcion());
        publicacion.setFecha(comando.getFecha());
        publicacion.setUsuario(usuarioRepositorio.findByIdUsuario(comando.getIdUsuario()));
        publicacionRepositorio.save(publicacion);
    }
}