
package com.uniquindio.guauma.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_pk")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "tipo_identificacion_fk")
    private TipoIdentificacion tipoIdentificacion;

    private Long numeroIdentificacion;

    private String nombreRazonSocial;

    private String correo;

    private String celular;

    @ManyToOne
    @JoinColumn(name = "direccion_fk")
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "rol_fk")
    private Rol rol;
}
