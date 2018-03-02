/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios_display;

import br.com.jmary.home.Browser.BrowserFX;
import java.awt.BorderLayout;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class Exercicios_Display_Setar_Url {
    
    String              url;
    Exercicios_Dysplay  Exercicios_Dysplay;  
    
    public Exercicios_Display_Setar_Url( String url2, Exercicios_Dysplay Exercicios_Dysplay2 ) {

        url                 = url2;
        Exercicios_Dysplay  = Exercicios_Dysplay2;

        inicio(); 
    }     
     
    private void inicio(){
                        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                
            Exercicios_Dysplay.jpHome.removeAll();
            //System.out.println( "Exercicios_Display_Setar_Url" );
            Exercicios_Dysplay.jpHome.setLayout( new BorderLayout() );        
            
            Exercicios_Dysplay.jpHome.add( new BrowserFX( url ), BorderLayout.CENTER );  
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_Display_Setar_Url" ); } } }.start(); 
        
    }   
    
}
