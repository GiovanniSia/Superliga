package main;

import dao.CSV;
import dao.SociosDAO;

public class Main {
    public static void main(String[] args) {
        CSV csv = new CSV();
        csv.leerArchivo("C:..\\Superliga\\archivoCSV\\socios.csv");
        SociosDAO.imprimirCantidadTotalPersonasRegistradas(csv.getListaSocios());
        SociosDAO.imprimirPromedioEdadSociosRacing(csv.getListaSocios());
    }
}
