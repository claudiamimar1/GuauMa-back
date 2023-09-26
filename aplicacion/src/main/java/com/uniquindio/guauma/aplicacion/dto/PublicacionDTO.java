
package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {

    private Long idPublicacion;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private UsuarioDTO usuario;
}
