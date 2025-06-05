package org.demoClasePooc125.controller;

import org.demoClasePooc125.dao.GrupoCursoDAO;
import org.demoClasePooc125.model.GrupoCurso;

import java.util.List;

public class GrupoCursoController {

    private GrupoCursoDAO grupoCursoDAO = new GrupoCursoDAO();
    
    public List<GrupoCurso> obtenerGruposCursos(){
        return grupoCursoDAO.obtenerGruposCursos();
    }

    public boolean insertarGrupoCurso(GrupoCurso itemGrupoCurso){
        return grupoCursoDAO.insertarGrupoCurso(itemGrupoCurso);
    }

    public boolean actualizarGrupoCurso(GrupoCurso itemGrupoCurso){
        return grupoCursoDAO.actualizarGrupoCurso(itemGrupoCurso);
    }

    public boolean eliminarGrupoCurso(int id){
        return grupoCursoDAO.eliminarGrupoCurso(id);
    }
}