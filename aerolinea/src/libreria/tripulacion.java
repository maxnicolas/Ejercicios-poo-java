package libreria;
import java.util.List;
import  java.util.ArrayList;

public class tripulacion {
    private String idTripu;
    private List<String> personal;
    //constructor
    public tripulacion(String idTripu) {
        this.idTripu = idTripu;
        this.personal = new ArrayList<>();
    }
    //get
    public String getIdTripu() {
        return idTripu;
    }
    public List<String> getPersonal() {
        return personal;
    }
    public int getotalPersonal() {
        return personal.size();
    }
    //metodos
    public void agregarPersonal(String nombre) {
        personal.add(nombre);
    }
    public void eliminarPersonal(String nombre) {
        personal.remove(nombre);
    }

    public void mostrarPersonal() {
        System.out.println("Tripulación ID: " + idTripu + " | Total Personal: " + personal.size());
        System.out.println("Personal:");
        for (String miembro : personal) {
            System.out.println("-> " + miembro);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("======= TRIPULACION =======\n");
        sb.append("ID Tripulación: "+ idTripu+"\n");
        sb.append("Total Personal: "+ personal.size()+"\n");
        sb.append("Personal:\n");
        for (String miembro : personal) {
            sb.append("-> " + miembro + "\n");
        }
        return sb.toString();
    }
    

}
