/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.gui;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Message {
    
    
    public static void errorMessage(JComponent c){
        JOptionPane.showMessageDialog(
                c, "campo vazio","erro",JOptionPane.ERROR_MESSAGE);
    }
    
    public static void informaTiontMessage(JComponent c){
        JOptionPane.showMessageDialog(
                c, "reiniciado","info",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void invalidFieldMessage(JComponent c){
        JOptionPane.showMessageDialog(
                c, "campo invalido", "error", JOptionPane.ERROR_MESSAGE);
    }
    
}
