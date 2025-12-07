import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que gestiona un menú interactivo para administrar una lista
 * de estudiantes.
 * Permite agregar, mostrar, calcular el promedio de calificaciones y buscar
 * estudiantes.
 */
public class Main {
    /**
     * Lista para almacenar todos los objetos de tipo Estudiante.
     */
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    /**
     * Objeto Scanner para leer la entrada del usuario desde la consola.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que ejecuta el programa.
     * Muestra un menú de opciones y procesa la selección del usuario en un bucle
     * hasta que se elige la opción de salir.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            // Estructura de control para ejecutar la acción correspondiente a la opción
            // seleccionada.
            switch (opcion) {
                case 1 -> ingresarEstudiante();
                case 2 -> mostrarEstudiantes();
                case 3 -> calcularPromedioGeneral();
                case 4 -> buscarEstudiantePorNombre();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    /**
     * Muestra el menú principal de opciones en la consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ ESTUDIANTES =====");
        System.out.println("1. Ingresar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Cálculo general (promedio de calificaciones)");
        System.out.println("4. Consulta por nombre");
        System.out.println("5. Salir");
        System.out.println("============================");
    }

    /**
     * Lee de forma segura un número entero desde la consola.
     * Vuelve a solicitar la entrada si el valor no es un entero válido.
     * 
     * @param mensaje El mensaje que se muestra al usuario para solicitar la
     *                entrada.
     * @return El número entero leído.
     */
    private static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    /**
     * Lee de forma segura un número decimal (double) desde la consola.
     * Vuelve a solicitar la entrada si el valor no es un número decimal válido.
     * 
     * @param mensaje El mensaje que se muestra al usuario para solicitar la
     *                entrada.
     * @return El número double leído.
     */
    private static double leerDouble(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        }
    }

    /**
     * Gestiona la opción 1 del menú: Ingresar un nuevo estudiante.
     * Pide al usuario el nombre, la edad y la calificación, crea un objeto
     * Estudiante y lo añade a la lista.
     */
    private static void ingresarEstudiante() {
        System.out.println("\n--- Registro de estudiante ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int edad = leerEntero("Edad: ");
        double calificacion = leerDouble("Calificación: ");

        Estudiante est = new Estudiante(nombre, edad, calificacion);
        estudiantes.add(est);
        System.out.println("Estudiante registrado correctamente.");
    }

    /**
     * Gestiona la opción 2 del menú: Mostrar todos los estudiantes registrados.
     * Imprime una tabla formateada con la información de cada estudiante.
     */
    private static void mostrarEstudiantes() {
        System.out.println("\n--- Lista de estudiantes ---");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Encabezados de la tabla
        System.out.printf("%-20s %5s %10s%n", "Nombre", "Edad", "Calificación");
        System.out.printf("%-20s %5s %10s%n", "------", "----", "-----------");

        for (Estudiante e : estudiantes) {
            e.mostrar();
        }
    }

    /**
     * Gestiona la opción 3 del menú: Calcular el promedio general de las
     * calificaciones.
     * Suma las calificaciones de todos los estudiantes y calcula el promedio.
     */
    private static void calcularPromedioGeneral() {
        System.out.println("\n--- Promedio general de calificaciones ---");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double suma = 0.0;
        for (Estudiante e : estudiantes) {
            suma += e.getCalificacion();
        }
        double promedio = suma / estudiantes.size();
        System.out.printf("Promedio general de calificaciones: %,.2f%n", promedio);
    }

    /**
     * Gestiona la opción 4 del menú: Buscar estudiantes por nombre.
     * Pide al usuario un término de búsqueda y muestra todos los estudiantes
     * cuyo nombre contenga dicho término (sin distinguir mayúsculas y minúsculas).
     */
    private static void buscarEstudiantePorNombre() {
        System.out.println("\n--- Búsqueda de estudiante por nombre ---");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscado = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Estudiante e : estudiantes) {
            if (e.getNombre().toLowerCase().contains(nombreBuscado)) {
                // Imprime los encabezados solo la primera vez que se encuentra una
                // coincidencia.
                if (!encontrado) {
                    System.out.printf("%-20s %5s %10s%n", "Nombre", "Edad", "Calificación");
                    System.out.printf("%-20s %5s %10s%n", "------", "----", "-----------");
                }
                e.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron estudiantes con ese nombre.");
        }
    }
}
