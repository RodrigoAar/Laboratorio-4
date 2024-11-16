/**
 * Clase para crear un nuevo usuario que funcionarán como contactos para llamar
 */
public class Usuario {
    private String nombre; //nombre del contacto 
    private String numero; //número del contacto 
    private String puesto; //puesto del contacto

    /**
     * Constructor de usuario/contacto
     * @param nombre
     * @param numero
     * @param puesto
     */
    public Usuario(String nombre, String numero, String puesto){
        this.nombre = nombre;
        this.numero = numero;
        this.puesto = puesto;
    }

    /**
     * Metodos getters para obtener el nombre, numero y puesto del usuario
     * @return nombre, numero y puesto
     */

    public String getNombre(){
        return nombre;
    }

    public String getNumero(){
        return numero;
    }

    public String getPuesto(){
        return puesto;
    }
}
