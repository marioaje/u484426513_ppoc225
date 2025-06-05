package org.demoClasePooc125.view;

import org.demoClasePooc125.controller.GrupoController;
import org.demoClasePooc125.model.Grupo;

import java.util.List;
import java.util.Scanner;

public class GrupoView {

    private static GrupoController controller = new GrupoController();
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        obtenGrupo();
    }



    private static void obtenGrupo(){
        List<Grupo> lista = controller.obtenGrupo();

        for(Grupo itemGrupo : lista){
            System.out.println("id: " + itemGrupo.getId() + "\tNombre: " + itemGrupo.getNombre() + "\tDescripcion: " + itemGrupo.getDescripcion() + "\tEstado: " + itemGrupo.getEstado());
        }
    }

}
