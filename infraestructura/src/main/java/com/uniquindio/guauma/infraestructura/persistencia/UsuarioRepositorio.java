package com.uniquindio.guauma.infraestructura.persistencia;

import com.uniquindio.guauma.dominio.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByIdUsuario(Long idUsuario);

    Usuario findByCorreo(String correo);

    Usuario findByTipoIdentificacion_NombreAndNumeroIdentificacion(String tipoIdentificacion, Long numeroIdentificacion);

    List<Usuario> findByRol_IdRol(Long id_rol);

}
