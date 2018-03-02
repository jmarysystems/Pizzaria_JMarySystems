/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package venda;

import clientes.Clientes;
import clientes.Clientes_Home;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import utilidades.Conjunto_Botoes;
import utilidades.JOPM;
import venda_new.Venda_New;
import venda_search.Menu_Pesquisa_Venda;
import venda_search.Tabela_Pesquisa_BD_Venda;

/**
 *
 * @author pc
 */
public class Venda_Home_Inicio {
        
    Conjunto_Botoes   Conjunto_Botoes;
    Venda_Home       Venda_Home;//Materias_Home; 
    
    public Venda_Home_Inicio( Venda_Home Venda_Home2 ) {
        
        Venda_Home = Venda_Home2;
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            Venda_Home.pnHome.setLayout( new BorderLayout() );  
            
            Conjunto_Botoes = new Conjunto_Botoes( Venda_Home.Home );
            eventoBotaoNovo();
            eventoBotaoCancelar();
            eventoBotaoPesquisar();
            
            Venda_Home.pnHome.add( Conjunto_Botoes        , BorderLayout.NORTH  );
            Venda_Home.pnHome.add(Venda_Home.tabHome    , BorderLayout.CENTER );    
            //addAbaPesquisa();
            addAbaNovo();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start(); 
    }
    
    //////////////////////////////////////////////////////
    public Venda_Home_Inicio( Venda_Home Venda_Home2, JTabbedPane tabHome2, Clientes Clientes ) {
        
        Venda_Home = Venda_Home2;
        
        try { Thread.sleep( 1 ); 
        
            Venda_Home.pnHome.setLayout( new BorderLayout() );    
        
            /**/Venda_Home.tabHome = tabHome2;
            //////////////////
            Menu_Pesquisa_Venda      Menu_Pesquisa                 = new Menu_Pesquisa_Venda( Venda_Home );
            Tabela_Pesquisa_BD_Venda Tabela_Pesquisa_BD_Clientes = new Tabela_Pesquisa_BD_Venda( Venda_Home );
            
            Menu_Pesquisa.tabela(Tabela_Pesquisa_BD_Clientes  );
            Tabela_Pesquisa_BD_Clientes.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Clientes, BorderLayout.CENTER  );
            ///////////////////
            
            Venda_New Venda_New = new Venda_New(Venda_Home, Clientes);
            /**/Venda_Home.pnHome.add( Venda_New               , BorderLayout.CENTER );   //jp 
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } 
    }
    ////////////////////////////////////////////////////////
    
    // Aba Novo 
    public void addAbaNovo(){      
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 

            Venda_Home.Home.ControleTabs.AddTabSemControleNovo(Venda_Home.tabHome, "Selecionar Cliente", "/utilidades_imagens/novo.gif", new Clientes_Home( Venda_Home.Home, Venda_Home.tabHome ) );
            //Venda_Home.Home.ControleTabs.AddTabSemControleNovo(Venda_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Venda_New(Venda_Home) );
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();         
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Venda_Home.Home.ControleTabs.removerTabSemControleSelecionado(Venda_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();     
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            Menu_Pesquisa_Venda      Menu_Pesquisa      = new Menu_Pesquisa_Venda( Venda_Home );
            Tabela_Pesquisa_BD_Venda Tabela_Pesquisa_BD = new Tabela_Pesquisa_BD_Venda( Venda_Home );
            
            Menu_Pesquisa.tabela     ( Tabela_Pesquisa_BD  );
            Tabela_Pesquisa_BD.tabela( Menu_Pesquisa       );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD, BorderLayout.CENTER  );
                                    
            Venda_Home.Home.ControleTabs.AddTabSemControleNovo(Venda_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
         
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaPesquisa(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();                 
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
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

                    // if( Usuario_Permissoes.booCadastrargestordecompras( Usuario_Logado.ID ) == true ) {
                         
                         addAbaNovo();
                    // }     
                    // else{
                    //     JOPM JOPM = new JOPM( 2, "USUÁRIO SEM AUTORIZAÇÂO, \n"+ "O USUÁRIO LOGADO NÃO TEM PERMISSÃO PARA REALIZAR ESTA AÇÃO" + "\n", this.getClass().getSimpleName() );
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
