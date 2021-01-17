/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piano;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author FRANC
 */
public class TastieraOnClickListener implements KeyListener{
    
    private Pianola pianola;

    public TastieraOnClickListener(Pianola pianola) {
        this.pianola = pianola;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String pulsanteCliccato = String.valueOf(e.getKeyChar());
        for (int i = 0; i < pianola.RIGHE; i++) {
            for (int j = 0; j < pianola.COLONNE; j++) {
                if (pianola.getPulsantiBianchi()[i][j].equals(pulsanteCliccato)) {
                    pianola.getTastiBianchi()[i][j].suona();
                    return;
                }
                if (pianola.getPulsantiNeri()[i][j].equals(pulsanteCliccato)) {
                    pianola.getTastiNeri()[i][j].suona();
                    return;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String pulsanteCliccato = String.valueOf(e.getKeyChar());
        for (int i = 0; i < pianola.RIGHE; i++) {
            for (int j = 0; j < pianola.COLONNE; j++) {
                if (pianola.getPulsantiBianchi()[i][j].equals(pulsanteCliccato)) {
                    pianola.getTastiBianchi()[i][j].ferma();
                    return;
                }
                if (pianola.getPulsantiNeri()[i][j].equals(pulsanteCliccato)) {
                    pianola.getTastiNeri()[i][j].ferma();
                    return;
                }
            }
        }
    }
    
}
