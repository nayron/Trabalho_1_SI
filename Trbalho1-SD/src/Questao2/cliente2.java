package Questao2;

import java.awt.*;
import java.net.*;
import java.io.*;

class cliente2 {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
       
        Socket s;
       

        try {

            s = new Socket();

            InetSocketAddress endereco = new InetSocketAddress("localhost", 4321);
            s.connect(endereco, 1000);

            ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());
            Quadrilatero alo = (Quadrilatero) entrada.readObject();
            alo.lerdados();
            alo.mostradados();
            
            
            s.close();
                                               
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
