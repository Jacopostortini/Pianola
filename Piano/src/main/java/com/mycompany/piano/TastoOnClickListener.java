/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piano;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TastoOnClickListener implements MouseListener {

    private Tasto tastoCliccato;

    public TastoOnClickListener(Tasto tastoCliccato) {
        this.tastoCliccato = tastoCliccato;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        tastoCliccato.suona();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tastoCliccato.ferma();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
