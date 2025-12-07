/**
 * Clase que representa a un estudiante con su nombre, edad y calificación.
 * Proporciona métodos para acceder y modificar sus atributos, así como para
 * mostrar su información.
 */
public class Estudiante {
    /**
     * Nombre del estudiante.
     */
    private String nombre;
    /**
     * Edad del estudiante.
     */
    private int edad;
    /**
     * Calificación del estudiante.
     */
    private double calificacion;

    /**
     * Constructor para crear un nuevo objeto Estudiante.
     * 
     * @param nombre       El nombre del estudiante.
     * @param edad         La edad del estudiante.
     * @param calificacion La calificación del estudiante.
     */
    public Estudiante(String nombre, int edad, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el nombre del estudiante.
     * 
     * @return El nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     * 
     * @param nombre El nuevo nombre para el estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del estudiante.
     * 
     * @return La edad del estudiante.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del estudiante.
     * 
     * @param edad La nueva edad para el estudiante.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la calificación del estudiante.
     * 
     * @return La calificación del estudiante.
     */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación del estudiante.
     * 
     * @param calificacion La nueva calificación para el estudiante.
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Muestra la información del estudiante (nombre, edad y calificación)
     * en un formato de tabla en la consola.
     */
    public void mostrar() {
        System.out.printf("%-20s %5d %10.2f%n", nombre, edad, calificacion);
    }
}
