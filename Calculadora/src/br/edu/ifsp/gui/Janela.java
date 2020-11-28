/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.gui;

import br.edu.ifsp.entidade.Calculo;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author andre
 */
public class Janela extends JFrame implements ActionListener{
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemSair;
    
    private JTextField display;
    
    private JPanel panelCampo;
    private JPanel panelBotoes;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton soma, sub, mult, div, sinal, ponto, igual, c;
//    private JButton paren1, paren2;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    private int operacao;
    
    public Janela(String titulo) {
        
        super(titulo);
        layout = new GridBagLayout();
    	constraints = new GridBagConstraints();
        this.setLayout(layout);
        criarComponentes();
        ajustarPropriedadesJanela();
    }
    
    private void criarComponentes() {
        
        menuBar = new JMenuBar();
        
        menu = new JMenu("Arquivo");
        
        menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(this);
        
        menu.addSeparator();
        menu.add(menuItemSair);
        
        menuBar.add(menu);
       
        setJMenuBar(menuBar);
        
        Border border= BorderFactory.createEtchedBorder(Color.WHITE, Color.BLACK);
        
        panelCampo= new JPanel();
        panelCampo.setLayout(layout);
        panelCampo.setBorder(border);
        
        panelBotoes= new JPanel();
        panelBotoes.setLayout(layout);
        panelBotoes.setBorder(border);
        
        display = new JTextField(18);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        soma = new JButton("+");
        sub = new JButton(" -");
        mult = new JButton(" *");
        div = new JButton(" /");
        ponto = new JButton(" .");
        sinal = new JButton("(-");
        igual = new JButton("=");
//        paren1= new JButton(" (");
//        paren2= new JButton(") ");
        c = new JButton("C");
        
        b0.addActionListener(e -> setDisplay("0"));
        b1.addActionListener(e -> setDisplay("1"));
        b2.addActionListener(e -> setDisplay("2"));
        b3.addActionListener(e -> setDisplay("3"));
        b4.addActionListener(e -> setDisplay("4"));
        b5.addActionListener(e -> setDisplay("5"));
        b6.addActionListener(e -> setDisplay("6"));
        b7.addActionListener(e -> setDisplay("7"));
        b8.addActionListener(e -> setDisplay("8"));
        b9.addActionListener(e -> setDisplay("9"));
        sinal.addActionListener(e -> setDisplay("-"));
        ponto.addActionListener(e -> setDisplay("."));
//        paren1.addActionListener(e -> setDisplay("("));
//        paren2.addActionListener(e -> setDisplay(")"));
        soma.addActionListener(this);
        sub.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        igual.addActionListener(this);
        c.addActionListener(this);
        
        aplicarCalPadrao();
    }

