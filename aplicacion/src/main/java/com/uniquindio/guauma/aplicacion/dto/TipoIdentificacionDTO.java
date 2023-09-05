package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoIdentificacionDTO {

    private Long idTipoIdentificacion;

    private String nombre;

    private String descripcion;
}
