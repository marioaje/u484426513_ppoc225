package org.demoClasePooc125.dao;

import org.demoClasePooc125.misc.Conexion;
import org.demoClasePooc125.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public List<Estudiante> obtenerEstudiantes(){
        List<Estudiante> lista = new ArrayList<Estudiante>();

        String sql = "select * from angelica_Estudiante";

        try {
            Connection con = Conexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);{
                while (rs.next()) {
                    Estudiante items = new Estudiante(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("identificacion"),
                            rs.getString("email"),
                            rs.getString("fecha_nacimiento"),
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

    public void insertarEstudiante(Estudiante itemEstudiante){
        String sql = "INSERT INTO angelica_Estudiante (nombre, identificacion, email, fecha_nacimiento, estado) VALUES (?, ?, ?, ?, ?)";


        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{

                ps.setString(1, itemEstudiante.getNombre());
                ps.setString(2, itemEstudiante.getIdentificacion());
                ps.setString(3, itemEstudiante.getEmail());
                ps.setString(4, itemEstudiante.getFechaNacimiento());
                ps.setString(5, itemEstudiante.getEstado());
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEstudiante(Estudiante itemEstudiante){
        String sql = "UPDATE angelica_Estudiante SET nombre = ?, identificacion = ?, email = ?, fecha_nacimiento = ?, estado = ? WHERE id = ?";

        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);{
                ps.setString(1, itemEstudiante.getNombre());
                ps.setString(2, itemEstudiante.getIdentificacion());
                ps.setString(3, itemEstudiante.getEmail());
                ps.setString(4, itemEstudiante.getFechaNacimiento());
                ps.setString(5, itemEstudiante.getEstado());
                ps.setInt(6, itemEstudiante.getId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEstudiante(int id){
        String sql = "DELETE FROM angelica_Estudiante WHERE id = ?";

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