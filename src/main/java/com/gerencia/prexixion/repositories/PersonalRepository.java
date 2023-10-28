package com.gerencia.prexixion.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

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
        String query = "select p.dni, p.apellidos, p.nombres,"
                + "SUBSTRING (p.apellidos, 1, \n"
                + "	CASE \n"
                + "	WHEN CHARINDEX(' ', p.apellidos)-1 < 0 \n"
                + "	THEN LEN (p.apellidos) \n"
                + "	ELSE CHARINDEX(' ', p.apellidos)-1 \n"
                + "	END) as primerApellido, \n"
                + "SUBSTRING (p.nombres, 1, \n"
                + "	CASE \n"
                + "	WHEN CHARINDEX(' ', p.nombres)-1 < 0 \n"
                + "	THEN LEN (p.nombres) \n"
                + "	ELSE CHARINDEX(' ', p.nombres)-1 \n"
                + "	END) as primerNombre,"
                + "p.idArea, a.descripcion as descArea, \n"
                + "p.idPuesto, pu.descripcion as descPuesto, \n"
                + "u.clave, u.habilitado, u.superUsuario, u.admLoginProcesos, u.admLoginInventarios, u.admLoginBalances, u.admFiscalizaciones, u.admDepreciaciones, \n"
                + "u.admLoginTareo, u.admServicioPdt601, u.admLoginVentas \n"
                + "from personal p \n"
                + "inner join users u on p.dni = u.dni \n"
                + "left join areas a on p.idArea = a.id \n"
                + "left join personalPuestos pu on p.idPuesto = pu.id \n"
                + "where p.dni = ? and u.clave = ?";

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
