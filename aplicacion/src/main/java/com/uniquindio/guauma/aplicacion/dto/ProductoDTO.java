
package com.uniquindio.guauma.aplicacion.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private CategoriaDTO categoria;
    private UsuarioDTO usuario;
    private Integer resenias;
}
