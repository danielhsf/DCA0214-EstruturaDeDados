/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author mateus
 */
public class Operacao {
    
    private final char code;
    private final double a;
    private final double b;

    public Operacao(double a) {
        this.code = 'e';
        this.a = a;
        this.b = 0.0;
    }

    public Operacao(char code, double a, double b) {
        this.code = code;
        this.a = a;
        this.b = b;
    }

    public char getCode() {
        return code;
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }
    
    @Override
    public String toString() {
        if (getCode() == 'e') {
            return getA().toString();
        } else {
            switch (getCode()) {
                case '+':
                    return "+";
                case '-':
                    return "-";
                case '*':
                    return "*";
                case '/':
                    return "/";
            }
        }
        
        return null;
    }
    
}
