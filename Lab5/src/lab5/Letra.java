/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author mateus
 */
public class Letra {
    private final String caractere;
    private final String md5Code;
    
    public Letra(String caractere) {
        this.caractere = caractere;
        md5Code = SecurityProvider.md5(caractere);
    }

    public String getCaractere() {
        return caractere;
    }

    public String getMd5Code() {
        return md5Code;
    }
}
