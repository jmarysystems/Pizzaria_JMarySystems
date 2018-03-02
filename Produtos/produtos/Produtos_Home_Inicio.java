/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produtos;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import produtos_new.Produtos_New;
import produtos_search.Menu_Pesquisa_Produtos;
import produtos_search.Tabela_Pesquisa_BD_Produtos;
import utilidades.Conjunto_Botoes;
import utilidades.JOPM;
import venda_new.Venda_New;

/**
 *
 * @author pc
 */
public class Produtos_Home_Inicio {
        
    Conjunto_Botoes Conjunto_Botoes;
    Produtos_Home  Produtos_Home;//Materias_Home; 
    
    public Produtos_Home_Inicio( Produtos_Home Produtos_Home2 ) {
        
        Produtos_Home = Produtos_Home2;
        
        inicio();
    }
    
    //////////////////////////////////////////////////////
    public Produtos_Home_Inicio( Produtos_Home Produtos_Home2, Venda_New Venda_New2 ) {
        
        Produtos_Home = Produtos_Home2;
        
        try { Thread.sleep( 1 ); 
        
            Produtos_Home.pnHome.setLayout( new BorderLayout() );    
        
            /**/Produtos_Home.tabHome = Produtos_Home.Venda_New.Venda_Home.tabHome;
            //////////////////
            Menu_Pesquisa_Produtos      Menu_Pesquisa                 = new Menu_Pesquisa_Produtos( Produtos_Home, Produtos_Home.Venda_New );
            Tabela_Pesquisa_BD_Produtos Tabela_Pesquisa_BD_Fornecedor = new Tabela_Pesquisa_BD_Produtos( Produtos_Home );
            
            Menu_Pesquisa.tabela(Tabela_Pesquisa_BD_Fornecedor  );
            Tabela_Pesquisa_BD_Fornecedor.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD_Fornecedor, BorderLayout.CENTER  );
            ///////////////////
            
            /**/Produtos_Home.pnHome.add( jp               , BorderLayout.CENTER );    
            
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

        Produtos_Home.pnHome.setLayout( new BorderLayout() );   
        
        Conjunto_Botoes = new Conjunto_Botoes( Produtos_Home.Home );
        eventoBotaoNovo();
        eventoBotaoCancelar();
        eventoBotaoPesquisar();
        
        Produtos_Home.pnHome.add( Conjunto_Botoes           , BorderLayout.NORTH  );
        Produtos_Home.pnHome.add(Produtos_Home.tabHome    , BorderLayout.CENTER );    
        
        addAbaPesquisa();
                 
    }  
    
    // Aba Novo 
    public void addAbaNovo(){      
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
           
            Produtos_Home.Home.ControleTabs.AddTabSemControleNovo(Produtos_Home.tabHome, "Novo", "/utilidades_imagens/novo.gif", new Produtos_New(Produtos_Home) );
        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaNovo, \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();         
    }
    
    // Cancelar Aba Selecionada
    public void cancelar() {                                           
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );                   
            
            Produtos_Home.Home.ControleTabs.removerTabSemControleSelecionado(Produtos_Home.tabHome );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "cancelar(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();     
    }
    
    // Aba Pesquisar
    public void addAbaPesquisa(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            Menu_Pesquisa_Produtos Menu_Pesquisa           = new Menu_Pesquisa_Produtos( Produtos_Home );
            Tabela_Pesquisa_BD_Produtos Tabela_Pesquisa_BD = new Tabela_Pesquisa_BD_Produtos( Produtos_Home );
            
            Menu_Pesquisa.tabela( Tabela_Pesquisa_BD  );
            Tabela_Pesquisa_BD.tabela( Menu_Pesquisa );
                                             
            JPanel jp = new JPanel();
            jp.setLayout( new BorderLayout() );  
            jp.add      ( Menu_Pesquisa, BorderLayout.NORTH  );
            jp.add      ( Tabela_Pesquisa_BD, BorderLayout.CENTER  );
                                    
            Produtos_Home.Home.ControleTabs.AddTabSemControleNovo(Produtos_Home.tabHome, "Pesquisar", "/utilidades_imagens/pesquisar.gif", jp );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "addAbaPesquisa(), \n"
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
