
package com.uniquindio.guauma.aplicacion.dto;

import com.uniquindio.guauma.dominio.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
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
