import java.util.ArrayList;

/**
 * Interfaz a utilizar para la radio clase B
 */
public interface InterfazB{
    /**
     * Metodo para imprimir la tarjeta de un usuario
     * @param usuario
     * @return info del usuario
     */
    String imprimirtarjeta(Usuario usuario);
    /**
     * Metodo para imprimir varias tarjetas de una lista de contactos
     * @param usuarios lista de contactos
     * @return mensaje con las distintas tarjetas
     */
    String imprimirtarjetas(ArrayList<Usuario> usuarios);
    /**
     * Metodo para llamar al ultimo contacto que se llamó
     * @param usuariosllamados lista de los contactos llamados
     * @return mensaje indicando que se está llamando al ultimo contacto llamado
     */
    String llamarultimo(ArrayList<Usuario> usuariosllamados);
}
