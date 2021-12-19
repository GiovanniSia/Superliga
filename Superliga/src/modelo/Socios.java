package modelo;

import dao.SociosDAO;
import dto.SocioDTO;
import java.util.List;

public class Socios {

    private SociosDAO socios;

    public Socios(List<SocioDTO> listaSocios) {
        socios = new SociosDAO(listaSocios);
    }

    public void imprimirCantidadTotalPersonasRegistradas() {
        socios.imprimirCantidadTotalPersonasRegistradas();
    }

    public void imprimirPromedioEdadSociosRacing() {
        socios.imprimirPromedioEdadSociosRacing();
    }

    public void imprimirCienSociosCasadosUniversitariosDeMenorAMayor() {
        socios.imprimirCienSociosCasadosUniversitariosDeMenorAMayor();
    }

    public void imprimirCincoNombreMasComunesDeHinchasDeRiver() {
        socios.imprimirCincoNombreMasComunesDeHinchasDeRiver();
    }

    public void imprimirSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor() {
        socios.imprimirSociosPorEquipoEdadPromedioEdadMinEdadMaxDeMayorAMenor();
    }
}
