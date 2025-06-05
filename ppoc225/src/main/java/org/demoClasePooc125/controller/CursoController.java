package org.demoClasePooc125.controller;

import org.demoClasePooc125.dao.CursoDAO;
import org.demoClasePooc125.model.Curso;

import java.util.List;

public class CursoController {

    private CursoDAO cursoDAO = new CursoDAO();
    
    public List<Curso> obtenerCursos(){
        return cursoDAO.obtenerCursos();
    }

    public boolean insertarCurso(Curso itemCurso){
        return cursoDAO.insertarCurso(itemCurso);
    }
    
    public boolean actualizarCurso(Curso itemCurso){
        return cursoDAO.actualizarCurso(itemCurso);
    }

    public boolean eliminarCurso(int id){
        return cursoDAO.eliminarCurso(id);
    }
}