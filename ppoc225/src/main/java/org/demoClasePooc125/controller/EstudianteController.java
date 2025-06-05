package org.demoClasePooc125.controller;

import org.demoClasePooc125.dao.EstudianteDAO;
import org.demoClasePooc125.model.Estudiante;

import java.util.List;

public class EstudianteController {

    private EstudianteDAO estudianteDAO = new EstudianteDAO();
    
    public List<Estudiante> obtenerEstudiantes(){
        return estudianteDAO.obtenerEstudiantes();
    }

    public boolean insertarEstudiante(Estudiante itemEstudiante){
        return estudianteDAO.insertarEstudiante(itemEstudiante);
    }

    public boolean actualizarEstudiante(Estudiante itemEstudiante){
        return estudianteDAO.actualizarEstudiante(itemEstudiante);
    }

    public boolean eliminarEstudiante(int id){
        return estudianteDAO.eliminarEstudiante(id);
    }
}