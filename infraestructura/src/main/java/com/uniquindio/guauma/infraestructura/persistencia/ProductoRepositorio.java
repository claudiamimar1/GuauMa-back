package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    Producto findByIdProducto(Long idProducto);
    List<Producto> findByCategoria_Nombre(String categoria);

    List<Producto> findByUsuario_TipoIdentificacion_NombreAndUsuario_NumeroIdentificacion(String tipoIdentificacion,
                                                                                          Long numeroIdentificacion);
}
