package Questao1;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

class cliente2 {
   
    public static void main(String args[]) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int c;
      
        Socket s;
        DataInputStream sIn;
        

        try {

            s = new Socket();
            
            System.out.println("Digite o IP");
            String ip = entrada.next();
            System.out.println("Digite o Porta");
            int porta = entrada.nextInt();
            
            System.out.println("IP = " + ip + " porta " + porta);
            

            InetSocketAddress endereco = new InetSocketAddress(ip, porta);
            //InetSocketAddress endereco = new InetSocketAddress("localhost", 4321);
            s.connect(endereco, 1000);

            sIn = new DataInputStream(s.getInputStream());
           DataOutputStream sOut = new DataOutputStream(s.getOutputStream());
            
            System.out.println("Digite um numero:");
            for(int i = 0;i<3;i++){
            c = entrada.nextInt();
            sOut.writeInt(c);
            }
            /*
        while( ( c = sIn.read() ) != -1 )
            System.out.print( (char)c );
             */
           int maior = sIn.readInt();
           int menor = sIn.readInt();
            System.out.println("Maior = "+maior);
            System.out.println("Menor = "+menor);

            s.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
