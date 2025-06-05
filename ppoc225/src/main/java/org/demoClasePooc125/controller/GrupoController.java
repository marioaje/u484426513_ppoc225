package org.demoClasePooc125.controller;

import org.demoClasePooc125.dao.GrupoDAO;
import org.demoClasePooc125.model.Grupo;

import java.util.List;

public class GrupoController {

    private GrupoDAO grupoDAO = new GrupoDAO();

    public List<Grupo> obtenGrupo(){
        return grupoDAO.obtenGrupo();
    }

    public void insertarGrupo(Grupo itemGrupo) {
        grupoDAO.insertarGrupo(itemGrupo);
    }

    public boolean actualizarGrupo(Grupo itemGrupo) {
        return grupoDAO.actualizarGrupo(itemGrupo);
    }

    public boolean eliminarGrupo(int id) {
        return grupoDAO.eliminarGrupo(id);
    }
}
