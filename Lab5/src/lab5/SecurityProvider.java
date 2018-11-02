/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author mateus
 */
public class SecurityProvider {
    public static String salt = "5a1t";
    
    public static String md5(String stringToConvert)
    {
        String hashtext="";
        stringToConvert +=salt;
        MessageDigest m;
        
        try
        {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
        }
        catch (NoSuchAlgorithmException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        return hashtext;
    }
    
    public static String md5ToServer(Conta conta)
    {
        return md5(conta.getAgencia() + conta.getNumero() + conta.getSenha() + salt);
    }
    
    public static String[] md5ToClient(Conta conta)
    {
        String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
        
        String[] hashes = new String[toCrypt.length()];
        for (int i = 0; i < toCrypt.length(); i++) {
            hashes[i] = md5(String.valueOf(toCrypt.toCharArray()[i]));
        }
        
        return hashes;
    }
}
