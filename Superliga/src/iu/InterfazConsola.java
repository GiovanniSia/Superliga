package iu;

import dao.CSV;
import java.util.Scanner;
import modelo.Socios;

public class InterfazConsola {

    public static void iniciarMenu() {
        CSV csv = new CSV();
        csv.leerArchivo("C:..\\Superliga\\archivoCSV\\socios.csv");
        Socios socios = new Socios(csv.getListaSocios());
        
        boolean menu = true;
        do {
            System.out.println("--------------------------------------");
            System.out.println("1. Cantidad total de personas registradas.");
            System.out.println("2. El promedio de edad de los socios de Racing.");
            System.out.println("3. Un listado con las 100 primeras personas casadas, con estudios \n"
                    + "Universitarios, ordenadas de menor a mayor según su edad. Por \n"
                    + "cada persona, mostrar: nombre, edad y equipo.");
            System.out.println("4. Un listado con los 5 nombres más comunes entre los hinchas de River.");
            System.out.println("5. Un listado, ordenado de mayor a menor según la cantidad de \n"
                    + "socios, que enumere, junto con cada equipo, el promedio de edad \n"
                    + "de sus socios, la menor edad registrada y la mayor edad registrada.");
            System.out.println("6. Salir.");
            System.out.println("--------------------------------------");
            System.out.println("Elegir una de las 5 opciones:");

            Scanner consola = new Scanner(System.in);
            System.out.println("--------------------------------------");
            
            var seleccionado = 0;
            try {
                seleccionado = Integer.parseInt(consola.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido.");
                continue;
            }

            switch (seleccionado) {
                case 1 ->  {
                    System.out.println("La cantidad total de personas registradas.");
                    socios.imprimirCantidadTotalPersonasRegistradas();
                }
                case 2 ->  {
                    System.out.println("El promedio de edad de los socios de Racing.");
                    socios.imprimirPromedioEdadSociosRacing();
                }
                case 3 ->  {
                    System.out.println("Listado de los cien socios casados y universitarios ordenados de mayor a menor.");
                    socios.imprimirCienSociosCasadosUniversitariosDeMenorAMayor();
                }
                case 4 ->  {
                    System.out.println("Listado de los cinco nombre mas comunes entre los hinchas de river.");
                    socios.imprimirCincoNombreMasComunesDeHinchasDeRiver();
                }
                case 5 ->  {
                    System.out.println("Un listado, ordenado de mayor a menor según la cantidad de \n"
                            + "socios, que enumere, junto con cada equipo, el promedio de edad \n"
                            + "de sus socios, la menor edad registrada y la mayor edad registrada.");
                    socios.imprimirSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor();
                }
                case 6 ->  {
                    System.out.println("Saliste de sistema.");
                    menu = false;
                }
                default ->  {
                    System.out.println("Numero invalido.");
                }
            }
        } while (menu);
    }
}
