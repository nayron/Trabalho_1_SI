package Questao3;

import java.awt.*;
import java.net.*;
import java.io.*;

class servidor3 {
    public static void main( String args[] ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
      

        try {
            s = new ServerSocket( 4322,300 );
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
