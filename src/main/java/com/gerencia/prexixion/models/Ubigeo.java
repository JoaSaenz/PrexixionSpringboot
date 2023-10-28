package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ubigeo {
    private Departamento departamento;
    private Provincia provincia;
    private Distrito distrito;

}
