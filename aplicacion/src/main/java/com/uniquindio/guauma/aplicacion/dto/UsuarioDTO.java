package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long idUsuario;

    private TipoIdentificacionDTO tipoIdentificacion;

    private Long numeroIdentificacion;

    private String nombreRazonSocial;

    private String correo;

    private String contrasenia;

    private String celular;

    private DireccionDTO direccion;

    private RolDTO rol;
}
