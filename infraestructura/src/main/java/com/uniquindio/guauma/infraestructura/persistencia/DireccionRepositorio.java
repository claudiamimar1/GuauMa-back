package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Long> {
}
