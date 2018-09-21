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
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test1();
        test2();
    }
    
    static void test1() {
        Pilha<Double> aPilha = new Pilha<>();
        
        aPilha.empilha(1.1);
        aPilha.empilha(2.1);
        aPilha.empilha(3.1);
        aPilha.empilha(4.1);
        aPilha.empilha(5.1);
        
        double valor;
        valor = aPilha.topo();
        
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.topo();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
    }
    
    static void test2() {
        Pilha<Double> aPilha = new Pilha<>();
        
        System.out.println(aPilha);
        aPilha.empilha(1.1);
        System.out.println(aPilha);
        aPilha.empilha(2.1);
        System.out.println(aPilha);
        aPilha.empilha(3.1);
        System.out.println(aPilha);
        
        double valor;
        
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
        
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
        
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
    }
    
}
