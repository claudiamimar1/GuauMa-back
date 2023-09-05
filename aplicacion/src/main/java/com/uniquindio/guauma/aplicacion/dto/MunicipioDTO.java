package com.uniquindio.guauma.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioDTO {

    private Long idMunicipio;

    private Long codigo;

    private String nombre;

    private DepartamentoDTO departamento;
}
