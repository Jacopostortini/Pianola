package com.mycompany.piano;

import java.awt.Color;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

public class Tasto {

    //Attributi
    private Color colore;
    private int colonna;
    private String suono;
    private String pulsante;
    private String etichetta;
    private JLabel label;
    private JLayeredPane contenitore;
    private Clip clip;

    //Costruttore
    public Tasto(Color colore, int colonna, String suono, String pulsante, String nota, JLayeredPane contenitore) {
        this.colore = colore;
        this.colonna = colonna;
        this.suono = suono;
        this.pulsante = pulsante;
        this.etichetta = nota;
        this.contenitore = contenitore;
        try {
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(new File(suono).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //Getters and setters
    public Color getColore() {
        return colore;
    }

    public void setColore(Color colore) {
        this.colore = colore;
    }

    public int getColonna() {
        return colonna;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    public String getSuono() {
        return suono;
    }

    public void setSuono(String suono) {
        this.suono = suono;
    }

    public String getPulsante() {
        return pulsante;
    }

    public void setPulsante(String pulsante) {
        this.pulsante = pulsante;
    }

    public String getEtichetta() {
        return etichetta;
    }

    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLayeredPane getContenitore() {
        return contenitore;
    }

    public void setContenitore(JLayeredPane contenitore) {
        this.contenitore = contenitore;
    }

    public void create() {
        label = new JLabel();

        label.setOpaque(true);
        label.setBackground(colore);
        LineBorder bordo = new LineBorder(Color.black, 1);
        label.setBorder(bordo);
        label.addMouseListener(new TastoOnClickListener(this));

        double larghezzaBianco = contenitore.getWidth() / 7.;
        double altezzaBianco = contenitore.getHeight();
        double xBianco = colonna * larghezzaBianco;

        if (colore.equals(Color.white)) {
            label.setBounds((int) xBianco, 0, (int) larghezzaBianco, (int) altezzaBianco);
            JLabel etichettaBianca = new JLabel(etichetta, JLabel.CENTER);
            etichettaBianca.setBounds((int) xBianco, (int)altezzaBianco-70, (int) larghezzaBianco, 60);
            contenitore.add(label, JLayeredPane.DEFAULT_LAYER);
            contenitore.add(etichettaBianca, JLayeredPane.DRAG_LAYER);
        } else if (colore.equals(Color.black)) {
            double larghezzaNero = 2. / 3 * larghezzaBianco;
            double altezzaNero = 2. / 3 * altezzaBianco;
            double xNero = xBianco + larghezzaNero;
            label.setBounds((int) xNero, 0, (int) larghezzaNero, (int) altezzaNero);
            JLabel etichettaNera = new JLabel(etichetta, JLabel.CENTER);
            etichettaNera.setBounds((int) xNero, (int)altezzaNero-70, (int) larghezzaNero, 70);
            etichettaNera.setForeground(Color.white);
            contenitore.add(label, JLayeredPane.POPUP_LAYER);
            contenitore.add(etichettaNera, JLayeredPane.DRAG_LAYER);
        }

    }

    public void updatePanel() {
        contenitore.validate();
        contenitore.repaint();
    }
    
    public void suona(){
        if(!clip.isRunning()){
            label.setBackground(Color.red);
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }
    
    public void ferma(){
        label.setBackground(colore);
        clip.stop();
    }
}
