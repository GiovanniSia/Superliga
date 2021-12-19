package dao;

import dto.SocioDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SociosDAO {

    private final List<SocioDTO> listaSocios;

    public SociosDAO(List<SocioDTO> listaSocios) {
        this.listaSocios = listaSocios;
    }

    public void imprimirCantidadTotalPersonasRegistradas() {
        System.out.println("Cantidad total de personas registradas: " + cantidadTotalPersonasRegistradas());
    }
    
    public int cantidadTotalPersonasRegistradas(){
        return listaSocios.size();
    }

    public void imprimirPromedioEdadSociosRacing() {
        System.out.println("Promedio de edad: " + promedioEdadSociosRacing());
    }

    public int promedioEdadSociosRacing() {
        List<SocioDTO> sociosDeRacing = listaSocios.stream()
                .filter(p -> p.getEquipo().equals("Racing"))
                .collect(Collectors.toList());
        
        int promedioEdadSociosRacing = calcularPromedioEdad(sociosDeRacing);
        return promedioEdadSociosRacing;
    }

    public void imprimirCienSociosCasadosUniversitariosDeMenorAMayor() {
        List<SocioDTO> cienSociosUniversitariosCasados = listaCienSociosCasadosUniversitariosDeMenorAMayor();
        
        for (SocioDTO s : cienSociosUniversitariosCasados) {
            System.out.println(s.toStringNombreEdadEquipo());
        }
    }

    public List<SocioDTO> listaCienSociosCasadosUniversitariosDeMenorAMayor() {
        List<SocioDTO> cienSociosUniversitariosCasados = listaSocios.stream()
                .filter(p -> p.getNivelDeEstudios().equals("Universitario") && p.getEstadoCivil().equals("Casado"))
                .limit(100)
                .collect(Collectors.toList());
        final int edad = 2;
        SociosDAO.ordenarlistaSociosDeMenorAMayor(cienSociosUniversitariosCasados, edad);
        return cienSociosUniversitariosCasados;
    }

    public void imprimirCincoNombreMasComunesDeHinchasDeRiver() {
        Map<String, Integer> mapaCantidadCincoSociosPorNombreDeMayorAMenor = mapaCincoNombreMasComunesDeHinchasDeRiver();
        for (String m : mapaCantidadCincoSociosPorNombreDeMayorAMenor.keySet()) {
            System.out.println(m);
        }
    }

    public Map<String, Integer> mapaCincoNombreMasComunesDeHinchasDeRiver() {
        List<SocioDTO> sociosHinchasDeRiver = listaSocios.stream()
                .filter(p -> p.getEquipo().equals("River"))
                .collect(Collectors.toList());

        Map<String, Integer> mapaCantidadSociosPorNombre = new HashMap<>();
        for (SocioDTO s : sociosHinchasDeRiver) {
            if (!mapaCantidadSociosPorNombre.containsKey(s.getNombre())) {
                mapaCantidadSociosPorNombre.put(s.getNombre(), 1);
            } else {
                mapaCantidadSociosPorNombre.put(s.getNombre(), mapaCantidadSociosPorNombre.get(s.getNombre()).intValue() + 1);
            }
        }

        Map<String, Integer> mapaCantidadCincoSociosPorNombreDeMayorAMenor = mapaCantidadSociosPorNombre.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (viejo, nuevo) -> viejo, LinkedHashMap::new));

        return mapaCantidadCincoSociosPorNombreDeMayorAMenor;
    }

    public void imprimirSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor() {
        Map<String, ArrayList<SocioDTO>> map = mapaSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor();
        for (Map.Entry<String, ArrayList<SocioDTO>> m : map.entrySet()) {
            System.out.println("----------------");
            System.out.println("Equipo: " + m.getKey());
            System.out.println("Socios: " + m.getValue().size());

            int edadPromedio = calcularPromedioEdad(m.getValue());
            int mayorEdad = calcularMayorEdad(m.getValue());
            int menorEdad = calcularMenorEdad(m.getValue());
            
            System.out.println("Edad Promedio: " + edadPromedio);
            System.out.println("Mayor Edad: " + mayorEdad);
            System.out.println("Menor Edad: " + menorEdad);
        }
    }

    public Map<String, ArrayList<SocioDTO>> mapaSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor() {
        Map<String, ArrayList<SocioDTO>> mapaSociosPorEqupo = new HashMap<>();

        for (SocioDTO s : listaSocios) {
            if (!mapaSociosPorEqupo.containsKey(s.getEquipo())) {
                ArrayList<SocioDTO> array = new ArrayList<>();
                mapaSociosPorEqupo.put(s.getEquipo(), array);
                mapaSociosPorEqupo.computeIfAbsent(s.getEquipo(), k -> new ArrayList<>()).add(s);
            } else {
                mapaSociosPorEqupo.computeIfAbsent(s.getEquipo(), k -> new ArrayList<>()).add(s);
            }
        }
        Map<String, ArrayList<SocioDTO>> mapaSociosPorEquipoEdadPromedioDeMayorAMenor = mapaSociosPorEqupo.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue((o1, o2) -> Integer.compare(o1.size(), o2.size()))))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (viejo, nuevo) -> viejo, LinkedHashMap::new));

        return mapaSociosPorEquipoEdadPromedioDeMayorAMenor;
    }

    private static int calcularPromedioEdad(List<SocioDTO> listaSocios) {
        int totalEdad = 0;
        totalEdad = listaSocios.stream().map(s -> s.getEdad()).reduce(totalEdad, Integer::sum);
        int promedioEdad = totalEdad / listaSocios.size();
        return promedioEdad;
    }
    
        private static int calcularMayorEdad(List<SocioDTO> listaSocios) {
        int mayorEdad=0;
        for (SocioDTO s : listaSocios) {
            if (s.getEdad() > mayorEdad) {
                    mayorEdad = s.getEdad();
                }
        }
        return mayorEdad;
    }

    private static int calcularMenorEdad(List<SocioDTO> listaSocios) {
        int menorEdad= listaSocios.get(0).getEdad();
        for (SocioDTO s : listaSocios) {
            if (s.getEdad() < menorEdad) {
                    menorEdad = s.getEdad();
                }
        }
        return menorEdad;
    }

    private static void ordenarlistaSociosDeMenorAMayor(List<SocioDTO> listaSocios, int nroColumna) {
        Collections.sort(listaSocios, new Comparador(nroColumna));
    }
}
