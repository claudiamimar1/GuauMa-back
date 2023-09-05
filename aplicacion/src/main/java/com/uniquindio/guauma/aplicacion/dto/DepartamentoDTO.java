package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private Long idDepartamento;

    private Long codigo;

    private String nombre;

    private PaisDTO pais;
}
