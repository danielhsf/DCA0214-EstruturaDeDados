/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author mateus
 * @param <T>
 */
public class Pilha<T> {
    
    private final LinkedList<T> pilha;
    
    Pilha() {
        pilha = new LinkedList<>();
    }
    
    void empilha(T valor) {
        pilha.push(valor);
    }
    
    T topo() {
        if (pilha.isEmpty()) {
            throw new Error("Pilha está vazia");
        }
        return pilha.getFirst();
    }
    
    T desempilha() {
        if (pilha.isEmpty()) {
            throw new Error("Pilha está vazia");
        }
        return pilha.pop();
    }
    
    void reinicialize() {
        pilha.clear();
    }
    
    boolean estaVazia() {
        return pilha.isEmpty();
    }
    
    @Override
    public String toString() {
        return pilha.toString();
    }
    
    public String toStringInverse() {
        StringBuilder sb = new StringBuilder();
        sb.append("Historico = [");
        
        for (Iterator i = pilha.descendingIterator(); i.hasNext();) {
            sb.append(i.next().toString()).append(" ");
        }
        
        sb.append("]");
        return sb.toString();
    }
    
}
