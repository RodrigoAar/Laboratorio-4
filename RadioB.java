import java.util.ArrayList;

/**
 * Clase para crear una nueva radio de tipo B
 */
public class RadioB extends Radio implements InterfazB{
    private ArrayList<Usuario> usuariosllamados; //lista de contactos a los que se ha llamado

    /**
     * constructor de la clase
     */
    public RadioB(){
        super();
    }

    /**
     * Implementación del método imprimir tarjeta
     */
    @Override
    public String imprimirtarjeta(Usuario usuario){
        String mensaje = "";
        mensaje = "Nombre: "  + usuario.getNombre() + "\n Número: " + usuario.getNumero() + "\n Puesto: " + usuario.getPuesto() + "\n";
        return mensaje;
    }

    /**
     * Implementación del método imprimir tarjetas
     */
    @Override
    public String imprimirtarjetas(ArrayList<Usuario> contactos){
        String mensaje = "<html>";
        for(Usuario i : contactos){
            mensaje += imprimirtarjeta(i) + ". <br>";
        }
        mensaje += "</html>";
        return mensaje;
    }

    /**
     * Modificación del método llamar de la clase padre para que se agregué al contacto a la lista de llamados
     */
    @Override
    public String llamar(Usuario usuario){
        usuariosllamados.add(usuario);
        return "Llamando a: " + usuario.getNombre() + "\n Número: " + usuario.getNumero();
    }

    /**
     * Implementación del método llamar ultimo
     */
    @Override
    public String llamarultimo(ArrayList<Usuario> contactos){
        int ult = usuariosllamados.size();
        return llamar(usuariosllamados.get(ult-1));
    }

    /**
     * Metodo getter para obtener la lista de usuarios llamados
     * @return contactos llamados
     */
    public  ArrayList<Usuario> getUsuariosllamados(){
        return usuariosllamados;
    }
}
