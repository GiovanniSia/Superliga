package dao;

import dto.SocioDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    private BufferedReader lector; // lee el archivo
    private String linea; // recibe la linea de cada fila
    private String partes[] = null; //almacena cada linea leida
    private List<SocioDTO> listaSocios = new ArrayList(); // arreglo dinamico de la clase socio

    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(";");
                listaSocios.add(new SocioDTO(partes[0], partes[1], partes[2], partes[3], partes[4]));
            }
            lector.close();
            linea = null;
            partes = null;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<SocioDTO> getListaSocios() {
        return listaSocios;
    }

}
