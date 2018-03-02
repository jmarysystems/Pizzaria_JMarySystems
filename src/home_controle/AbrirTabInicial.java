/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package home_controle;

import br.com.jmary.home.Browser.BrowserFX;
import br.com.jmary.home.Home;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class AbrirTabInicial {
    
    public AbrirTabInicial( Home HomeR ) {
        Home = HomeR;
    }
    
    Home Home;
    
    boolean um = false;
    public void inicio(){
        
        new Thread() {   /* Fim Thread de Captura Teclas*/
            @Override
            public void run() {
                while ( um == false ) {     um = true;
                    try { Thread.sleep(1); 
                    
                        paginaInicial();
                    }catch(Exception e) { }
                }
            }
        }.start(); /* Fim Thread */ 
        um = false;
    }
    
    BrowserFX BrowserFX;
    private void paginaInicial(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            BrowserFX = new BrowserFX( getClass().getResource("/sistema/Fonema_e_Letra_Home.html").toString() );
  
            JPanel p = new JPanel( new BorderLayout() );
            p.add( BrowserFX, BorderLayout.CENTER );
            
            Home.ControleTabs.AddTabHome( "Home", "/sistema_imagens/casahome.gif", p );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "JPHtmlPrincipal_Inicio" ); } } }.start(); 
        
    }
    
}
