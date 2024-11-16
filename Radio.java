import java.util.ArrayList;

/**
 * Clase utilizada para crear una nueva radio
 */
public class Radio {
    protected boolean frecuencia; //determinar si está en AM o FM
    protected boolean estado; //determinar si se encuentra apagado o encendido
    protected boolean estadollamada; //determinar si está en llamada o no
    protected boolean modo; //determinar si está en modo radio o en modo telefono
    protected boolean reproduccion; //determinar si está reproduciendo alguna cancion
    protected double emisora; //determinar en que emisora se encuentra
    protected int volumen; //determinar el volumen 
    protected ArrayList<Usuario> contactos; //lista de contactos predeterminada 
    protected double[][] emisoras; //arreglo bidimensional para poder guardar 5 emisoras en 10 canales
    protected ArrayList<ArrayList<String>> playlists; //lista de playlists predeterminada

    /**
     * Metodo para crear una lista de playlists génericas de distinitos tipos de música 
     * @return lista de playlists
     */
    public ArrayList<ArrayList<String>> playlistgenerica(){
        ArrayList<ArrayList<String>> listaDeGeneros = new ArrayList<>();

        // Crear la lista de canciones clásicas de rock
        ArrayList<String> cancionesClasicasRock = new ArrayList<>();
        cancionesClasicasRock.add("Stairway to Heaven - Led Zeppelin");
        cancionesClasicasRock.add("Little wing - Jimi Hendrix");
        cancionesClasicasRock.add("Hotel California - Eagles");
        cancionesClasicasRock.add("Wish you were here - Pink Floyd");
        cancionesClasicasRock.add("Smoke on the Water - Deep Purple");

        // Crear la lista de canciones de rock en español
        ArrayList<String> cancionesRockEspanol = new ArrayList<>();
        cancionesRockEspanol.add("Matador - Los Fabulosos Cadillacs");
        cancionesRockEspanol.add("La Celula Que Explota - Caifanes");
        cancionesRockEspanol.add("Lamento Boliviano - Enanitos Verdes");
        cancionesRockEspanol.add("Persiana Americana - Soda Stereo");
        cancionesRockEspanol.add("Cuando Pase el Temblor - Soda Stereo");
        cancionesRockEspanol.add("Luna roja - Soda Stereo");
        cancionesRockEspanol.add("Zoom - Soda Stereo");

        // Crear la lista de música clásica
        ArrayList<String> musicaClasica = new ArrayList<>();
        musicaClasica.add("Symphony No. 5 - Beethoven");
        musicaClasica.add("Eine kleine Nachtmusik - Mozart");
        musicaClasica.add("Canon in D - Pachelbel");
        musicaClasica.add("Clair de Lune - Debussy");
        musicaClasica.add("The Four Seasons - Vivaldi");
        musicaClasica.add("Nocturne Op. 9 No. 2 - Chopin");
        musicaClasica.add("Ballade No. 1 - Chopin");
        musicaClasica.add("Swan Lake - Tchaikovsky");
        musicaClasica.add("1812 Overture - Tchaikovsky");

        // Añadir las listas de canciones al ArrayList principal
        listaDeGeneros.add(cancionesClasicasRock);
        listaDeGeneros.add(cancionesRockEspanol);
        listaDeGeneros.add(musicaClasica);

        return listaDeGeneros;
    }

    /**
     * Método para crear una lista de contactos génerica
     * @return contactos
     */
    public ArrayList<Usuario> contactosgenerica(){
        ArrayList<Usuario> listacontactos = new ArrayList<>();
        Usuario usuario1 =  new Usuario("Juan", "12345614", "Conductor");
        Usuario usuario2 =  new Usuario("Lucas", "12345613", "Medico");
        Usuario usuario3 =  new Usuario("Mateo", "12345612", "Abogado");
        Usuario usuario4 =  new Usuario("Marcos", "12345611", "Pescador");
        Usuario usuario5 =  new Usuario("Pedro", "12345610", "Futbolista");
        Usuario usuario6 =  new Usuario("Santiago", "12345679", "Profesor");

        listacontactos.add(usuario1);
        listacontactos.add(usuario2);
        listacontactos.add(usuario3);
        listacontactos.add(usuario4);
        listacontactos.add(usuario5);
        listacontactos.add(usuario6);

        return listacontactos;
    }

    /**
     * Método constructor de la clase 
     */
    public Radio(){
        this.frecuencia = true;
        this.estado = false;
        this.estadollamada = false;
        this.modo = true;
        this.reproduccion = false;
        this.emisora = 90.00;
        this.volumen = 12;
        this.emisoras = new double[5][10];
        this.playlists = playlistgenerica();
        this.contactos = contactosgenerica();
    }

    /**
     * Método para encender o apagar el radio
     */
    public void onoff(){
        if(estado==false){
            this.estado = true;
        }else{
            this.estado = false;
        }
    }

