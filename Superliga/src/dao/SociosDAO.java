package dao;

import dto.SocioDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SociosDAO {

    public static void imprimirCantidadTotalPersonasRegistradas(List<SocioDTO> listaSocios) {
        System.out.println("Cantidad total de personas registradas: " + listaSocios.size());
    }

    public static int imprimirPromedioEdadSociosRacing(List<SocioDTO> listaSocios) {
        List<SocioDTO> sociosDeRacing = listaSocios.stream().filter(p -> p.getEquipo().equals("Racing")).collect(Collectors.toList());
        int totalEdad = 0;
        for (SocioDTO s : sociosDeRacing) {
            totalEdad += s.getEdad();
        }
        int promedioEdadSociosRacing = totalEdad / sociosDeRacing.size();
        System.out.println("Promedio de edad del los socios de Racing: " + promedioEdadSociosRacing);
        
        return promedioEdadSociosRacing;
    }

    public static List<SocioDTO> imprimirCienSociosCasadosUniversitariosDeMenorAMayor(List<SocioDTO> listaSocios) {
        List<SocioDTO> cienSociosUniversitariosCasados = listaSocios.stream().filter(p -> p.getNivelDeEstudios().equals("Universitario") && p.getEstadoCivil().equals("Casado")).limit(100).collect(Collectors.toList());

        final int edad = 2;
        SociosDAO.ordenarSociosDeMenorAMayor(cienSociosUniversitariosCasados, edad);

        for (SocioDTO s : cienSociosUniversitariosCasados) {
            System.out.println(s.toStringNombreEdadEquipo());
        }
        return cienSociosUniversitariosCasados;
    }

    public static Map<String, Integer> imprimirCincoNombreMasComunesDeHinchasDeRiver(List<SocioDTO> listaSocios) {
        List<SocioDTO> sociosHinchasDeRiver = listaSocios.stream().filter(p -> p.getEquipo().equals("River")).collect(Collectors.toList());

        Map<String, Integer> mapaCantidadSociosPorNombre = new HashMap<String, Integer>();
        for (SocioDTO s : sociosHinchasDeRiver) {
            if (!mapaCantidadSociosPorNombre.containsKey(s.getNombre())) {
                mapaCantidadSociosPorNombre.put(s.getNombre(), 1);
            } else {
                mapaCantidadSociosPorNombre.replace(s.getNombre(), mapaCantidadSociosPorNombre.get(s.getNombre()).intValue() + 1);
            }
        }

        Map<String, Integer> mapaCantidadCincoSociosPorNombreDeMayorAMenor = mapaCantidadSociosPorNombre.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (viejo, nuevo) -> viejo, LinkedHashMap::new));

        for (String m : mapaCantidadCincoSociosPorNombreDeMayorAMenor.keySet()) {
            System.out.println(m);
        }
        return mapaCantidadCincoSociosPorNombreDeMayorAMenor;
    }

    private static void ordenarSociosDeMenorAMayor(List<SocioDTO> listaSocios, int nroColumna) {
        Collections.sort(listaSocios, new Comparador(nroColumna));

    }
}
