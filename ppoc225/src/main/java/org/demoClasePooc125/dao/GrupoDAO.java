package org.demoClasePooc125.dao;

import org.demoClasePooc125.misc.Conexion;
import org.demoClasePooc125.model.Grupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {

    public List<Grupo> obtenerGrupos(){
        List<Grupo> lista = new ArrayList<Grupo>();

        String sql = "select * from angelica_Grupo";

        try {
            Connection con = Conexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);{
                while (rs.next()) {
                    Grupo items = new Grupo(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("estado")
                    );
                    lista.add(items);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertarGrupo(Grupo itemGrupo){
        String sql = "INSERT INTO angelica_Grupo (nombre, descripcion, estado) VALUES (?, ?, ?)";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{

                ps.setString(1, itemGrupo.getNombre());
                ps.setString(2, itemGrupo.getDescripcion());
                ps.setString(3, itemGrupo.getEstado());
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarGrupo(Grupo itemGrupo){
        String sql = "UPDATE angelica_Grupo SET nombre = ?, descripcion = ?, estado = ? WHERE id = ?";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{
                ps.setString(1, itemGrupo.getNombre());
                ps.setString(2, itemGrupo.getDescripcion());
                ps.setString(3, itemGrupo.getEstado());
                ps.setInt(4, itemGrupo.getId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGrupo(int id){
        String sql = "DELETE FROM angelica_Grupo WHERE id = ?";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{
                ps.setInt(1, id);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
