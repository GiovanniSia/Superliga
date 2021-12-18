package dto;

public class SocioDTO {
    private String nombre;
    private String edad;
    private String equipo;
    private String estadoCivil;
    private String nivelDeEstudios;

    public SocioDTO(String nombre, String edad, String equipo, String estadoCivil, String nivelDeEstudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.estadoCivil = estadoCivil;
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public String getNivelDeEstudios() {
        return nivelDeEstudios;
    }

    public void setNivelDeEstudios(String nivelDeEstudios) {
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return Integer.parseInt(edad);
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Socio{nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", equipo=").append(equipo);
        sb.append(", estadoCivil=").append(estadoCivil);
        sb.append(", nivelDeEstudios=").append(nivelDeEstudios);
        sb.append('}');
        return sb.toString();
    }
    
    public String toStringNombreEdadEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Socio{nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", equipo=").append(equipo);
        sb.append('}');
        return sb.toString();
    }
    
}
