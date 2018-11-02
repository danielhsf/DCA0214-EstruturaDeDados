/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class Database {
    public static final ArrayList<Letra> caracteres;
    
    static
    {
        caracteres = new ArrayList<>();
        String chars = "abcdefghijklmnopqrstuvwxyz 1234567890";
        
        for (char c : chars.toCharArray()) {
            caracteres.add(new Letra(String.valueOf(c)));
        }
    }
    
    public static Letra getLetra(String md5) {
        for (Letra l : caracteres) {
            if (l.getMd5Code().equals(md5))
                return l;
        }
        
        return null;
    }
    
    public static Conta getConta(String[] hashes) {
        StringBuilder sb = new StringBuilder();
        
        for (String hash : hashes) {
            sb.append(getLetra(hash).getCaractere());
        }
        
        String nome = "";
        String saldo = "";
        
        for (String s : sb.toString().split(" ")) {
            boolean isSaldo = false;
            for (char c : s.toCharArray()) {
                for (char n : "1234567890".toCharArray()) {
                    if (c == n) {
                        isSaldo = true;
                        break;
                    }
                }
            }
            
            if (!isSaldo) {
                if (nome.isEmpty()) {
                    nome = s;
                } else {
                    nome = nome + " " + s;
                }
            } else {
                saldo = s;
            }
        }
              
        return new Conta(nome, saldo);
    }
}
