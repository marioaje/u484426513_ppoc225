package org.demoClasePooc125.dao;

import org.demoClasePooc125.misc.Conexion;
import org.demoClasePooc125.model.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public List<Profesor> obtenerProfesores(){
        List<Profesor> lista = new ArrayList<Profesor>();

        String sql = "select * from angelica_Profesor";

        try {
            Connection con = Conexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);{
                while (rs.next()) {
                    Profesor items = new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("identificacion"),
                        rs.getString("email"),
                        rs.getString("departamento"),
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

    public void insertarProfesor(Profesor itemProfesor){
        String sql = "INSERT INTO angelica_Profesor (nombre, identificacion, email, departamento, estado) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{
                ps.setString(1, itemProfesor.getNombre());
                ps.setString(2, itemProfesor.getIdentificacion());
                ps.setString(3, itemProfesor.getEmail());
                ps.setString(4, itemProfesor.getDepartamento());
                ps.setString(5, itemProfesor.getEstado());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProfesor(Profesor itemProfesor){
        String sql = "UPDATE angelica_Profesor SET nombre = ?, identificacion = ?, email = ?, departamento = ?, estado = ? WHERE id = ?";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{
                ps.setString(1, itemProfesor.getNombre());
                ps.setString(2, itemProfesor.getIdentificacion());
                ps.setString(3, itemProfesor.getEmail());
                ps.setString(4, itemProfesor.getDepartamento());
                ps.setString(5, itemProfesor.getEstado());
                ps.setInt(6, itemProfesor.getId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProfesor(int id){
        String sql = "DELETE FROM angelica_Profesor WHERE id = ?";

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
