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
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test4();
    }
    
    public static void test()
    {
        Conta c1 = new Conta("124", "333", "1234","10", "john doe");
        System.out.println(c1);
        Conta c2 = new Conta("John Doe", "10");
        System.out.println(c2);
        Conta c3 = new Conta("123", "321","666");
        System.out.println(c3);
    }
    
    public static void test1()
    {
        System.out.println(SecurityProvider.md5("teste"));
    }
    
    public static void test2()
    {
        Conta c = new Conta("1234", "2222","1245");
        System.out.println(SecurityProvider.md5ToServer(c));
    }
    
    public static void test3()
    {
        Conta c = new Conta("1234", "2222","1245");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        System.out.println(chave);
        Conta conta = ServerDatabase.getConta(chave);
        System.out.println(conta);
    }
    
    public static void test4()
    {
        Conta c = new Conta("124", "333", "1234","10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        for(int i=0;i<chars.length;i++)
        {
            System.out.println(chars[i]);
        }
    }
    
    public static void test5()
    {
        Conta c = new Conta("124", "333", "1234","10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        System.out.println(Database.getConta(chars));
    }
    
    public static void test6()
    {
        Letra l = new Letra("a");
        String md5 = l.getMd5Code();
        System.out.println(md5);
        Letra ll = Database.getLetra(md5);
        System.out.println(ll.getCaractere());
    }
}
