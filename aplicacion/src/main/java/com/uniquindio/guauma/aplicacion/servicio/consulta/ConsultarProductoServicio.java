package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.CategoriaDTO;
import com.uniquindio.guauma.aplicacion.dto.DireccionDTO;
import com.uniquindio.guauma.aplicacion.dto.ProductoDTO;
import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.dto.pipeline.consulta.ConsultarProductoComando;
import com.uniquindio.guauma.dominio.modelo.Producto;
import com.uniquindio.guauma.dominio.modelo.Resenia;
import com.uniquindio.guauma.infraestructura.persistencia.ProductoRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.ReseniaRepositorio;
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
        List <ProductoDTO> productos;
        if (comando.getNombreCategoria()!=null){
            List<Producto> productosEntityCategoria = productoRepositorio.findAll();
            productos = crearObjetoProducto(productosEntityCategoria);
        } else if (comando.getTipoIdentificacion() != null && comando.getNumeroIdentificacion()!=null){
            List<Producto> productosEntityUsuario= productoRepositorio.findAll();
            productos = crearObjetoProducto(productosEntityUsuario);
        } else {
            List<Producto> productosEntity = productoRepositorio.findAll();
            productos = crearObjetoProducto(productosEntity);
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

    private List<ProductoDTO> crearObjetoProducto(List<Producto> productosEntity){
        List <ProductoDTO> productos = new ArrayList<>();
        for (Producto producto:productosEntity) {
            ProductoDTO productoDTO = new ProductoDTO();

            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setIdCategoria(producto.getCategoria().getIdCategoria());
            categoriaDTO.setNombre(producto.getCategoria().getNombre());
            categoriaDTO.setDescripcion(producto.getCategoria().getDescripcion());

            DireccionDTO direccionDTO = new DireccionDTO();
            direccionDTO.setIdDireccion(producto.getUsuario().getDireccion().getIdDireccion());
            direccionDTO.setDescripcion(producto.getUsuario().getDireccion().getDescripcion());

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombreRazonSocial(producto.getUsuario().getNombreRazonSocial());
            usuarioDTO.setCorreo(producto.getUsuario().getCorreo());
            usuarioDTO.setCelular(producto.getUsuario().getCelular());
            usuarioDTO.setDireccion(direccionDTO);

            productoDTO.setIdProducto(producto.getIdProducto());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setCategoria(categoriaDTO);
            productoDTO.setUsuario(usuarioDTO);
            productos.add(productoDTO);
        }
        return productos;
    }
}