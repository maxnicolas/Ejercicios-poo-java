package libreria;

public class pasajero {
    //atributos
    private String nombre;
    private String apellido;
    private String pasaporte;
    private String nacionalidad;
    private String clase; //ejemplo de clase en aerolineaVuela "Economica", "Ejecutiva", "Primera-UTP"
    private String asiento; //ejemplo de asiento en aerolineaVuela "12A", "5B", etc.
     //constructor
    public pasajero(String nombre, String apellido, String pasaporte, String nacionalidad, String clase,
            String asiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
        this.clase = clase;
        this.asiento = asiento;
    }
    //getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getPasaporte() {
        return pasaporte;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public String getClase() {
        return clase;
    }
    public String getAsiento() {
        return asiento;
    }
    public String getnombreCompleto(){
        return nombre + " " + apellido;
    }
    //set
    public void setClase(String clase) {
        this.clase = clase;
    }
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("======= PASAJERO =======\n");
        sb.append("Nombre Completo: "+ getnombreCompleto()+"\n");
        sb.append("Pasaporte: "+ getPasaporte()+"\n");
        sb.append("Nacionalidad: "+ getNacionalidad()+"\n");
        sb.append("Clase: "+ getClase()+"\n");
        sb.append("Asiento: "+ getAsiento()+"\n");

        return sb.toString();
    }
}

