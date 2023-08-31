
package com.uniquindio.guauma.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_pk")
    private Long idCategoria;

    private String nombre;

    private String descripcion;
}
