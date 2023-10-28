package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoDeActividad {
    private String dni;
    private int id;
    private String inicio;
    private String baja;
}
