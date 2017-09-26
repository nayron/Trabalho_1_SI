/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao2;

/**
 *
 * @author nayron
 */
import java.awt.*;
import java.net.*;
import java.io.*;

public class Servidorthread extends Thread{ 
     public Socket s1;
      String cadena = "Tutorial de Java!";
        
        DataOutputStream s1out;
     
    public Servidorthread(Socket s1) {
        super();
        this.s1 = s1;
    }
    public void run(){
        try {
              System.out.println("Conexão com cliente aceita");  
                
              ObjectOutputStream saida = new ObjectOutputStream(s1.getOutputStream());
                
              Quadrilatero alo = new Quadrilatero();
              alo.indicatipoquadrilatero();
              
             
           
              saida.writeObject(alo);
              saida.flush();

                s1.close();
                 
                
        } catch (Exception e) {
        System.out.print("Erro = "+e);
        }
    }
    
}
