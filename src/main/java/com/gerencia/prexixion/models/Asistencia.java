package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {
    private String dni;
    private String fecha;    
    private String mi;
    private String ms;
    private String ti;
    private String ts;
    private String tarde;
}
