package com.gerencia.prexixion.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gerencia.prexixion.models.Personal;
import com.gerencia.prexixion.models.User;

@Repository
public class PersonalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // LOGIN
    public Personal login(String dni, String clave) throws Exception {

        String query = """
                SELECT p.dni, p.apellidos, p.nombres,
                SUBSTRING (p.apellidos, 1,
                	CASE WHEN CHARINDEX(' ', p.apellidos)-1 < 0
                	     THEN LEN (p.apellidos)
                	     ELSE CHARINDEX(' ', p.apellidos)-1
                	END) 
                AS primerApellido,
                SUBSTRING (p.nombres, 1,
                	CASE WHEN CHARINDEX(' ', p.nombres)-1 < 0 
                	     THEN LEN (p.nombres)
                	     ELSE CHARINDEX(' ', p.nombres)-1
                	END) 
                AS primerNombre,
                p.idArea, a.descripcion as descArea, p.idPuesto, pu.descripcion as descPuesto,
                u.clave, u.habilitado, u.superUsuario, u.admLoginProcesos, u.admLoginInventarios, 
                u.admLoginBalances, u.admFiscalizaciones, u.admDepreciaciones,
                u.admLoginTareo, u.admServicioPdt601, u.admLoginVentas
                FROM personal p
                INNER JOIN users u ON p.dni = u.dni
                LEFT JOIN areas a ON p.idArea = a.id
                LEFT JOIN personalPuestos pu ON p.idPuesto = pu.id
                WHERE p.dni = ? AND u.clave = ?
                """;
        
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Personal personal = new Personal();
            personal.setDni(dni);
            personal.setApellidos(rs.getString("apellidos"));
            personal.setPrimerApellido(rs.getString("primerApellido"));
            personal.setNombres(rs.getString("nombres"));
            personal.setPrimerNombre(rs.getString("primerNombre"));
            personal.setIdArea(rs.getInt("idArea"));
            personal.setArea(rs.getString("descArea"));
            personal.setIdPuesto(rs.getInt("idPuesto"));
            personal.setPuesto(rs.getString("descPuesto"));

            //Usuario
            User user = new User();
            user.setClave(rs.getString("clave"));
            user.setHabilitado(rs.getInt("habilitado"));
            user.setSuperUsuario(rs.getInt("superUsuario"));
            user.setAdmLoginProcesos(rs.getInt("admLoginProcesos"));
            user.setAdmLoginInventarios(rs.getInt("admLoginInventarios"));
            user.setAdmLoginBalances(rs.getInt("admLoginBalances"));
            user.setAdmFiscalizaciones(rs.getInt("admFiscalizaciones"));
            user.setAdmDepreciaciones(rs.getInt("admDepreciaciones"));
            user.setAdmLoginTareo(rs.getInt("admLoginTareo"));
            user.setAdmServicioPdt601(rs.getInt("admServicioPdt601"));
            user.setAdmLoginVentas(rs.getInt("admLoginVentas"));
            personal.setUser(user);

            return personal;
        }, dni, clave);

        

    }

}