    /**
     * Método para guardar una emisora
     * @param fila
     * @param columna
     */
    public void guardaremisora(int fila, int columna, double emisora1){
        emisoras[fila][columna] = emisora1;
    }

    /**
     * Método para colocar a la emisora en una de las guardadas anteriormente
     * @param fila
     * @param columna
     */
    public void cargaremisora(int fila, int columna){
        this.emisora = emisoras[fila][columna];
    }

    /**
     * Método para obtener al usuario en cierta posición en la lista de contactos
     * @param pos
     * @return
     */
    public Usuario obtenerusuario(int pos){
        Usuario usuario = contactos.get(pos);
        return usuario;
    }

    /**
     * Método para llamar a uno de los contactos en la lista
     * @param usuario
     * @return
     */
    public String llamar(Usuario usuario){
        return "Llamando a: " + usuario.getNombre() + "\n Número: " + usuario.getNumero();
    }

    /**
     * Método para finalizar una llamada
     */
    public void finalizarllamada(){
        if(estadollamada == true){
            this.estadollamada = false;
        }
    }

    /**
     * Metodo getter de estado
     * @return estado
     */
    public boolean getEstado(){
        return estado;
    }

    /**
     * Metodo getter de emisora
     * @return emisora en formato string para agregarlo a un JLabel
     */
    public String getEmisora(){
        String mensaje = "" + emisora;
        return mensaje;
    }

    /**
     * Metodo getter de volumen
     * @return volumen en String para poder agregarlo a un Jlabel
     */
    public String getVolumen(){
        return "" + volumen;
    }

    /**
     * Metodo getter de modo
     * @return modo
     */
    public boolean getModo(){
        return modo;
    }

    /**
     * Metodo getter de frecuencia
     * @return frecuencia
     */
    public boolean getFrecuencia(){
        return frecuencia;
    }

    /**
     * metodo getter del estado de reproducción 
     * @return reproduccion
     */
    public boolean getReproduccion(){
        return reproduccion;
    }

    /**
     * metodo getter para las playlists predeterminadas
     * @return lista de playlists
     */
    public ArrayList<ArrayList<String>> getPlaylists(){
        return playlists;
    }

    /**
     * Metodo setter para modo
     */
    public void setModo(){
        if(modo == true){
            this.modo = false;
        }else{
            this.modo = true;
        }
    }

    /**
     * Metodo setter para estado de llamada
     */
    public void setEstadollamada(){
        if(estadollamada == true){
            this.estadollamada = false;
        }else{
            this.estadollamada = true;
        }
    }

    /**
     * metodo setter para frecuencia, en este caso cambiar de fm a am y visceversa
     */
    public void setFrecuencia(){
        if(frecuencia == true){
            this.frecuencia = false;
            this.emisora = 70.00;
        }else{
            this.frecuencia = true;
            this.emisora = 90.00;
        }
    }

    /**
     * metodo setter para volumen, subir o bajar  volumen
     * @param i determinante para subir o bajar
     */
    public void volumen(int i){
        if(i==1){
            this.volumen = volumen + 1;
        } else if( i != 1 && volumen >0){
            this.volumen = volumen - 1;
        }
    }

    /**
     * metodo setter para emisora, cambiar la emisora
     * @param i determinante para subir o bajar
     */
    public void emisora(int i){
        if(frecuencia == true){
            if( i == 1){
                this.emisora = emisora + 0.5;
            }else if( i!= 1 && 88<=emisora){
                this.emisora = emisora - 0.5;
            }
        }else{
            if(i== 1 && emisora<=87){
                this.emisora = emisora + 0.5;
            }else{
                this.emisora = emisora - 0.5;
            }
        }
    }

    /**
     * Metodo getter para obtener la lista de contactos predeterminada
     * @return contactos
     */
    public ArrayList<Usuario> getContactos(){
        return contactos;
    }

    /**
     * Metodo para cambiar cancion
     * @param nombre cancion que se está reproduciendo
     * @param lista indice de la playlist a la que pertenece
     * @param i parametro para seleccionar la siguiente o la anterior canción 
     * @return nueva canción 
     */
    public String cambiarcancion(String nombre, int lista, int i){
        String mensaje = "";
        int index = playlists.get(lista).indexOf(nombre);
        int cond = playlists.get(lista).size();
        if(i==1 && index <cond){
            mensaje = playlists.get(lista).get(index+1);
        }else if(i!=1 && 0<index){
            mensaje = playlists.get(lista).get(index-1);
        }
        return mensaje;
    }

    /**
     * Metodo setter para cambiar el estado de reproducción
     */
    public void setReproduccion(){
        if(reproduccion == false){
            this.reproduccion = true;
        }else{
            this.reproduccion = false;
        }
    }

    /**
     * Metodo getter para obtener los contacots en formato String
     * @return lista de contactos en formato String
     */
    public ArrayList<String> getContactosString(){
        ArrayList<String> cont = new ArrayList<>();
        for(Usuario i: contactos){
            cont.add(i.getNombre() + i.getNumero());
        }
        return cont;
    }

}
