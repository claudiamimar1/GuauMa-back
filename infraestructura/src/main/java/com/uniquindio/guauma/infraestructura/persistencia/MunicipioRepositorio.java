package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Departamento;
import com.uniquindio.guauma.dominio.modelo.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepositorio extends JpaRepository<Municipio, Long> {

    List<Municipio> findByCodigo(Long codigo);
}
