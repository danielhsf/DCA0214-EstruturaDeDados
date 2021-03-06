/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author mateus
 */
public class FenwickTree {
    
    private int value = 0;
    private int leftSize = 0;
    private FenwickTree left;
    private FenwickTree right;
    
    public FenwickTree(int value) {
        this.value = value;
        this.leftSize = 0;
    }
    
    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right) {
        this.leftSize = leftSize;
        this.left = left;
        this.right = right;
        
        this.value = sumValues();
    }

    public int getValue() {
        return value;
    }

    public int getLeftValue() {
        return leftSize;
    }

    public FenwickTree getLeft() {
        return left;
    }

    public FenwickTree getRight() {
        return right;
    }
    
    static FenwickTree allZeros(int n) {
        if (n==0) return null;
        if (n==1) return new FenwickTree(0);
        int m = n/2;
        return new FenwickTree(n - m, allZeros(n-m), allZeros(m));
    }
    
    public int size() {
        if (this.leftSize == 0) {
            return 1;
        }
        else {
            int sum = 0;
            if (this.left != null) {
                sum += this.left.size();
            }
            if (this.right != null) {
                sum += this.right.size();
            }
            return sum;
        }
    }
    
    public void increment(int i, int delta) {
        FenwickTree aux = this;
        int leftplaces = aux.leftSize;
        while(aux.leftSize != 0){
            if(leftplaces > i){
                aux = aux.left;
                leftplaces = aux.leftSize;
            }else{
                aux = aux.right;
                leftplaces = leftplaces + aux.leftSize;
            }
        }
        aux.value = delta;
        this.value = sumValues();
    }

    public int prefixSum(int i) {
        if(i == 0){
            return 0;
        }
        FenwickTree aux = this;
        int indice = aux.leftSize;
        int valor = aux.value;
        while(indice != i){
            if(indice > i){
                valor = valor - aux.right.value;
                aux = aux.left;
                indice = aux.leftSize;
            }else{
                aux = aux.right;
                indice = indice +  aux.leftSize;
                if(aux.leftSize == 0){
                    indice +=1;
                }
                //valor = valor - aux.right.value;
            }
        }
        
        if(aux.leftSize != 0){
            valor = valor - aux.right.value;
        }
        
        return valor;
    }

    public int between(int lo, int hi) {

        return prefixSum(hi) - prefixSum(lo);
    }

        
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.value).append(", ").append(this.leftSize);
        
        if (left != null) {
            sb.append(", ").append(left.toString());
        }
        if (right != null) {
            sb.append(", ").append(right.toString());
        }
        
        sb.append("]");
        
        return sb.toString();
    }
    
    private int sumValues() {
        int sum = 0;
        if (left != null) {
            sum += left.sumValues();
            this.value = sum;
        }
        if (right != null) {
            sum += right.sumValues();
            this.value = sum;
        }
        
        return this.value;
    }
}
