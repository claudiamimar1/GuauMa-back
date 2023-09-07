package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Publicacion;
import com.uniquindio.guauma.dominio.modelo.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {

}
