package org.demoClasePooc125.controller;

import org.demoClasePooc125.dao.ProfesorDAO;
import org.demoClasePooc125.model.Profesor;

import java.util.List;

public class ProfesorController {
    
    private ProfesorDAO profesorDAO = new ProfesorDAO();

    public List<Profesor> obtenerProfesores(){
        return profesorDAO.obtenerProfesores();
    }

    public boolean insertarProfesor(Profesor itemProfesor){
        return profesorDAO.insertarProfesor(itemProfesor);
    }

    public boolean actualizarProfesor(Profesor itemProfesor){
        return profesorDAO.actualizarProfesor(itemProfesor);
    }

    public boolean eliminarProfesor(int id){
        return profesorDAO.eliminarProfesor(id);
    }
}
