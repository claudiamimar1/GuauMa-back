package com.uniquindio.guauma.aplicacion.servicio.comando;

import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.ActualizarProductoComando;
import com.uniquindio.guauma.dominio.modelo.Producto;
import com.uniquindio.guauma.infraestructura.persistencia.CategoriaRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ProductoRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que crea o actualiza un producto
 */
@Service
public class ActualizarProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /**
     * Metodo que crea o actualiza un producto
     */
    public void actualizarProducto(ActualizarProductoComando comando){
        Producto producto = new Producto();
        producto.setIdProducto(comando.getIdProducto());
        producto.setNombre(comando.getNombre());
        producto.setDescripcion(comando.getDescripcion());
        producto.setPrecio(comando.getPrecio());
        producto.setCategoria(categoriaRepositorio.findByNombre(comando.getNombreCategoria()));
        producto.setUsuario(usuarioRepositorio.findByTipoIdentificacion_NombreAndNumeroIdentificacion(
                comando.getUsuario().getTipoIdentificacion().getNombre(),
                comando.getUsuario().getNumeroIdentificacion()));
        productoRepositorio.save(producto);
    }
}