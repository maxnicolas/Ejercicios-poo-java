package libreria;
import java.util.List;
import java.util.ArrayList;

public class vueloUTP {
    private final List<avion> aviones = new ArrayList<>();
    private final List<piloto> pilotos = new ArrayList<>();
    private final List<vuelo> vuelos = new ArrayList<>();
    private final List<pasajero> pasajeros = new ArrayList<>();
    //get
    public List<avion> getAviones() {
        return aviones;
    }

    public List<piloto> getPilotos() {
        return pilotos;
    }

    public List<vuelo> getVuelos() {
        return vuelos;
    }

    public List<pasajero> getPasajeros() {
        return pasajeros;
    }
    
    //datos de prueba
    public vueloUTP() {

        avion av1 = new avion("OB-351","AIRBUS A320",180,"DISPONIBLE");
        avion av2= new avion("OB-492","BOEING 737",200,"DISPONIBLE");
        avion av3 = new avion("OB-210", "BOEING 787", 280, "DISPONIBLE");
        aviones.add(av1);
        aviones.add(av2);
        aviones.add(av3);

        piloto p1 = new piloto("Maxangel Duenas","LIC-1234","Piloto Comercial",1500);
        piloto p2 = new piloto("Fiorella Dominguez","LIC-5678","Piloto de Linea",2000);
        piloto p3 = new piloto("Carlos Mendoza","LIC-9012","Piloto Comercial",1200);
        pilotos.add(p1);
        pilotos.add(p2);
        pilotos.add(p3);
        p1.asignarAvion(av2);
        p2.asignarAvion(av1);
        tripulacion t1 = new tripulacion("TRIPU-001");
        t1.agregarPersonal("Maria Lopez - Azafata");
        t1.agregarPersonal("Juan Perez - Auxiliar de Vuelo");
        t1.agregarPersonal("Diego Hurtado - Jefe de Cabina");
        tripulacion t2 = new tripulacion("TRIPU-002");
        t2.agregarPersonal("Sofia Ramirez - Azafata");
        t2.agregarPersonal("Luis Fernandez - Auxiliar de Vuelo");
        t2.agregarPersonal("Ana Torres - Jefe de Cabina");
        vuelo v1=new vuelo("V001", "Arequipa","Lima","2026-07-15 09:00",t1,av1);
        vuelo v2=new vuelo("V002", "Lima","Cusco","2026-07-16 14:30",t2,av2);
        vuelos.add(v1);
        vuelos.add(v2);
        pasajero pj1=new pasajero("Anibal", "Sardon", "4589634", "Peruana", "Business", "12A");
        pasajero pj2=new pasajero("Maria", "Gutierrez", "7896541", "Peruana", "Economica", "14C");
        pasajero pj3=new pasajero("Luis", "Fernandez", "1234567", "Mexicana", "Economica", "16B");
        pasajeros.add(pj1);
        pasajeros.add(pj2);
        pasajeros.add(pj3);
        v1.agregarPasajero(pj1);
        v1.agregarPasajero(pj2);    
        v2.agregarPasajero(pj3);
    }
    //registrar vuelo
    public void registrarVuelo(vuelo v) {
        if (v != null) {
            vuelos.add(v);
            System.out.println("Vuelo registrado exitosamente!");
        }else {
            System.out.println("Error: Vuelo invalido.");
        }
    }
    //embarcar pasajeros
    public boolean embarcarPasajeros(String codVuelo, pasajero p) {
        vuelo vueloEncontrado=buscarVuelo(codVuelo);
        if (vueloEncontrado != null) {
            if (vueloEncontrado.agregarPasajero(p)) {
                System.out.println("Pasajero " + p.getNombre() + " embarcado en el vuelo " + codVuelo);
                return true;
            } else {
                System.out.println("No se pudo embarcar al pasajero " + p.getNombre());
                return false;
            }
        } else {
            System.out.println("Error: Vuelo con código " + codVuelo + " no encontrado.");
            return false;
        }
    }
    public boolean asociarPiloto(int idPiloto,int idAvion) {
        piloto pilotoEncontrado=buscarPiloto(idPiloto);
        avion avionEncontrado=buscarAvion(idAvion);
        if (pilotoEncontrado != null && avionEncontrado != null) {
            pilotoEncontrado.asignarAvion(avionEncontrado);
            System.out.println("Piloto " + pilotoEncontrado.getNombre() + " asignado al avión " + avionEncontrado.getModelo());
            return true;
        } else {
            System.out.println("Error: Piloto o Avión no encontrado.");
            return false;
        }
    }
    public boolean cambiarEstado(String codVuelo, String nuevoEstado) {
        vuelo vueloEncontrado=buscarVuelo(codVuelo);
        if (vueloEncontrado != null) {
            vueloEncontrado.cambiarEstado(nuevoEstado);
            System.out.println("Estado del vuelo " + codVuelo + " cambiado a " + nuevoEstado);
            return true;
        } else {
            System.out.println("Error: Vuelo con código " + codVuelo + " no encontrado.");
            return false;
        }
    }
    public vuelo buscarVuelo(String codVuelo) {
        for (vuelo v : vuelos) {
            if (v.getCodVuelo().equalsIgnoreCase(codVuelo)) {
                return v;
            }
        }
        return null;
    }
    public piloto buscarPiloto(int idPiloto) {
        for (piloto p : pilotos) {
            if (p.getLicencia().equalsIgnoreCase("LIC-"+idPiloto)) {
                return p;
            }
        }
        return null;
    }
    public avion buscarAvion(int idAvion) {
        for (avion a : aviones) {
            if (a.getMatricula().equalsIgnoreCase("OB-"+idAvion)) {
                return a;
            }
        }
        return null;
    }   

    

}
