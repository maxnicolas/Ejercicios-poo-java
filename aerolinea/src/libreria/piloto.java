package libreria;

//asociacion bidireccional con vuelo
public class piloto {
    private String nombre;
    private String licencia;
    private String especialidad; //piloto comercial, piloto de carga, piloto de aerolínea, etc.
    private int horasVuelo;
    private avion avionAsignado; 
    //constructor
    public piloto(String nombre, String licencia, String especialidad, int horasVuelo) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.especialidad = especialidad;
        this.horasVuelo = horasVuelo;
        this.avionAsignado = null;
    }
    public String getNombre() {
        return nombre;
    }
    public String getLicencia() {
        return licencia;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public int getHorasVuelo() {
        return horasVuelo;
    }
    public avion getAvionAsignado() {
        return avionAsignado;
    }
    public void agregarHorasVuelo(int h) {
        this.horasVuelo += h;
    }
    public void asignarAvion(avion av) {
        this.avionAsignado = av;
        av.setPilotoAsignado(this);
    }
    public void liberarAvion() {
        if (avionAsignado != null) {
            avionAsignado.setPilotoAsignado(null);
            this.avionAsignado = null;
        }
    }
    @Override
    public String toString() {
        String infoAvion = (avionAsignado != null) ? avionAsignado.getModelo() : "SIN AVION ASIGNADO";
        StringBuilder sb = new StringBuilder("======= PILOTO =======\n");
        sb.append("Nombre: "+ nombre+"\n");
        sb.append("Licencia: "+ licencia+"\n");
        sb.append("Especialidad: "+ especialidad+"\n");
        sb.append("Horas de Vuelo: "+ horasVuelo+"\n");
        sb.append("Avión Asignado: "+ infoAvion+"\n");
        return sb.toString();
    }

}
