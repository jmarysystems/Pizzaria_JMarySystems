/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_atualizar;

import exercicios.Exercicios;
import exercicios.Exercicios_Home;
import exercicios_new.Exercicios_New;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Exercicios_Atualizar {
    
    Exercicios_Home       Exercicios_Home;
    public Exercicios     Exercicios;
    public Exercicios_New Exercicios_New;
    
    String alterar = "";
    
    public Exercicios_Atualizar( Exercicios_Home Assunto_Home2, Exercicios Exercicios2, String alterar2 ) {
        
        Exercicios_Home = Assunto_Home2;
        Exercicios      = Exercicios2;
        alterar         = alterar2;
        
        Exercicios_New = new Exercicios_New(Exercicios_Home);
        
        inicio();
    }
    
    Exercicios_Atualizar Exercicios_Atualizar;
    private void inicio(){
        
        Exercicios_Atualizar = this;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                     
            if( alterar.equals("Alterar") ){
                Exercicios_Home.Home.ControleTabs.AddTabSemControleNovo( Exercicios_Home.tabHome, alterar, "/utilidades_imagens/alterar.gif", Exercicios_New );
            }
            else if( alterar.equals("Visualizar") ){
                Exercicios_Home.Home.ControleTabs.AddTabSemControleNovo( Exercicios_Home.tabHome, "Visualizar", "/utilidades_imagens/olho.png", Exercicios_New );
            }
            Exercicios_Atualizar_Inicio Exercicios_Atualizar_Inicio = new Exercicios_Atualizar_Inicio( Exercicios_Atualizar );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_Atualizar" ); } } }.start();                 
    }
    
}
