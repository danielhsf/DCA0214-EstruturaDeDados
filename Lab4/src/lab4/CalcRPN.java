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
public class CalcRPN {
    
    final Pilha<Double> aPilha;
    final Pilha<Operacao> hist;
    
    CalcRPN() {
        aPilha = new Pilha<>();
        hist = new Pilha<>();
    }
    
    void mais() {
        double val2 = aPilha.desempilha();
        double val1 = aPilha.desempilha();
        
        double res = val1 + val2;
        
        aPilha.empilha(res);
        hist.empilha(new Operacao('+', val1, val2));
    }
    
    void menos() {
        double val2 = aPilha.desempilha();
        double val1 = aPilha.desempilha();
        
        double res = val1 - val2;
        
        aPilha.empilha(res);
        hist.empilha(new Operacao('-', val1, val2));
    }
    
    void vezes() {
        double val2 = aPilha.desempilha();
        double val1 = aPilha.desempilha();
        
        double res = val1 * val2;
        
        aPilha.empilha(res);
        hist.empilha(new Operacao('*', val1, val2));
    }
    
    void dividido() {
        double val2 = aPilha.desempilha();
        double val1 = aPilha.desempilha();
        
        double res = val1 / val2;
        
        aPilha.empilha(res);
        hist.empilha(new Operacao('/', val1, val2));
    }
    
    Double resultado() {
        return aPilha.topo();
    }
    
    // Interpretador de comandos
    void exec(String cmd) {
        
        switch(cmd) {
            case "+":
                mais();
                break;
            case "-":
                menos();
                break;
            case "*":
                vezes();
                break;
            case "/":
                dividido();
                break;
            case "clear":
                aPilha.reinicialize();
                hist.reinicialize();
                break;
            case "hist":
                System.out.println(hist.toStringInverse());
                break;
            case "undo":
                Operacao op = hist.desempilha();
                aPilha.desempilha();
                
                if (op.getCode() != 'e') {
                    aPilha.empilha(op.getB());
                    aPilha.empilha(op.getA());
                }
                
                break;
            default:
                double valor = Double.parseDouble(cmd);
                aPilha.empilha(valor);
                hist.empilha(new Operacao(valor));
                break;
        }
        
    }
    
}
