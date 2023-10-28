package com.gerencia.prexixion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String dni;
    private String clave;
    private int habilitado;
    private int superUsuario;
    private int admLoginProcesos;
    private int admLoginInventarios;
    private int admLoginBalances;
    private int admFiscalizaciones;
    private int admDepreciaciones;
    private int admLoginTareo;
    private int admServicioPdt601;
    private int admLoginVentas;
}
