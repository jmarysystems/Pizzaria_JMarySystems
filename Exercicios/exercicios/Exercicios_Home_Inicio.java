/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios;

import exercicios_new.Exercicios_New;
import exercicios_search.Menu_Pesquisa_Exercicios;
import exercicios_search.Tabela_Pesquisa_BD_Exercicios;
import home_usuario_logado.Bean_Usuario_Logado;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Exercicios_Home_Inicio {
        
    Exercicios_Home Exercicios_Home;//Materias_Home; 
    
    public Exercicios_Home_Inicio( Exercicios_Home Exercicios_Home2 ) {
        
        Exercicios_Home = Exercicios_Home2;
        
        inicio();
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            iniciar();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start(); 
                
    }
    
    private void iniciar(){
        
        Exercicios_Home.pnHome.setLayout( new BorderLayout() );    
        
        Exercicios_Home.pnHome.add( Exercicios_Home.Conjunto_Botoes_Exercicios  , BorderLayout.NORTH  );
        Exercicios_Home.pnHome.add( Exercicios_Home.tabHome                     , BorderLayout.CENTER );    
        
        if( Bean_Usuario_Logado.PERMITIRACESSO == true ) {
            
            addAbaPesquisa();            
        }
                 
    }  
    
    // Aba Novo 
    public void addAbaNovo(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
           
           Exercicios_Home.Home.ControleTabs.AddTabSemControleNovo( Exercicios_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Exercicios_New(Exercicios_Home) );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start();                 
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Exercicios_Home.Home.ControleTabs.removerTabSemControleSelecionado( Exercicios_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start();        
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            Menu_Pesquisa_Exercicios      Menu_Pesquisa_Exercicios      = new Menu_Pesquisa_Exercicios     ( Exercicios_Home );
            Tabela_Pesquisa_BD_Exercicios Tabela_Pesquisa_BD_Exercicios = new Tabela_Pesquisa_BD_Exercicios( Exercicios_Home );
            
            Menu_Pesquisa_Exercicios.tabela(Tabela_Pesquisa_BD_Exercicios);
            Tabela_Pesquisa_BD_Exercicios.tabela(Menu_Pesquisa_Exercicios);
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa_Exercicios, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Exercicios, BorderLayout.CENTER  );
                                    
            Exercicios_Home.Home.ControleTabs.AddTabSemControleNovo( Exercicios_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaPesquisa(), \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start();                 
    }
                 
}
