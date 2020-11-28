/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.entidade;

import java.math.BigDecimal;

/**
 *
 * @author andre
 */
public class Calculo {
    
    private static double x;
    private static double y;
    
    public static BigDecimal somar(double x, double y){
    
        return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y));
    }
    
    public static BigDecimal subtrair(double x, double y){
    
        return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y));
    }
    
    public static BigDecimal multiplicar(double x, double y){
    
        return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y));
    }

    public static BigDecimal dividir(double x, double y){
    
        return BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y));
    }

    /**
     * @return the x
     */
    public static double getX() {
        return x;
    }

    /**
     * @param aX the x to set
     */
    public static void setX(double aX) {
        x = aX;
    }

    /**
     * @return the y
     */
    public static double getY() {
        return y;
    }

    /**
     * @param aY the y to set
     */
    public static void setY(double aY) {
        y = aY;
    }
}
