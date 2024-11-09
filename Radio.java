import java.util.ArrayList;

public class Radio {
    protected boolean frecuencia;
    protected boolean estado;
    protected boolean estadollamada;
    protected double emisora;
    protected ArrayList<Usuario> contactos;
    protected double[][] emisoras;
    protected ArrayList<ArrayList<String>> playlists;

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
        this.emisora = 90.00;
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
    public void guardaremisora(int fila, int columna){
        emisoras[fila][columna] = emisora;
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
        Usuario usuario = contactos.get(pos-1);
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

}
