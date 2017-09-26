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

            if (c < 0) {
                ss = sIn.readUTF();
                System.out.println(ss);
            } else if (c >= 0) {

                System.out.println("estoque atualizado e quantidade de  = " + c);

            }

            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
