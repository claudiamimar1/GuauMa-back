
package com.uniquindio.guauma.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resenia_pk")
    private Long idResenia;

    private Integer puntaje;

    private String comentario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_fk")
    private Producto producto;
}
