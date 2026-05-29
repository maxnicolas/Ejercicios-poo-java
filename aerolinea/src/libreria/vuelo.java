package libreria;
import java.util.List;
import java.util.ArrayList;

//agregacion con pasajero,tripulacion
//asociacion con avion y piloto 
public class vuelo {
    private String codVuelo;
    private String origen;
    private String destino;
    private String fechaHora;
    private String estado; // programado lo usamos por defecto, en vuelo, cancelado
    private List<pasajero> pasajeros;
    private tripulacion tripulacionAsignada;
    private avion avionAsignado;
    //constructor
    public vuelo(String codVuelo, String origen, String destino, String fechaHora, tripulacion tripulacionAsignada,
            avion avionAsignado) {
        this.codVuelo = codVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.tripulacionAsignada = tripulacionAsignada;
        this.avionAsignado = avionAsignado;
        this.pasajeros = new ArrayList<>();
        this.estado = "PROGRAMADO";
    }
    //get
    public String getCodVuelo() {
        return codVuelo;
    }
    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
    public String getFechaHora() {
        return fechaHora;
    }
    public String getEstado() {
        return estado;
    }
    public List<pasajero> getPasajeros() {
        return pasajeros;
    }
    public tripulacion getTripulacionAsignada() {
        return tripulacionAsignada;
    }
    public avion getAvionAsignado() {
        return avionAsignado;
    }
    public int getTotalPasajeros() {
        return pasajeros.size();
    }
    //metodos
    public boolean agregarPasajero(pasajero p) {
        if (pasajeros.size() >= avionAsignado.getCapacidad()) 
            return false; 
            pasajeros.add(p);
            return true;
    }
    public boolean eliminarPasajero(String pasaporte) {
        return pasajeros.removeIf(p -> p.getPasaporte().equals(pasaporte));
    }
    //estado de vuelo 
    public void cambiarEstado(String nEstado) {
        this.estado = nEstado;
        if(nEstado.equals("EN VUELO")) {
            avionAsignado.setEstado("EN VUELO");
        } else if (nEstado.equals("CANCELADO")) {
            avionAsignado.setEstado("DISPONIBLE");
        }
    }
    //mostrar info vuelo
    public void mostrarInfoVuelo() {
        System.out.println("======= VUELO =======");
        System.out.println("Código de Vuelo: " + codVuelo);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Fecha y Hora: " + fechaHora);
        System.out.println("Estado: " + estado);
        System.out.println("Avión Asignado: " + avionAsignado.getModelo());
        System.out.println("Tripulación Asignada: " + tripulacionAsignada.getIdTripu());
        System.out.println("Total Pasajeros: " + pasajeros.size());
        if (pasajeros.size() > 0) {
            System.out.println("Pasajeros:");
            for (pasajero p : pasajeros) {
                System.out.println("-> " + p.getnombreCompleto() + " | Pasaporte: " + p.getPasaporte());
            }
        } else {
            System.out.println("No hay pasajeros asignados a este vuelo.");
        }
        System.out.println("===============================");
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("======= VUELO =======\n");
        sb.append("Código de Vuelo: "+ codVuelo+"\n");
        sb.append("Origen: "+ origen+"\n");
        sb.append("Destino: "+ destino+"\n");
        sb.append("Fecha y Hora: "+ fechaHora+"\n");
        sb.append("Estado: "+ estado+"\n");
        sb.append("Pasajeros: "+ pasajeros.size()+"\n");
        sb.append("Capacidad Avión: "+ avionAsignado.getCapacidad()+"\n");
        return sb.toString();
    }
    


}
