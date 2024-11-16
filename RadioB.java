import java.util.ArrayList;

public class RadioB extends Radio implements InterfazB{
    private ArrayList<Usuario> usuariosllamados;

    public RadioB(){
        super();
    }

    @Override
    public String imprimirtarjeta(Usuario usuario){
        String mensaje = "";
        mensaje = "Nombre: "  + usuario.getNombre() + "\n Número: " + usuario.getNumero() + "\n Puesto: " + usuario.getPuesto();
        return mensaje;
    }

    @Override
    public String imprimirtarjetas(ArrayList<Usuario> contactos){
        String mensaje = "";
        for(Usuario i : contactos){
            mensaje += imprimirtarjeta(i);
        }
        return mensaje;
    }

    @Override
    public String llamar(Usuario usuario){
        usuariosllamados.add(usuario);
        return "Llamando a: " + usuario.getNombre() + "\n Número: " + usuario.getNumero();
    }

    @Override
    public String llamarultimo(ArrayList<Usuario> contactos){
        int ult = usuariosllamados.size();
        return llamar(usuariosllamados.get(ult-1));
    }
}
