package aerolinea;
import libreria.*;
import java.util.Scanner;

public class aerolineaVuela {
    private static final vueloUTP servicio = new vueloUTP();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("=============================");
        System.out.println("BIENVENIDO A AEROLINEA VUELA");
        System.out.println("=============================");
        int opcion;
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar
            switch (opcion){
                case 1 -> opListarVuelos();
                case 2 -> opListarPilotos();
                case 3 -> opListarAviones();
                case 4 -> opAsociarPilotoAvion();
                case 5 -> opAgregarPasajeroVuelo();
                case 6 -> opMostrarInfoVuelo();
                case 7 -> opCambiarEstadoVuelo();
                case 0 -> {
                    System.out.println("Gracias por usar Aerolinea Vuela. ¡Buen viaje!");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }while(opcion !=0);
        sc.close();
    }
        private static void mostrarMenu() {
            System.out.println("\n==== MENU PRINCIPAL ===");
            System.out.println("1. Listar Vuelos");
            System.out.println("2. Listar Pilotos");
            System.out.println("3. Listar Aviones");
            System.out.println("4. Asociar Piloto a Avión");
            System.out.println("5. Embarcar Pasajero a Vuelo");
            System.out.println("6. Mostrar Información de Vuelo");
            System.out.println("7. Cambiar Estado de Vuelo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
        }
        private static void opListarVuelos() {
            System.out.println("\n==== LISTA DE VUELOS ====");
            for (vuelo v : servicio.getVuelos()) {
                System.out.println("- " + v.getCodVuelo() + " | " + v.getOrigen() + " -> " + v.getDestino());
            }
        }
        private static void opListarPilotos() {
            System.out.println("\n==== LISTA DE PILOTOS ====");
            for (piloto p : servicio.getPilotos()) {
                System.out.println("- " + p.getNombre() + " | " + p.getLicencia());
            }
        }
        private static void opListarAviones() {
            System.out.println("\n==== LISTA DE AVIONES ====");
            for (avion a : servicio.getAviones()) {
                System.out.println("- " + a.getMatricula() + " | " + a.getModelo());
            }

        }
        private static void opAsociarPilotoAvion() {
            System.out.print("Ingrese ID del Piloto: ");
            int idPiloto = sc.nextInt();
            System.out.print("Ingrese ID del Avión: ");
            int idAvion = sc.nextInt();
            servicio.asociarPiloto(idPiloto, idAvion);
        }
        private static void opAgregarPasajeroVuelo() {
            System.out.println("==== EMBARCAR PASAJERO ====");
            System.out.print("Ingrese Código del Vuelo: ");
            String codVuelo = sc.nextLine();
            System.out.print("Ingrese el pasaporte del pasajero: ");
            String pasaporte = sc.nextLine();
            System.out.print("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Ingrese la nacionalidad del Pasajero: ");
            String nacionalidad = sc.nextLine();
            System.out.print("Ingrese la clase del Pasajero (Economica, Ejecutiva, Primera): ");
            String clase = sc.nextLine();
            System.out.print("Ingrese el asiento del Pasajero (ejemplo: 12A, 5B): ");
            String asiento = sc.nextLine();
            pasajero p = new pasajero(nombre, apellido, pasaporte, nacionalidad, clase, asiento);
            boolean agregado = servicio.embarcarPasajeros(codVuelo, p);
            System.out.println(agregado ? "Pasajero agregado exitosamente." : "No se pudo agregar al pasajero. Vuelo lleno o no encontrado.");
        
        }
        private static void opMostrarInfoVuelo() {
            System.out.println("==== INFORMACIÓN DE VUELO ====");
            System.out.print("Ingrese Código del Vuelo: ");
            String codVuelo = sc.nextLine();
            vuelo v = servicio.buscarVuelo(codVuelo);
            if (v != null) {
                v.mostrarInfoVuelo();
            } else {
                System.out.println("Vuelo no encontrado.");
            }
        }
        private static void opCambiarEstadoVuelo() {
            System.out.println("==== CAMBIAR ESTADO DE VUELO ====");
            System.out.print("Ingrese Código del Vuelo: ");
            String codVuelo = sc.nextLine();
            System.out.print("Ingrese Nuevo Estado (DISPONIBLE, EN VUELO, CANCELADO): ");
            String nuevoEstado = sc.nextLine();
            servicio.cambiarEstado(codVuelo, nuevoEstado);
        }
    }

