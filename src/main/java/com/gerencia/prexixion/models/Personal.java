package com.gerencia.prexixion.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    private int internoExterno;
    private String dni;
    private String clave;

    private String apellidos;
    private String primerApellido;
    private String nombres;
    private String primerNombre;
    private String nombreCorto;
    private String iniciales;
    private String fNacimiento;
    private Ubigeo ubigeoNacimiento;
    private String nacionalidad;
    private String residencia;
    private String telefonos;
    private String correos;
    private int idSexo;
    private String sexo;
    private int idEstadoCivil;
    private String estadoCivil;
    private int nroHijos;
    
    //Datos de emergencia
    private String nombresContactoEmergencia;
    private Gclass gradoParentesco;
    private String telefonoContactoEmergencia;
    
    //Datos academicos
    private int idGradoAcademico;
    private String gradoAcademico;
    private Gclass nivel;
    private int idCentroDeEstudios;
    private String centroDeEstudios;
    private Gclass carrera;
    
    //Datos del puesto
    private int idEstado;
    private String estado;
    private String fechaActivo;    
    private String fechaBaja;
    private int idArea;
    private String area;
    private int idPuesto;
    private String puesto;
    private int idProceso;
    private String proceso;
    
    //PERIODOS DE ACTIVIDAD
    private List<PeriodoDeActividad> periodosDeActividad;
    
    //Datos internos
    private int idEmpresa;
    private String empresa;
    private int idTipo;
    private String tipo;
    private Gclass turno;
    private Gclass tipoContrato;
    private String duracionContrato;
    private String situacionEspecial;
    private Gclass jornadaLaboral;
    private Gclass sistemaAporte;
    private Gclass tipoPago;
    private Gclass entidadFinanciera;
    private String nroCtaBcp;
    private String ruc;
    private String rucUsuario;
    private String rucClave;
    private String scrt;
    private String polizaVidaLey;
    private String direccionAtencionEssalud;
    
    //Datos corporativos
    private String correoCorporativo;
    private String telefonoCorporativo;
    
    //Comentarios
    private String comentarios;
    
    //Modal Users
    private User user;
    private Asistencia asistencia;
    private Permisos permisos;
    
    //PARA EL MANEJO DEL LOGIN
    private int message;
    
    //MINUTOS DE TARDANZA PARA HALLAR AL TARDÓN DEL MES
    private int minutosTardanza;
        
    //ASIGNACION PERSONAL
    private int nroAsignacionPersonal;
    
    //PERSONAL IMAGEN
    private String nombreImagen;
    
    //PERSONAL (FICHA);
    private String anios;
    private String record;
    
    //DIAS TRABAJADOS MENSUALMENTE
    private int asistenciasTrabajadas;
    private double diasTrabajados;    
    
}
