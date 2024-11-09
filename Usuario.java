public class Usuario {
    private String nombre;
    private String numero;
    private String puesto;

    public Usuario(String nombre, String numero, String puesto){
        this.nombre = nombre;
        this.numero = numero;
        this.puesto = puesto;
    }

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
