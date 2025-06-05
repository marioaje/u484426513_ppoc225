package org.demoClasePooc125.dao;

import org.demoClasePooc125.misc.Conexion;
import org.demoClasePooc125.model.GrupoCurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoCursoDAO {

    public List<GrupoCurso> obtenerGrupoCursos() {
        List<GrupoCurso> lista = new ArrayList<GrupoCurso>();

        String sql = "select * from angelica_GrupoCurso";

        try {
            Connection con = Conexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); {
                while (rs.next()) {
                    GrupoCurso items = new GrupoCurso(
                            rs.getInt("id"),
                            rs.getInt("grupo_id"),
                            rs.getInt("curso_id")
                    );
                    lista.add(items);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertarGrupoCurso(GrupoCurso itemGrupoCurso) {
        String sql = "INSERT INTO angelica_GrupoCurso (grupo_id, curso_id) VALUES (?, ?)";

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql); {
                ps.setInt(1, itemGrupoCurso.getGrupoId());
                ps.setInt(2, itemGrupoCurso.getCursoId());
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarGrupoCurso(GrupoCurso itemGrupoCurso) {
        String sql = "UPDATE angelica_GrupoCurso SET grupo_id = ?, curso_id = ? WHERE id = ?";

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql); {
                ps.setInt(1, itemGrupoCurso.getGrupoId());
                ps.setInt(2, itemGrupoCurso.getCursoId());
                ps.setInt(3, itemGrupoCurso.getId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGrupoCurso(int id) {
        String sql = "DELETE FROM angelica_GrupoCurso WHERE id = ?";

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql); {
                ps.setInt(1, id);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}