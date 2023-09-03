package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long idCategoria;

    private String nombre;

    private String descripcion;
}
