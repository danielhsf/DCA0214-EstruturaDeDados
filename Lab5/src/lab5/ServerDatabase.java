/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class ServerDatabase extends Database {
    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;
    
    static
    {
        contas = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            contas.add(new ArrayList<>());
        }
    }
    
    public static int hashCode(String md5) {
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        
        int pos;
        pos = bi.mod(m).intValue();
        return pos;
    }
    
    public static void insereConta(Conta conta) {
        int pos = hashCode(conta.getMd5());
        
        ArrayList<Conta> atual = contas.get(pos);
        
        boolean add = true;
        for (Conta c : atual) {
            if (c.getMd5().equals(conta.getMd5()))
                add = false;
        }
        
        if (add) atual.add(conta);
        
        contas.set(pos, atual);
    }
    
    public static Conta getConta(String md5) {
        int pos = hashCode(md5);
        
        ArrayList<Conta> atual = contas.get(pos);
        
        for (Conta c : atual) {
            if (c.getMd5().equals(md5))
                return c;
        }
        
        return null;
    }
        
}
