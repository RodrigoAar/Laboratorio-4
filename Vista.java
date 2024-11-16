import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.Timer; 
import java.util.TimerTask;

public class Vista extends JFrame{
    JFrame principal, contactos, llamada;
    JLabel info, frec;
    RadioB radio;
    int fila,columna;
    public Vista(){
        principal= new JFrame("Radio");
        principal.setVisible(true);
        principal.setSize(500,300);
        contactos = new JFrame();
        llamada = new JFrame();
        info = new JLabel();
        radio = new RadioB();

        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton boton1 = new JButton("ON/OFF"); 
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        boton1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            radio.onoff();
            if(radio.getEstado() == false){
                info.setText("Apagado");
                frec.setText("");
            }else{
                info.setText(radio.getEmisora());
                frec.setText("FM");
            }
           } 
        });
        panel1.add(boton1, gbc);
        JButton boton2 = new JButton("1"); 
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 0;
             if(radio.getModo() == false){
                info.setText(radio.getPlaylists().get(columna).get(0));
             }
            } 
         });
        panel1.add(boton2, gbc); 
        JButton boton3 = new JButton("2"); 
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 1;
             if(radio.getModo() == false){
                info.setText(radio.getPlaylists().get(columna).get(0));
             }
            } 
         });
        panel1.add(boton3, gbc); 
        JButton boton4 = new JButton("3"); 
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 2;
             if(radio.getModo() == false){
                info.setText(radio.getPlaylists().get(columna).get(0));
             }
            } 
         });
        panel1.add(boton4, gbc);
        JButton boton5 = new JButton("4"); 
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        boton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 3;
            } 
         });
        panel1.add(boton5, gbc);
        JButton boton6 = new JButton("5"); 
        gbc.gridx = 0; 
        gbc.gridy = 5;
        boton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 5;
            } 
         });
        panel1.add(boton6, gbc);
        

        principal.add(panel1, BorderLayout.WEST);

        JPanel panel2 = new JPanel(new GridBagLayout());
        JButton botonA = new JButton("1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        botonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             fila = 0;
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.cargaremisora(fila, columna);
                info.setText(radio.getEmisora());
                if(Double.parseDouble(radio.getEmisora()) < 87.5){
                    frec.setText("AM");
                }else{
                    frec.setText("FM");
                }
             }
            } 
         });
        panel2.add(botonA);

        JButton botonB = new JButton("2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        botonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             fila = 1;
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.cargaremisora(fila, columna);
                info.setText(radio.getEmisora());
             }
            } 
         });
        panel2.add(botonB, gbc);

        JButton botonC = new JButton("3");
        gbc.gridx = 2;
        gbc.gridy = 0;
        botonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             fila = 2;
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.cargaremisora(fila, columna);
                info.setText(radio.getEmisora());
             }
            } 
         });
        panel2.add(botonC, gbc);

        JButton botonD = new JButton("4");
        gbc.gridx = 3;
        gbc.gridy = 0;
        botonD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             fila = 3;
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.cargaremisora(fila, columna);
                info.setText(radio.getEmisora());
             }
            } 
         });
        panel2.add(botonD, gbc);

        JButton botonE = new JButton("5");
        gbc.gridx = 4;
        gbc.gridy = 0;
        botonE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             fila = 4;
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.cargaremisora(fila, columna);
                info.setText(radio.getEmisora());
             }
            } 
         });
        panel2.add(botonE, gbc);

        JButton mas = new JButton("+");
        gbc.gridx = 1;
        gbc.gridy = 1;
        mas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true){
                 radio.volumen(1);
                 JFrame vol = new JFrame();
                 vol.setSize(50,50);
                 JLabel infovol = new JLabel("Volumen: " + radio.getVolumen());
                 vol.setVisible(true);
                 vol.add(infovol);
                 Timer timer = new Timer(); 
                timer.schedule(new TimerTask() { @Override 
                public void run() { vol.dispose(); } }, 5000);
             }
            } 
         });
        panel2.add(mas, gbc);

        JButton AMFM = new JButton("AM/FM");
        AMFM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(radio.getEstado() == true && radio.getModo() == true){
                    radio.setFrecuencia();
                    if(radio.getFrecuencia() == true){
                        info.setText(radio.getEmisora());
                        frec.setText("FM");
                    }else{
                        info.setText(radio.getEmisora());
                        frec.setText("AM");
                    }
                }                
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel2.add(AMFM, gbc);

        JButton menos = new JButton("-");
        gbc.gridx = 3;
        gbc.gridy = 1;
        menos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true){
                 radio.volumen(0);
                 JFrame vol = new JFrame();
                 vol.setSize(50,50);
                 JLabel infovol = new JLabel("Volumen: " + radio.getVolumen());
                 vol.setVisible(true);
                 vol.add(infovol);
                 Timer timer = new Timer(); 
                timer.schedule(new TimerTask() { @Override 
                public void run() { vol.dispose(); } }, 5000);
             }
            } 
         });
        panel2.add(menos, gbc);

        JButton anterior = new JButton("<-");
        gbc.gridx = 0;
        gbc.gridy = 2;
        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.emisora(0);
                info.setText(radio.getEmisora());
             } else if(radio.getEstado() == true && radio.getModo() == false){
                String nueva = radio.cambiarcancion(info.getText(), columna, 0);
                info.setText(nueva);
             }
            } 
         });
        panel2.add(anterior, gbc);

        JButton pausar = new JButton("► ||");
        gbc.gridx = 2;
        gbc.gridy = 2;
        pausar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == false){
                 JFrame vol = new JFrame();
                 vol.setSize(200,50);
                 JLabel infovol = new JLabel("");
                 if(radio.getReproduccion() == true){
                    radio.setReproduccion();
                    infovol.setText("Se ha pausado la música");
                 }else{
                    radio.setReproduccion();
                    infovol.setText("Se ha reanundado la música");
                 }
                 vol.setVisible(true);
                 vol.add(infovol);
                 Timer timer = new Timer(); 
                timer.schedule(new TimerTask() { @Override 
                public void run() { vol.dispose(); } }, 5000);
             }
            } 
         });
        panel2.add(pausar, gbc);

        JButton saltar = new JButton("->");
        gbc.gridx = 4;
        gbc.gridy = 2;
        saltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == true){
                radio.emisora(1);
                info.setText(radio.getEmisora());
             }else if(radio.getEstado() == true && radio.getModo() == false){
                String nueva = radio.cambiarcancion(info.getText(), columna, 1);
                info.setText(nueva);
             }
            } 
         });
        panel2.add(saltar, gbc);

        JButton contactos = new JButton("Contactos");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2 ;
        contactos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == false){
                JFrame tarjetas = new JFrame("Contactos");
                tarjetas.setSize(400,200);
                tarjetas.setVisible(true);
                JLabel cont = new JLabel(radio.imprimirtarjetas(radio.getContactos()));
                tarjetas.add(cont);
             }
            } 
         });
        panel2.add(contactos, gbc);

        JButton modo = new JButton("Modo");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 2 ;
        modo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true){
                radio.setModo();
             if(radio.getModo() == true){
                info.setText(radio.getEmisora());
                if(radio.frecuencia == true){
                    frec.setText("FM");
                }else{
                    frec.setText("AM");
                }
             }else{
                info.setText("Elija una de las 3 playlists: boton 1 (Rock), 2 (Rock en español) o 3 (música clásica)");
                frec.setText("");
                radio.setReproduccion();
             }
             }
            } 
         });
        panel2.add(modo, gbc);

        JButton llamar = new JButton("📞");
        gbc.gridx = 0;
        gbc.gridy = 4;
        llamar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == false){
                radio.setEstadollamada();
                llamada = new JFrame();
                llamada.setSize(150,600);
                llamada.setVisible(true);
                JPanel botones = new JPanel(new GridLayout(radio.getContactosString().size(), 1));
                for(int i=0; i<radio.getContactosString().size(); i++){
                    JButton boton = new JButton(radio.getContactosString().get(i));
                    int k = i;
                    boton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                         
                            JFrame llamando = new JFrame();
                            llamando.setSize(100,100);
                            llamando.setVisible(true);
                            JLabel etiqueta = new JLabel(radio.llamar(radio.obtenerusuario(k)));
                            llamando.add(etiqueta);
                        } 
                     });
                     botones.add(boton);
                }
                llamada.add(botones);
                
             }
            } 
         });
        panel2.add(llamar, gbc);

        JButton colgar = new JButton("🚫📞");
        gbc.gridx = 2;
        gbc.gridy = 4;
        colgar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             radio.setEstadollamada();
             llamada.dispose();
            } 
         });
        panel2.add(colgar, gbc);

        JButton llamarultimo = new JButton("Último");
        gbc.gridx = 4;
        gbc.gridy = 4;
        llamarultimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == false){
                JFrame llamarult = new JFrame();
                llamarult.setSize(200,100);
                llamarult.setVisible(true);
                JLabel etiqueta = new JLabel(radio.llamarultimo(radio.getUsuariosllamados()));
                llamarult.add(etiqueta);
             }
            } 
         });
        panel2.add(llamarultimo, gbc);



        JPanel panel3 = new JPanel();
        info = new JLabel("Apagado");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        panel3.add(info, gbc);

        frec = new JLabel("");
        gbc.gridx = 5;
        gbc.gridy = 2;
        panel3.add(frec, gbc);



        JPanel panel4 = new JPanel(new GridBagLayout());
        JButton boton7 = new JButton("Guardar"); 
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        boton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             if(radio.getEstado() == true && radio.getModo() == true){
                double newemisora = Double.parseDouble(info.getText());
                radio.guardaremisora(fila, columna, newemisora);
             }
            } 
         }); 
        panel4.add(boton7, gbc);
        JButton boton8 = new JButton("6"); 
        gbc.gridx = 0; 
        gbc.gridy = 1;
        boton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 6;
            } 
         }); 
        panel4.add(boton8, gbc); 
        JButton boton9 = new JButton("7"); 
        gbc.gridx = 0; 
        gbc.gridy = 2;
        boton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 7;
            } 
         }); 
        panel4.add(boton9, gbc); 
        JButton boton10 = new JButton("8"); 
        gbc.gridx = 0; 
        gbc.gridy = 3;
        boton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 8;
            } 
         }); 
        panel4.add(boton10, gbc);
        JButton boton11 = new JButton("9"); 
        gbc.gridx = 0; 
        gbc.gridy = 4;
        boton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 9;
            } 
         }); 
        panel4.add(boton11, gbc);
        JButton boton12 = new JButton("10"); 
        gbc.gridx = 0; 
        gbc.gridy = 5;
        boton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             columna = 10;
            } 
         }); 
        panel4.add(boton12, gbc);



        principal.add(panel2, BorderLayout.CENTER);
        principal.add(panel3, BorderLayout.NORTH);
        principal.add(panel4, BorderLayout.EAST);


    }

    public static void main(String[] args) {
        Vista nuevo = new Vista();
    }
}
