package Questao3;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

class cliente2 {

    public static void main(String args[]) throws IOException {
        int c, op = 0;
        String ss;
        Socket s;
        DataInputStream sIn;

        Scanner entrada = new Scanner(System.in);
        
        do{

        try {

            s = new Socket();

            InetSocketAddress endereco = new InetSocketAddress("localhost", 4322);
            s.connect(endereco, 1000);

            DataOutputStream sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());

            System.out.println("Digite o nome do produto:");
            String nome = entrada.next();
            System.out.println("Digite a quantidade do produto:");
            int qtdade = entrada.nextInt();

            sOut.writeUTF(nome);
            sOut.writeInt(qtdade);

            c = sIn.readInt();
            System.out.println("valor de C = " + c);

            if (c < 0) {//Quantidade negativa..(indisponibilidade do produto
                ss = sIn.readUTF();
                System.out.println(ss);
            } else if (c >= 0 && c<=2000) {//atualização de estoque(entrada e retirada)

               System.out.println("estoque atualizado e quantidade de  = " + c);

            }else if(c>=2001){//para no caso for inserido novo produto
                ss = sIn.readUTF();
                System.out.println(ss);
            }

            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Deseja continuar? 1-p/ Sim ou 0-p/ não");
        op = entrada.nextInt();
        }while(op != 0 );
    }
}
