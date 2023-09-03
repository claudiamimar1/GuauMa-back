
package com.uniquindio.guauma.aplicacion.dto;

import com.uniquindio.guauma.dominio.modelo.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

public class MunicipioDTO {

    private Long idMunicipio;

    private Long codigo;

    private String nombre;

    private DepartamentoDTO departamento;
}
