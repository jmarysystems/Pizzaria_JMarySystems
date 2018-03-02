/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientes;

import clientes_new.Clientes_New;
import clientes_search.Menu_Pesquisa_Clientes;
import clientes_search.Tabela_Pesquisa_BD_Clientes;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import utilidades.Conjunto_Botoes;
import utilidades.JOPM;
import venda_new.Venda_New;
import venda_search.Menu_Pesquisa_Venda;

/**
 *
 * @author pc
 */
public class Clientes_Home_Inicio {
        
    Conjunto_Botoes Conjunto_Botoes;
    Clientes_Home  Clientes_Home;//Materias_Home; 
    
    public Clientes_Home_Inicio( Clientes_Home Embalagem_Home2 ) {
        
        Clientes_Home = Embalagem_Home2;
        
        inicio();
    }
    
    //////////////////////////////////////////////////////
    public Clientes_Home_Inicio( Clientes_Home Clientes_Home2, JTabbedPane tabHome2 ) {
        
        Clientes_Home = Clientes_Home2;
        
        try { Thread.sleep( 1 ); 
        
            Clientes_Home.pnHome.setLayout( new BorderLayout() );    
        
            /**/Clientes_Home.tabHome = tabHome2;
            //////////////////
            Menu_Pesquisa_Clientes      Menu_Pesquisa                 = new Menu_Pesquisa_Clientes( Clientes_Home, tabHome2 );
            Tabela_Pesquisa_BD_Clientes Tabela_Pesquisa_BD_Clientes = new Tabela_Pesquisa_BD_Clientes( Clientes_Home );
            
            Menu_Pesquisa.tabela(Tabela_Pesquisa_BD_Clientes  );
            Tabela_Pesquisa_BD_Clientes.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Clientes, BorderLayout.CENTER  );
            ///////////////////
            
            /**/Clientes_Home.pnHome.add( jp               , BorderLayout.CENTER );    
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } 
    }
    ////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////
    public Clientes_Home_Inicio( Clientes_Home Clientes_Home2, Menu_Pesquisa_Venda Menu_Pesquisa_Venda2 ) {
        
        Clientes_Home = Clientes_Home2;
        
        try { Thread.sleep( 1 ); 
        
            Clientes_Home.pnHome.setLayout( new BorderLayout() );    
        
            /**/Clientes_Home.tabHome = Clientes_Home.Menu_Pesquisa_Venda.Venda_Home.tabHome;
            //////////////////
            Menu_Pesquisa_Clientes      Menu_Pesquisa                 = new Menu_Pesquisa_Clientes( Clientes_Home, Clientes_Home.Menu_Pesquisa_Venda );
            Tabela_Pesquisa_BD_Clientes Tabela_Pesquisa_BD_Clientes = new Tabela_Pesquisa_BD_Clientes( Clientes_Home );
            
            Menu_Pesquisa.tabela(Tabela_Pesquisa_BD_Clientes  );
            Tabela_Pesquisa_BD_Clientes.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Clientes, BorderLayout.CENTER  );
            ///////////////////
            
            /**/Clientes_Home.pnHome.add( jp               , BorderLayout.CENTER );    
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } 
    }
    ////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////
    public Clientes_Home_Inicio( Clientes_Home Clientes_Home2, Venda_New Venda_New2 ) {
        
        Clientes_Home = Clientes_Home2;
        
        try { Thread.sleep( 1 ); 
        
            Clientes_Home.pnHome.setLayout( new BorderLayout() );    
        
            /**/Clientes_Home.tabHome = Clientes_Home.Venda_New.Venda_Home.tabHome;
            //////////////////
            Menu_Pesquisa_Clientes      Menu_Pesquisa                 = new Menu_Pesquisa_Clientes( Clientes_Home, Clientes_Home.Venda_New );
            Tabela_Pesquisa_BD_Clientes Tabela_Pesquisa_BD_Clientes = new Tabela_Pesquisa_BD_Clientes( Clientes_Home );
            
            Menu_Pesquisa.tabela(Tabela_Pesquisa_BD_Clientes  );
            Tabela_Pesquisa_BD_Clientes.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Clientes, BorderLayout.CENTER  );
            ///////////////////
            
            /**/Clientes_Home.pnHome.add( jp               , BorderLayout.CENTER );    
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } 
    }
    ////////////////////////////////////////////////////////

        
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            iniciar();
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start(); 
                
    }
    
    private void iniciar(){

        Clientes_Home.pnHome.setLayout( new BorderLayout() );   
        
        Conjunto_Botoes = new Conjunto_Botoes( Clientes_Home.Home );
        eventoBotaoNovo();
        eventoBotaoCancelar();
        eventoBotaoPesquisar();
        
        Clientes_Home.pnHome.add( Conjunto_Botoes           , BorderLayout.NORTH  );
        Clientes_Home.pnHome.add(Clientes_Home.tabHome    , BorderLayout.CENTER );    
        
        addAbaPesquisa();
                 
    }  
    
    // Aba Novo 
    public void addAbaNovo(){      
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
           
            Clientes_Home.Home.ControleTabs.AddTabSemControleNovo(Clientes_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Clientes_New(Clientes_Home) );
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();         
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Clientes_Home.Home.ControleTabs.removerTabSemControleSelecionado(Clientes_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();     
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            Menu_Pesquisa_Clientes Menu_Pesquisa           = new Menu_Pesquisa_Clientes( Clientes_Home );
            Tabela_Pesquisa_BD_Clientes Tabela_Pesquisa_BD = new Tabela_Pesquisa_BD_Clientes( Clientes_Home );
            
            Menu_Pesquisa.tabela( Tabela_Pesquisa_BD  );
            Tabela_Pesquisa_BD.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD, BorderLayout.CENTER  );
                                    
            Clientes_Home.Home.ControleTabs.AddTabSemControleNovo(Clientes_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
        
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "addAbaPesquisa(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();                 
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
