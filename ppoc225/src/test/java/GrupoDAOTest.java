import org.demoClasePooc125.dao.GrupoDAO;
import org.demoClasePooc125.misc.Conexion;
import org.demoClasePooc125.model.Grupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrupoDAOTest {

    private GrupoDAO grupoDAO;

    @BeforeEach
    public void setUp() {
        grupoDAO = new GrupoDAO();
    }

    @Test
    public void testInsertGrupoYObtnerGrupo () {
        //Crear nuestra entidad de datos para la prueba.
        Grupo grupoPrueba = new Grupo("Grupo test", "descrip", "estado");

        //Insertamos el grupo de prueba
        grupoDAO.insertarGrupo(grupoPrueba);

        //Obtegamos la lista de grupo
        List<Grupo> lista = grupoDAO.obtenGrupo();

        //Verifica que los datos ya se hayn insertados y que esten disponibles.
        assertFalse(lista.isEmpty(), "La lista de datos del grupo esta vacia");


        //Por ultimo comparamos que los datos sean iguales.
        Grupo ultimoDato = lista.get(lista.size()-1);
        assertEquals("Grupo test", ultimoDato.getNombre());
        assertEquals("descrip", ultimoDato.getDescripcion());
        assertEquals("estado", ultimoDato.getEstado());

    }

}
