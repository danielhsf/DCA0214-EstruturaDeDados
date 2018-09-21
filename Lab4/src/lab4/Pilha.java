/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.LinkedList;

/**
 *
 * @author mateus
 * @param <T>
 */
public class Pilha<T> {
    
    private final LinkedList<T> pilha;
    
    public Pilha() {
        pilha = new LinkedList<>();
    }
    
    public void empilha(T valor) {
        pilha.push(valor);
    }
    
    public T topo() {
        if (pilha.isEmpty()) {
            throw new Error("Pilha está vazia");
        }
        return pilha.getFirst();
    }
    
    public T desempilha() {
        if (pilha.isEmpty()) {
            throw new Error("Pilha está vazia");
        }
        return pilha.pop();
    }
    
    public boolean estaVazia() {
        return pilha.isEmpty();
    }
    
    @Override
    public String toString() {
        return pilha.toString();
    }
    
}
