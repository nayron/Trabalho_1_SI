package Questao2;

import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

class servidor2 {
    public static void main( String args[] ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
        String cadena = "Tutorial de Java!";
        int longCad;
        DataOutputStream s1out;
       

        try {
            s = new ServerSocket( 4321,300 );
            
        } catch( IOException e ) {
            System.out.println( e );
        }

        while( true ) {
            try {
                
                s1 = s.accept();
                
                 Servidorthread st = new Servidorthread(s1);
                st.start();
                
            } catch( IOException e ) {
                System.out.println( e );
                }
            }
        }
    }
