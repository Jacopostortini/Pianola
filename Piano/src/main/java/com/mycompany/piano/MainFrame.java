package com.mycompany.piano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

    private final static int LARGHEZZA_FRAME = 504;
    private final static int ALTEZZA_FRAME = 801;
    private final static int RIGHE = 3;

    private JLayeredPane[] pannelliRighe;
    private Pianola pianola;

    public MainFrame() {
        initComponents();
    }

    public void initComponents() {

        setLayout(new GridLayout(RIGHE, 0));

        pannelliRighe = new JLayeredPane[RIGHE];

        for (int i = 0; i < RIGHE; i++) {
            pannelliRighe[i] = new JLayeredPane();
            pannelliRighe[i].setBorder(new LineBorder(Color.black));
            pannelliRighe[i].setSize(LARGHEZZA_FRAME, ALTEZZA_FRAME / RIGHE);
            add(pannelliRighe[i]);
        }

        pianola = new Pianola(pannelliRighe);
        pianola.create();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(LARGHEZZA_FRAME, ALTEZZA_FRAME));
        setResizable(false);
        
        this.addKeyListener(new TastieraOnClickListener(pianola));

    }

    public static void main(String args[]) {
        MainFrame mainFrame = new MainFrame();
        SecondaryFrame secondaryFrame = new SecondaryFrame(mainFrame.pianola);
        mainFrame.setVisible(true);
        secondaryFrame.setVisible(true);
        
    }

}
