/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao1;

/**
 *
 * @author nayron
 */
import java.awt.*;
import java.net.*;
import java.io.*;

public class Servidorthread extends Thread {

    public Socket s1;
    String cadena = "Tutorial de Java!";

    DataOutputStream s1out;
    DataInputStream sIN;

    public Servidorthread(Socket s1) {
        super();
        this.s1 = s1;
    }

    public void run() {
        try {
            s1out = new DataOutputStream(s1.getOutputStream());
            DataInputStream sIN = new DataInputStream(s1.getInputStream());
            
            int[] m = new int[3];
            m[0] = sIN.readInt();
            
            if (m[0] < 0) {
                System.err.println("Numero negativo.....Encerrando...");
                System.exit(0);
            }
            
            int maior = m[0];
            int menor = m[0];
            for (int i = 1; i <= 2; i++) {
                m[i] = sIN.readInt();
                if (m[i] > maior) {
                    maior = m[i];
                } else if (m[i] < menor) {
                    menor = m[i];
                }

            }
            s1out.writeInt(maior);
            s1out.writeInt(menor);

            s1.close();

        } catch (Exception e) {
            System.out.print("Erro = " + e);
        }
    }

}
