package libreria;

//asociacion con piloto
public class avion {
    //atributos
    private String matricula;
    private String modelo;
    private int capacidad;
    private String estado; // disponible, en vuelo, mantenimiento

    private piloto pilotoAsignado; // referencia al piloto asignado
    //constructor
    public avion() {
    }
    public avion(String matricula, String modelo, int capacidad, String estado) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = "DISPONIBLE";
        this.pilotoAsignado = null;
    }
    //get-set

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public piloto getPilotoAsignado() {
        return pilotoAsignado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPilotoAsignado(piloto pilotoAsignado) {
        this.pilotoAsignado = pilotoAsignado;
    }
    
    @Override
    public String toString() {
        String infoPiloto = (pilotoAsignado != null) ? pilotoAsignado.getNombre() : "SIN PILOTO ASIGNADO";
        StringBuilder sb = new StringBuilder("======= AVION =======\n");
        sb.append("Matrícula: "+ matricula+"\n");
        sb.append("Modelo: "+ modelo+"\n");
        sb.append("Capacidad: "+ capacidad+"\n");
        sb.append("Estado: "+ estado+"\n");
        sb.append("Piloto Asignado: "+ infoPiloto+"\n");
        return sb.toString();
    }


}
