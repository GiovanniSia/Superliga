package dao;

import dto.SocioDTO;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class Comparador implements Comparator<SocioDTO>{
        private int columna;

    public Comparador(int columna) {
        this.columna = columna;
    }
    
    public int compare(SocioDTO o1, SocioDTO o2) {
        switch(columna){
            case 1:
                return o1.getNombre().compareTo(o2.getNombre());
            case 2:{             
                if(o1.getEdad() == o2.getEdad()){
                    return 0;
                } else if (o1.getEdad() > o2.getEdad()){
                    return 1;
                } else{
                    return -1;
                }
            }
            case 3:
                return o1.getEquipo().compareTo(o2.getEquipo());
            case 4:
                return o1.getEstadoCivil().compareTo(o2.getEstadoCivil());
            case 5:
                return o1.getNivelDeEstudios().compareTo(o2.getNivelDeEstudios());  
            default:
                JOptionPane.showMessageDialog(null, "No es una opcion valida");
        }
        return 2;
    }
}

