package dao;

import dto.SocioDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class SociosDAOTest {

    private SociosDAO instance;

    public SociosDAOTest() {
        List<SocioDTO> listaSocios = new ArrayList<>();
        listaSocios.add(new SocioDTO("Anibal", "22", "River", "Casado", "Universitario"));
        listaSocios.add(new SocioDTO("Anibal", "22", "River", "Casado", "Terciario"));
        listaSocios.add(new SocioDTO("Matias", "24", "Racing", "Casado", "Universitario"));
        listaSocios.add(new SocioDTO("Anibal", "25", "Racing", "Casado", "Terciario"));
        instance = new SociosDAO(listaSocios);
    }

    @Test
    public void testCantidadTotalPersonasRegistradas() {
        int expResult = 4;
        int result = instance.cantidadTotalPersonasRegistradas();
        assertEquals(expResult, result);
    }

    @Test
    public void testPromedioEdadSociosRacing() {
        int expResult = 24;
        int result = instance.promedioEdadSociosRacing();
        assertEquals(expResult, result);
    }

    @Test
    public void testListaCienSociosCasadosUniversitariosDeMenorAMayor() {
        List<SocioDTO> expResult = new ArrayList<>();
        expResult.add(new SocioDTO("Anibal", "22", "River", "Casado", "Universitario"));
        expResult.add(new SocioDTO("Matias", "24", "Racing", "Casado", "Universitario"));
        List<SocioDTO> result = instance.listaCienSociosCasadosUniversitariosDeMenorAMayor();
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testMapaCincoNombreMasComunesDeHinchasDeRiver() {
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("Anibal", 2);
        Map<String, Integer> result = instance.mapaCincoNombreMasComunesDeHinchasDeRiver();
        assertEquals(expResult, result);
    }

    @Test
    public void testMapaSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor() {
        Map<String, ArrayList<SocioDTO>> expResult = new HashMap<>();

        expResult.put("River", new ArrayList<>());
        expResult.computeIfAbsent("River", k -> new ArrayList<>()).add(new SocioDTO("Anibal", "22", "River", "Casado", "Universitario"));
        expResult.computeIfAbsent("River", k -> new ArrayList<>()).add(new SocioDTO("Anibal", "22", "River", "Casado", "Terciario"));

        expResult.put("Racing", new ArrayList<>());
        expResult.computeIfAbsent("Racing", k -> new ArrayList<>()).add(new SocioDTO("Matias", "24", "Racing", "Casado", "Universitario"));
        expResult.computeIfAbsent("Racing", k -> new ArrayList<>()).add(new SocioDTO("Anibal", "25", "Racing", "Casado", "Terciario"));

        Map<String, ArrayList<SocioDTO>> result = instance.mapaSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor();
        assertEquals(expResult.toString(), result.toString());
    }

}
