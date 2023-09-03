
package com.uniquindio.guauma.dominio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_pk")
    private Long idProducto;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "categoria_fk")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resenia> resenias;
}
