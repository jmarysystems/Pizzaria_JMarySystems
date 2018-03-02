/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subcategoria;

import home_usuario_logado.Bean_Usuario_Logado;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import subcategoria_search.Menu_Pesquisa_Subcategorias;
import subcategoria_search.Tabela_Pesquisa_BD_Subcategorias;
import subcategoria_new.Subcategorias_New;
import utilidades.Conjunto_Botoes;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Subcategorias_Home_Inicio {
    
    Conjunto_Botoes Conjunto_Botoes;
        
    Subcategorias_Home Subcategorias_Home;
    
    public Subcategorias_Home_Inicio( Subcategorias_Home Categorias_Home2 ) {
        
        Subcategorias_Home = Categorias_Home2;
        
        inicio();
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            iniciar();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Subcategorias_Home_Inicio" ); } } }.start(); 
                
    }
    
    private void iniciar(){
        
        Subcategorias_Home.pnHome.setLayout( new BorderLayout() );   
        
        Conjunto_Botoes = new Conjunto_Botoes( Subcategorias_Home.Home );
        eventoBotaoNovo();
        eventoBotaoCancelar();
        eventoBotaoPesquisar();
        
        Subcategorias_Home.pnHome.add( Conjunto_Botoes                  , BorderLayout.NORTH  );
        Subcategorias_Home.pnHome.add( Subcategorias_Home.tabHome       , BorderLayout.CENTER );    
        
        if( Bean_Usuario_Logado.PERMITIRACESSO == true ) {
            
            addAbaPesquisa();            
        }
                 
    }  
    
    // Aba Novo 
    public void addAbaNovo(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
           
           Subcategorias_Home.Home.ControleTabs.AddTabSemControleNovo( Subcategorias_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Subcategorias_New(Subcategorias_Home) );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", "Subcategorias_Home_Inicio" ); } } }.start();                 
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Subcategorias_Home.Home.ControleTabs.removerTabSemControleSelecionado( Subcategorias_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", "Categorias_Home_Inicio" ); } } }.start();        
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            Menu_Pesquisa_Subcategorias Menu_Pesquisa_Subcategorias           = new Menu_Pesquisa_Subcategorias     ( Subcategorias_Home );
            Tabela_Pesquisa_BD_Subcategorias Tabela_Pesquisa_BD_Subcategorias = new Tabela_Pesquisa_BD_Subcategorias( Subcategorias_Home );
            
            Menu_Pesquisa_Subcategorias.tabela(Tabela_Pesquisa_BD_Subcategorias);
            Tabela_Pesquisa_BD_Subcategorias.tabela(Menu_Pesquisa_Subcategorias);
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa_Subcategorias, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Subcategorias, BorderLayout.CENTER  );
                                    
            Subcategorias_Home.Home.ControleTabs.AddTabSemControleNovo( Subcategorias_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
            
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
