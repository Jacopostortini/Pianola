package com.mycompany.piano;

import java.awt.Color;
import javax.swing.JLayeredPane;

public class Pianola {

    public static int RIGHE = 3;
    public static int COLONNE = 7;
    private Tasto[][] tastiBianchi;
    private Tasto[][] tastiNeri;
    private JLayeredPane[] pannelliRighe;
    private String[][] suoniBianchi = new String[][]{{"DoPrimo.wav", "RePrimo.wav", "MiPrimo.wav", "FaPrimo.wav", "SolPrimo.wav", "LaPrimo.wav", "SiPrimo.wav"}, {"DoSecondo.wav", "ReSecondo.wav", "MiSecondo.wav", "FaSecondo.wav", "SolSecondo.wav", "LaSecondo.wav", "SiSecondo.wav"}, {"DoTerzo.wav", "ReTerzo.wav", "MiTerzo.wav", "FaTerzo.wav", "SolTerzo.wav", "LaTerzo.wav", "SiTerzo.wav"}};
    private String[][] suoniNeri = new String[][]{{"DoDPrimo.wav", "ReDPrimo.wav", "", "FaDPrimo.wav", "SolDPrimo.wav", "LaDPrimo.wav", ""}, {"DoDSecondo.wav", "ReDSecondo.wav", "", "FaDSecondo.wav", "SolDSecondo.wav", "LaDSecondo.wav", ""}, {"DoDTerzo.wav", "ReDTerzo.wav", "", "FaDTerzo.wav", "SolDTerzo.wav", "LaDTerzo.wav", ""}};
    private String[][] pulsantiBianchi = new String[][]{{"1", "3", "5", "6", "8", "0", "ì"}, {"q", "e", "t", "y", "i", "p", "+"}, {"a", "d", "g", "h", "k", "ò", "ù"}};
    private String[][] pulsantiNeri = new String[][]{{"2", "4", " ", "7", "9", "'", " "}, {"w", "r", " ", "u", "o", "è", " "}, {"s", "f", " ", "j", "l", "à", " "}};
    private String[] noteBianchi = new String[]{"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};
    private String[] noteNeriBemolli = new String[]{"Reb", "Mib", "", "Solb", "Lab", "Sib", ""};
    private String[] noteNeriDiesis = new String[]{"Do#", "Re#", "", "Fa#", "Sol#", "La#", ""};

    public Pianola(JLayeredPane[] pannelliRighe) {
        this.pannelliRighe = pannelliRighe;
        tastiBianchi = new Tasto[RIGHE][COLONNE];
        tastiNeri = new Tasto[RIGHE][COLONNE];
    }

    public void create() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (j != 2 && j != 6) {
                    String etichettaNera = "<html><p align=center>"+noteNeriDiesis[j] + "<br/>" + noteNeriBemolli[j]+"<br/><br/>"+pulsantiNeri[i][j]+"</p></html>";
                    tastiNeri[i][j] = new Tasto(Color.black, j, suoniNeri[i][j], pulsantiNeri[i][j], etichettaNera, pannelliRighe[i]);
                    tastiNeri[i][j].create();
                    tastiNeri[i][j].updatePanel();
                }
                String etichetta = "<html><p align=center>"+noteBianchi[j]+"<br/><br/>"+pulsantiBianchi[i][j]+"</p></html>";
                tastiBianchi[i][j] = new Tasto(Color.white, j, suoniBianchi[i][j], pulsantiBianchi[i][j], etichetta, pannelliRighe[i]);
                tastiBianchi[i][j].create();
                tastiBianchi[i][j].updatePanel();
            }
        }
    }

    public Tasto[][] getTastiBianchi() {
        return tastiBianchi;
    }

    public Tasto[][] getTastiNeri() {
        return tastiNeri;
    }

    public String[][] getPulsantiBianchi() {
        return pulsantiBianchi;
    }

    public String[][] getPulsantiNeri() {
        return pulsantiNeri;
    }
    
    
    
}
