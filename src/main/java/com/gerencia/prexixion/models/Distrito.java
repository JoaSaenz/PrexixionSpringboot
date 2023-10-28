package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {
    private String idDept;
    private String idProv;
    private String idDist;
    private String descripcion;
}
