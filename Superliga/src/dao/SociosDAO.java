package dao;

import dto.SocioDTO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class SociosDAO {

    public static void imprimirCantidadTotalPersonasRegistradas(List<SocioDTO> listaSocios) {
        System.out.println("Cantidad total de personas registradas: " + listaSocios.size());
    }
    
    public static void imprimirPromedioEdadSociosRacing(List<SocioDTO> listaSocios){
        //List<Socio> sociosDeRacing = arregloSocios.stream().filter(p -> p.getEdad()== 18).collect(Collectors.toList()); // Filtra por edad
        
        List<SocioDTO> sociosDeRacing = listaSocios.stream().filter(p -> p.getEquipo().equals("Racing")).collect(Collectors.toList());
        System.out.println("Calculando promedio de edad...");
        int totalEdad = 0;
        for (SocioDTO s : sociosDeRacing) {
            totalEdad+=s.getEdad();
        }
        int promedioEdadSociosRacing = totalEdad / sociosDeRacing.size();
        System.out.println("Promedio de edad del los socios de Racing: "+ promedioEdadSociosRacing);
    }
}
