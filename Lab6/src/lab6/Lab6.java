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
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        test5();
    }
    
    public static void test1() {
        System.out.println("Construcao de FenwickTree(3) : " + new FenwickTree(3));
        System.out.println("Construcao da arvore da figura : " +
            new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                    new FenwickTree(1, new FenwickTree(3),
                        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1)))));
    }
    
    public static void test2() {
        System.out.println("Construcao de allZeros(3) : " + FenwickTree.allZeros(3));
        System.out.println("Construcao de allZeros(4) : " + FenwickTree.allZeros(4));
        System.out.println("Construcao de allZeros(5) : " + FenwickTree.allZeros(5));
        System.out.println("Construcao de allZeros(6) : " + FenwickTree.allZeros(6));
    }
    
    public static void test3() {
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");
        System.out.println("Tamanho de FenwickTree(6) : " + (new FenwickTree(6)).size());
        System.out.println("Tamanho de allZeros(6) : " + (FenwickTree.allZeros(6)).size());
        System.out.println("Tamanho de allZeros(12) : " + (FenwickTree.allZeros(12)).size());
        
        FenwickTree T1 = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
        new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
        new FenwickTree(1, new FenwickTree(3),
        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
        
        System.out.println("Árvore this : " + T1);
        System.out.println("Tamanho de this : " + T1.size());
    }
    
    public static void test4() {
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");
        FenwickTree T = new FenwickTree(3,
        new FenwickTree(1, new FenwickTree(0),
        new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))),
        new FenwickTree(1, new FenwickTree(0),
        new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))));
        System.out.println("Arvore this : " + T);
        T.increment(0, 4);
        System.out.println("Resultado de increment(0, 4) : " + T);
        T.increment(1, 2);
        System.out.println("Resultado de increment(1, 2) : " + T);
        T.increment(2, 5);
        System.out.println("Resultado de increment(2, 5) : " + T);
        T.increment(3, 3);
        System.out.println("Resultado de increment(3, 3) : " + T);
        T.increment(4, 6);
        System.out.println("Resultado de increment(4, 6) : " + T);
        T.increment(5, 1);
        System.out.println("Resultado de increment(5, 1) : " + T);
    }
    
    public static void test5(){
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");
        FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
        new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
        new FenwickTree(1, new FenwickTree(3),
        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
        System.out.println("Arvore this : " + T);
        System.out.println("Soma das primeiras folhas : ");
        for(int upto = 0; upto <= 6; upto++){
        System.out.println("prefixSum(" + upto + ") : " + T.prefixSum(upto));
        }
    }

}
