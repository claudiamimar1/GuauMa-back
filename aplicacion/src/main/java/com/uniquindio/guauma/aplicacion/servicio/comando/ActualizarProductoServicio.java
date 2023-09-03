package com.uniquindio.guauma.aplicacion.servicio.comando;

import com.uniquindio.guauma.aplicacion.dto.CategoriaDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.ActualizarProductoComando;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.dominio.modelo.Producto;
import com.uniquindio.guauma.infraestructura.persistencia.CategoriaRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que crea o actualiza un producto
 */
@Service
public class ActualizarProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    /**
     * Metodo que crea o actualiza un producto
     */
    public void actualizarProducto(ActualizarProductoComando comando){
        productoRepositorio.save(ObjectMapperUtils.map(comando, Producto.class));
    }
}