    private void ajustarPropriedadesJanela() {
        
        setVisible(true);
        setSize(250, 300);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void encerrarAplicacao() {
        System.exit(0);
    }
    
    private void aplicarCalPadrao() {
        
        addComponente(panelCampo, display, 0, 0, 1, 1);
    	addComponente(panelBotoes, b1, 0, 0, 1, 1);
    	addComponente(panelBotoes, b2, 0, 1, 1, 1);
    	addComponente(panelBotoes, b3, 0, 2, 1, 1);
        addComponente(panelBotoes, b4, 1, 0, 1, 1);
        addComponente(panelBotoes, c, 0, 3, 1, 1);
        addComponente(panelBotoes, b5, 1, 1, 1, 1);
        addComponente(panelBotoes, b6, 1, 2, 1, 1);
        addComponente(panelBotoes, b7, 2, 0, 1, 1);
        addComponente(panelBotoes, b8, 2, 1, 1, 1);
        addComponente(panelBotoes, soma, 1, 3, 1, 1);
        addComponente(panelBotoes, b9, 2, 2, 1, 1);
        addComponente(panelBotoes, b0, 3, 1, 1, 1);
        addComponente(panelBotoes, ponto, 3, 2, 1, 1);
        addComponente(panelBotoes, sinal, 3, 0, 1, 1);
        addComponente(panelBotoes, sub, 2, 3, 1, 1);
        addComponente(panelBotoes, mult, 3, 3, 1, 1);
//        addComponente(panelBotoes, paren1, 4, 0, 1, 1);
//        addComponente(panelBotoes, paren2, 4, 1, 1, 1);
        addComponente(panelBotoes, igual, 4, 2, 1, 1);
        addComponente(panelBotoes, div, 4, 3, 1, 1);
    	

        addComponente(this,panelCampo, 0, 0, 1, 1);
        addComponente(this,panelBotoes, 1, 0, 1, 1);
        
    } 
    
    private void addComponente(Container cont, JComponent component, int lin, int col, int lar, int alt) { 
        
        constraints.gridy = lin;
        constraints.gridx = col;
        
        constraints.gridwidth = lar;
        constraints.gridheight = alt;
        
        constraints.fill = GridBagConstraints.CENTER;
        
        constraints.insets = new Insets(5,5,5,5);
        
//        component.setFont(new Font("arial", Font.PLAIN, 10));
     
        layout.setConstraints(component, constraints);
        
        cont.add(component);
    }
     
     
    private void setDisplay(String valor){
        
        display.setText(display.getText().concat(valor));
    }
    
    private boolean isNumeric (String s) {
        try {
            Double.valueOf (s); 
            return true;
        }catch (NumberFormatException ex) {
            return false;
        }
    }
    
    private void desabilitarOperadores(){
        
        display.setText(null);
        soma.setEnabled(false);
        sub.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
    }
    
    private void habilitarOperadores(){
        
        soma.setEnabled(true);
        sub.setEnabled(true);
        mult.setEnabled(true);
        div.setEnabled(true);
    }
    
    private boolean campoVazio(){
        
        return display.getText().trim().isEmpty();
    }
    
    private void empilharCalculo(BigDecimal numero){
        
        double valor;
        valor= numero.doubleValue();
        display.setText(String.valueOf(valor));
        Calculo.setX(valor);
        Calculo.setY(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==soma){
             
            if(campoVazio()){
                Message.errorMessage(soma);
                return;
            }
            
            if(!isNumeric(display.getText())){
              
              Calculo.setX(0);
              Calculo.setY(0);
              desabilitarOperadores();
              habilitarOperadores();
              Message.invalidFieldMessage(soma);
              Message.informaTiontMessage(soma);
              return;  
            }
           
            operacao= 1;
            Calculo.setX(Double.valueOf(display.getText()).doubleValue());
            desabilitarOperadores();
           
        }else if(e.getSource()==sub){
            
            if(campoVazio()){
                Message.errorMessage(sub);
                return;
            }
            
            if(!isNumeric(display.getText())){
              
              Calculo.setX(0);
              Calculo.setY(0);
              desabilitarOperadores();
              habilitarOperadores();
              Message.invalidFieldMessage(sub);
              Message.informaTiontMessage(sub);
              return;  
            }
            
            operacao= 2;
            Calculo.setX(Double.valueOf(display.getText()).doubleValue());
            desabilitarOperadores();
            
        }else if(e.getSource()==mult){
            
            if(campoVazio()){
                Message.errorMessage(mult);
                return;
            }
            
            if(!isNumeric(display.getText())){
              
              Calculo.setX(0);
              Calculo.setY(0);
              desabilitarOperadores();
              habilitarOperadores();
              Message.invalidFieldMessage(mult);
              Message.informaTiontMessage(mult);
              return;  
            }
            
            operacao= 3;
            Calculo.setX(Double.valueOf(display.getText()).doubleValue());
            desabilitarOperadores();
            
        }else if(e.getSource()==div){
            
            if(campoVazio()){
                Message.errorMessage(div);
                return;
            }
            
            if(!isNumeric(display.getText())){
              
              Calculo.setX(0);
              Calculo.setY(0);
              desabilitarOperadores();
              habilitarOperadores();
              Message.invalidFieldMessage(div);
              Message.informaTiontMessage(div);
              
              return;  
            }
            
            operacao= 4;
            Calculo.setX(Double.valueOf(display.getText()).doubleValue());
            desabilitarOperadores();
            
        }else if(e.getSource()==igual){
            
            if(!isNumeric(display.getText())){
              
                    Calculo.setX(0);
                    Calculo.setY(0);
                    desabilitarOperadores();
                    habilitarOperadores();
                    Message.invalidFieldMessage(mult);
                    Message.informaTiontMessage(mult);
                    return;  
            }
            
            if(operacao==1){
                
                if(!campoVazio()){
                
                    BigDecimal valor;
                    Calculo.setY(Double.valueOf(display.getText()).doubleValue());
                    valor= Calculo.somar(Calculo.getX(), Calculo.getY());
                    empilharCalculo(valor);
                    habilitarOperadores();
                    operacao=0;
                }else{
                    Message.errorMessage(igual);
                }  
            }
            
            if(operacao==2){
                
                if(!campoVazio()){
                
                    BigDecimal valor;
                    Calculo.setY(Double.valueOf(display.getText()).doubleValue());
                    valor= Calculo.subtrair(Calculo.getX(), Calculo.getY());
                    empilharCalculo(valor);
                    habilitarOperadores();
                    operacao=0;
                }else{
                    Message.errorMessage(igual);
                }
            }
            
            if(operacao==3){
               
                if(!campoVazio()){
                
                    BigDecimal valor;
                    Calculo.setY(Double.valueOf(display.getText()).doubleValue());
                    valor= Calculo.multiplicar(Calculo.getX(), Calculo.getY());
                    empilharCalculo(valor);
                    habilitarOperadores();
                    operacao=0;
                }else{
                    Message.errorMessage(igual);
                }
            }
            
            if(operacao==4){
                
                if(!campoVazio()){
                
                    BigDecimal valor;
                    Calculo.setY(Double.valueOf(display.getText()).doubleValue());
                    valor= Calculo.dividir(Calculo.getX(), Calculo.getY());
                    empilharCalculo(valor);
                    habilitarOperadores();
                    operacao=0;
                }else{
                    Message.errorMessage(igual);
                }
            }
            
        }else if(e.getSource()==c){
            
            Calculo.setX(0);
            Calculo.setY(0);
            desabilitarOperadores();
            habilitarOperadores();
            Message.informaTiontMessage(c);
            return;
            
        }else{
            encerrarAplicacao();
        }
    } 
}
