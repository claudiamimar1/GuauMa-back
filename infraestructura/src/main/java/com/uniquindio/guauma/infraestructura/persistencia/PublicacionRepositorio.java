package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {

}
