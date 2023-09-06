package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepositorio extends JpaRepository<Municipio, Long> {

    Municipio findByCodigo(Long codigo);

    List<Municipio> findByDepartamento_Codigo(Long codigo);
}
