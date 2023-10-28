package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gclass {
    
    private int id;
    private String idString;
    private int idTipo;
    private String descripcion;
    private String abreviatura;
    private int marcado;

    //MINUTOS DE TARDANZA PARA HALLAR LAS ÁREAS DEL MES
    private int minutosTardanza;
    
}
