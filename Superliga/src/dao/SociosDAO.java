package dao;

import dto.SocioDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class SociosDAO {

    public static void imprimirCantidadTotalPersonasRegistradas(List<SocioDTO> listaSocios) {
        System.out.println("Cantidad total de personas registradas: " + listaSocios.size());
    }

    public static void imprimirPromedioEdadSociosRacing(List<SocioDTO> listaSocios) {
        List<SocioDTO> sociosDeRacing = listaSocios.stream().filter(p -> p.getEquipo().equals("Racing")).collect(Collectors.toList());
        int totalEdad = 0;
        for (SocioDTO s : sociosDeRacing) {
            totalEdad += s.getEdad();
        }
        int promedioEdadSociosRacing = totalEdad / sociosDeRacing.size();
        System.out.println("Promedio de edad del los socios de Racing: " + promedioEdadSociosRacing);
    }

    public static void imprimirCienSociosCasadosUniversitariosDeMenorAMayor(List<SocioDTO> listaSocios) {
        List<SocioDTO> sociosUniversitarios = listaSocios.stream().filter(p -> p.getNivelDeEstudios().equals("Universitario")).collect(Collectors.toList());
        List<SocioDTO> sociosUniversitariosCasados = sociosUniversitarios.stream().filter(p -> p.getEstadoCivil().equals("Casado")).collect(Collectors.toList());

        final int cantidadSocios = 100;
        List<SocioDTO> cienSociosUniversitarioCasados = new ArrayList();
        cienSociosUniversitarioCasados = SociosDAO.obtenerNuevaListaCantidadSociosHasta(sociosUniversitariosCasados, cantidadSocios);

        final int edad = 2;
        SociosDAO.ordenarSociosDeMenorAMayor(cienSociosUniversitarioCasados, edad);

        for (SocioDTO s : cienSociosUniversitarioCasados) {
            System.out.println(s.toStringNombreEdadEquipo());
        }
    }

    private static List<SocioDTO> obtenerNuevaListaCantidadSociosHasta(List<SocioDTO> listaSocios, int limiteSocios) {
        List<SocioDTO> listaNuevaSocios = new ArrayList();
        int contador = 0;
        for (SocioDTO s : listaSocios) {
            if (contador < limiteSocios) {
                listaNuevaSocios.add(s);
            }
            contador++;
        }
        return listaNuevaSocios;
    }

    private static void ordenarSociosDeMenorAMayor(List<SocioDTO> listaSocios, int nroColumna) {
        Collections.sort(listaSocios, new Comparador(nroColumna));

    }
}
