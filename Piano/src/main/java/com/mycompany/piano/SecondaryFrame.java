/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jacopo
 */
public class SecondaryFrame extends JFrame implements ActionListener{
    
    private Pianola pianola;
    private JButton button;
    
    public SecondaryFrame(Pianola pianola) {
        this.pianola = pianola;
        initComponents();

    }

    private void initComponents() {
        
        button = new JButton("Auto play");
        
        button.addActionListener(this);
        
        add(button);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(200, 200));
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        suonaTasto(0, 2, true, 500);
        suonaTasto(0, 1, false, 500);
        suonaTasto(0, 2, true, 500);
        suonaTasto(0, 1, false, 500);
        suonaTasto(0, 2, true, 500);
        suonaTasto(1, 6, true, 500);
        suonaTasto(0, 1, true, 500);
        suonaTasto(0, 0, true, 500);
        suonaTasto(1, 5, true, 500);
        
    }
    
    private void suonaTasto(int i, int j, boolean colore, long durata){
        if(colore){
            pianola.getTastiBianchi()[i][j].suona();
            try {
                Thread.sleep(durata);
            } catch (InterruptedException ex) {
                Logger.getLogger(SecondaryFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            pianola.getTastiBianchi()[i][j].ferma();
        } else {
            pianola.getTastiNeri()[i][j].suona();
            try {
                Thread.sleep(durata);
            } catch (InterruptedException ex) {
                Logger.getLogger(SecondaryFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            pianola.getTastiNeri()[i][j].ferma();
        }
        return;
        
    }
    
}
