/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assunto;

import assunto_new.Assunto_New;
import assunto_search.Menu_Pesquisa_Assunto;
import assunto_search.Tabela_Pesquisa_BD_Assunto;
import home_usuario_logado.Bean_Usuario_Logado;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import utilidades.Conjunto_Botoes;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Assunto_Home_Inicio {
    
    Conjunto_Botoes Conjunto_Botoes;
        
    Assunto_Home Assunto_Home;
    
    public Assunto_Home_Inicio( Assunto_Home Assunto_Home2 ) {
        
        Assunto_Home = Assunto_Home2;
        
        inicio();
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            iniciar();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Assunto_Home_Inicio" ); } } }.start(); 
                
    }
    
    private void iniciar(){
        
        Assunto_Home.pnHome.setLayout( new BorderLayout() ); 
        
        Conjunto_Botoes = new Conjunto_Botoes( Assunto_Home.Home );
        eventoBotaoNovo();
        eventoBotaoCancelar();
        eventoBotaoPesquisar();
        
        Assunto_Home.pnHome.add( Conjunto_Botoes                   , BorderLayout.NORTH  );
        Assunto_Home.pnHome.add( Assunto_Home.tabHome              , BorderLayout.CENTER );    
        
        if( Bean_Usuario_Logado.PERMITIRACESSO == true ) {
            
            addAbaPesquisa();            
        }
                 
    }  
    
    // Aba Novo 
    public void addAbaNovo(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
           
           Assunto_Home.Home.ControleTabs.AddTabSemControleNovo( Assunto_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Assunto_New(Assunto_Home) );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", "Assunto_Home_Inicio" ); } } }.start();                 
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Assunto_Home.Home.ControleTabs.removerTabSemControleSelecionado( Assunto_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", "Assunto_Home_Inicio" ); } } }.start();        
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            Menu_Pesquisa_Assunto      Menu_Pesquisa_Assunto      = new Menu_Pesquisa_Assunto     ( Assunto_Home );
            Tabela_Pesquisa_BD_Assunto Tabela_Pesquisa_BD_Assunto = new Tabela_Pesquisa_BD_Assunto( Assunto_Home );
            
            Menu_Pesquisa_Assunto.tabela(Tabela_Pesquisa_BD_Assunto);
            Tabela_Pesquisa_BD_Assunto.tabela(Menu_Pesquisa_Assunto);
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa_Assunto, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Assunto, BorderLayout.CENTER  );
                                    
            Assunto_Home.Home.ControleTabs.AddTabSemControleNovo( Assunto_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaPesquisa(), \n"
                + e.getMessage() + "\n", "Subcategorias_Home_Inicio" ); } } }.start();                 
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    private void eventoBotaoNovo(){         
        /*new Thread() {   @Override public void run() {*/ try {     
            //Eventos
            MouseListener[] MouseListener = Conjunto_Botoes.btNovo.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Conjunto_Botoes.btNovo.removeMouseListener( MouseListener1 );
            }
            Conjunto_Botoes.btNovo.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    //if( Usuario_Permissoes.booCadastrarproduto(Usuario_Logado.ID ) == true ) {
                         
                         addAbaNovo();
                     //}     
                     //else{
                     //    JOPM JOPM = new JOPM( 2, "USUÁRIO SEM AUTORIZAÇÂO, \n"+ "O USUÁRIO LOGADO NÃO TEM PERMISSÃO PARA REALIZAR ESTA AÇÃO" + "\n", this.getClass().getSimpleName() );
                     //}
                }
            });   
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "eventoBotaoNovo(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } //} }.start(); 
    }
    
    private void eventoBotaoCancelar(){         
        /*new Thread() {   @Override public void run() {*/ try {     
            //Eventos
            MouseListener[] MouseListener = Conjunto_Botoes.btCancelar.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Conjunto_Botoes.btCancelar.removeMouseListener( MouseListener1 );
            }
            Conjunto_Botoes.btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    cancelar();
                }
            });   
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "eventoBotaoCancelar(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } //} }.start(); 
    }
    
    private void eventoBotaoPesquisar(){         
        /*new Thread() {   @Override public void run() {*/ try {     
            //Eventos
            MouseListener[] MouseListener = Conjunto_Botoes.btPesquisar.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Conjunto_Botoes.btPesquisar.removeMouseListener( MouseListener1 );
            }
            Conjunto_Botoes.btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    addAbaPesquisa();
                }
            });   
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "eventoBotaoPesquisar(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } //} }.start(); 
    }
                 
}
