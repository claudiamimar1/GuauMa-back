package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseniaRepositorio extends JpaRepository<Resenia, Long> {
    List<Resenia> findByProducto_IdProducto(Long idProducto);
}
