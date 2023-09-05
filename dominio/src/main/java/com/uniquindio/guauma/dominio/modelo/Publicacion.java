
package com.uniquindio.guauma.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publicacion_pk")
    private Long idPublicacion;

    private String titulo;

    private String descripcion;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
}
