package Questao1;

import java.awt.*;
import java.net.*;
import java.io.*;

class servidor2 {
   
    public static void main( String args[] ) throws IOException {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
      
        DataOutputStream s1out;
        
       
        
        try {
            s = new ServerSocket( 4321);
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
