/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao3;

/**
 *
 * @author nayron
 */
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Servidorthread extends Thread {

    public Socket s1;
    String nomeProd;
    int qtdadeprodu;
    String p;
    int qd;
    int aux;

    DataOutputStream s1out;

    Scanner entrada = new Scanner(System.in);

    public Servidorthread(Socket s1) {
        super();
        this.s1 = s1;
    }

    public void run() {
        try {
            s1out = new DataOutputStream(s1.getOutputStream());
            DataInputStream sIN = new DataInputStream(s1.getInputStream());

            String[] produtos = new String[30];
            int[] quantidade = new int[30];

            nomeProd = sIN.readUTF();
            qtdadeprodu = sIN.readInt();
            
          
            produtos[0] = "arroz";
            quantidade[0] = 2;
           
            
      
            for (int i = 0; i < 30; i++) {
                if (produtos[i].equalsIgnoreCase(nomeProd)) {

                    if (qtdadeprodu > 0) {
                        System.out.println("Quantidade = " + quantidade[i]);
                        quantidade[i] = quantidade[i] + qtdadeprodu;
                        s1out.writeInt(quantidade[i]);
                        break;
                    }else if(qtdadeprodu<0) {
                        aux = quantidade[i]+qtdadeprodu;
                        System.out.println("valor do aux " + aux);
                        if(aux<0){
                            s1out.writeUTF("Quantidade Indisponivel");
                            System.out.println("Quantidade Indisponivel ");
                            break;
                        }else if(aux>=0){
                                quantidade[i] = aux;
                             s1out.writeInt(quantidade[i]);
                             break;
                            
                        }
                    }

                } else if (!produtos[i].equalsIgnoreCase(nomeProd) && qtdadeprodu > 0) {
                    System.out.println("Digite o nome do produto que deseja cadastrar:");
                    p = entrada.next();
                    System.out.println("Digite a quatidade:");
                    qd = entrada.nextInt();
                    produtos[i] = p;
                    quantidade[i] = qd;
                    break;

                } else {
                    System.out.println("produto inexsitente");

                }

            }

            s1.close();

        } catch (Exception e) {
            System.out.print("Erro = " + e);
        }
    }

}

 