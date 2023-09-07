package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.ProductoDTO;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarProductoComando;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.dominio.modelo.Categoria;
import com.uniquindio.guauma.dominio.modelo.Resenia;
import com.uniquindio.guauma.infraestructura.persistencia.CategoriaRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ProductoRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ReseniaRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que consulta los productos
 */
@Service
public class ConsultarProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ReseniaRepositorio reseniaRepositorio;

    /**
     * Metodo que consulta los productos
     * @return  List<ProductoDTO>
     */
    public List<ProductoDTO> consultarProductos(ConsultarProductoComando comando){
        List <ProductoDTO> productos = new ArrayList<>();
        if (comando.getNombreCategoria()!=null){
            productos = ObjectMapperUtils.mapAll(productoRepositorio.findByCategoria_Nombre(comando.getNombreCategoria()),
                    ProductoDTO.class);
        } else if (comando.getTipoIdentificacion() != null && comando.getNumeroIdentificacion()!=null){
            productos = ObjectMapperUtils.mapAll(
                    productoRepositorio.findByUsuario_TipoIdentificacion_NombreAndUsuario_NumeroIdentificacion(
                            comando.getTipoIdentificacion(), comando.getNumeroIdentificacion()), ProductoDTO.class);
        } else {
            productos = ObjectMapperUtils.mapAll(productoRepositorio.findAll(),ProductoDTO.class);
        }
        return asignarPuntajesResenia(productos);
    }

    private List<ProductoDTO> asignarPuntajesResenia(List<ProductoDTO> productos){
        for (ProductoDTO producto : productos) {
            List<Resenia> resenias = reseniaRepositorio.findByProducto_IdProducto(producto.getIdProducto());
            if (!resenias.isEmpty()) {
                int puntaje = 0;
                for (Resenia resenia:resenias) {
                    puntaje += resenia.getPuntaje();
                }
                producto.setResenias(puntaje/resenias.size());
            }
        }
        return productos;
    }
}