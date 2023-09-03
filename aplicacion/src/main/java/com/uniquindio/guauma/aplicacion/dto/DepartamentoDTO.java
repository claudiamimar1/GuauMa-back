
package com.uniquindio.guauma.aplicacion.dto;

import com.uniquindio.guauma.dominio.modelo.Pais;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

public class DepartamentoDTO {

    private Long idDepartamento;

    private Long codigo;

    private String nombre;

    private PaisDTO pais;
}
