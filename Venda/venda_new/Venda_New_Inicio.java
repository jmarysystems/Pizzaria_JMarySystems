/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package venda_new;

import clientes.Clientes;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import produtos.Produtos;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Venda_New_Inicio {
        
    Venda_New Venda_New;//Materias_Home; 
    
    public Venda_New_Inicio( Venda_New Venda_New2 ) {
        
        Venda_New = Venda_New2;

        inicio();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Venda_New_Inicio( Venda_New Venda_New2, venda.Venda Venda2, List<venda.Produtosdavenda> list_vendaprodutos2 ) {
        
        Venda_New = Venda_New2;
          
        setarDadosDoBancoNoJPanel(Venda_New.Venda, Venda_New.list_vendaprodutos );
        
        //Eventos
        try{
            MouseListener[] MouseListener = Venda_New.btSalvar.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Venda_New.btSalvar.removeMouseListener( MouseListener1 );
            }
        
            Venda_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    salvar(Venda_New.Venda, Venda_New.list_vendaprodutos, true );
                }
            });    
        }catch(Exception e ){} 
        Venda_New.btSalvar.setEnabled(true);
        
    }
    ///////////////////////////////////////////////////////////////////////////
        
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                                    
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"+ e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();                 
    }
    
    
    //Salvar
    public void salvar( venda.Venda Venda, List<venda.Produtosdavenda> list, boolean alterar ) {
        //if( Venda_New.btSalvar.isEnabled() ) {
            
            if( !Venda_New.tfClientes.getText().trim().equals( "" )  ){
                
                if( Venda_New.Tabela_New_Pesquisa.tmPesquisa.getRowCount() > 0  ){
                    
                    confirmarSalvar( Venda, list, alterar );
                }
                else{ sem2(); }
                
            }
            else{ sem1(); }
        //}
    } 
            
    public void confirmarSalvar( venda.Venda Venda, List<venda.Produtosdavenda> list, boolean alterar ) {
        Venda = pegarDadosDoJPanelParaSalvar1( Venda, alterar );
        
        if( verificarRepeticao( Venda ) == false ){
            
            venda.Venda VendaSalvo = null;
            try{
                
                DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA( Venda, JPAUtil.em()); 
                VendaSalvo = DAOGenericoJPA.gravanovoOUatualizarVenda( Venda );
                                
                pegarDadosDoJPanelParaSalvar2( VendaSalvo, list, alterar );
                
            }catch( Exception e ){}
            
            Venda_New.Venda_Home.Inicio.cancelar();
            
            try{ 
                int id = VendaSalvo.getId();
                if( id > 0 ) {
                    Venda_New.imprimirXX( VendaSalvo.getId() );
                } 
            }catch( Exception e ){}
            
        } else{ repetido(); }
    }
   
   private void sem1() {
       JOPM JOptionPaneMod = new JOPM( 2, "FORNECEDOR, "
                        + "\nO FORNECEDOR não foi selecionado "
                        + "\nSelecine um FORNECEDOR para continuar"
                        + "\n", "FORNECEDOR" );
   }
   
   private void sem2() {
       JOPM JOptionPaneMod = new JOPM( 2, "PRODUTO, "
                        + "\nNenhum PRODUTO foi Adicionado ao Gestor"
                        + "\nAdicione ao menos um PRODUTO para continuar"
                        + "\n", "PRODUTO" );
   }
   
   private void repetido() {
       JOPM JOptionPaneMod = new JOPM( 2, "PRODUTO JÁ CADASTRADO PARA O FORNECEDOR, "
                        + "\nO PRODUTO informado já existe cadastrado para este fornecedor"
                        + "\nInforme um PRODUTO ainda não cadastrado para o fornecedor"
                        + "\n", "PRODUTO JÁ CADASTRADO PARA O FORNECEDOR" );
   }
   
   private boolean verificarRepeticao( venda.Venda Venda ) {  
       boolean retorno = false;
        try{
           
        }catch(Exception e ){} 
        
        return retorno;
    }
   
    private venda.Venda pegarDadosDoJPanelParaSalvar1( venda.Venda Venda, boolean alterar ) {          
        try{
       
            try{ 
                float v1 = Venda_New.vTotal;
                String v2 = String.valueOf( v1 );
                Venda.setTotal( Double.parseDouble( v2 ) );    
            }catch(Exception e ){}
            
            
            if( alterar == false ){
                
                GregorianCalendar gc = new GregorianCalendar();
                Date dataHoje = gc.getTime();
                
                Venda.setData             ( dataHoje );
            }
            
            Venda.setIdClientes(Venda_New.Clientes.getId() );
                      
        }catch(Exception e ){} 
        
        return Venda;
    }
    
    private List<venda.Produtosdavenda> pegarDadosDoJPanelParaSalvar2( venda.Venda Venda, List<venda.Produtosdavenda> list, boolean alterar ) {          
        try{

            for (int i = 0; i < Venda_New.Tabela_New_Pesquisa.tmPesquisa.getRowCount(); i++){
                    
                pegarDadosDoJPanelParaSalvar22( i, Venda, list, alterar );
            }                           
                      
        }catch(Exception e ){} 
        
        return list;
    }
    
    private List<venda.Produtosdavenda> pegarDadosDoJPanelParaSalvar22( int i, venda.Venda Venda, List<venda.Produtosdavenda> list, boolean alterar ) {          
        try{ 
                   
            venda.Produtosdavenda ProdutosdavendaNew = new venda.Produtosdavenda();
            
            //ID_PRODUTOSDAVENDA
            if( alterar == true ){
                try{ 
                    int id_VendaProdutosX = (int) Venda_New.Tabela_New_Pesquisa.tbPesquisa.getValueAt( i, 0 );
                    ProdutosdavendaNew.setId( id_VendaProdutosX ); 
                }catch(Exception e ){}            
            }
            //ID_PRODUTOSDAVENDA
            
            //PRODUTO X  --- AO CRIAR UM NOVO VISUALIZA-SE O ID DO PRODUTO MAIS AO ALTERAR É MOSTRADO O ID DO GESTOR DE COMPRAS
            Produtos Produtos = new Produtos();
            try{            
                String codigoProdutoX = (String) Venda_New.Tabela_New_Pesquisa.tbPesquisa.getValueAt( i, 1 );
                
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.PRODUTOS WHERE CODIGO LIKE ?", Produtos.class );
                q.setParameter( 1, codigoProdutoX.trim() );   
                List<produtos.Produtos> list6 = q.getResultList();
                for (int h = 0; h < list6.size(); h++){
                    Produtos = list6.get(h);
                }
            }catch(Exception e ){ e.printStackTrace(); System.out.println("PRODUTO X - " + Venda_New.Tabela_New_Pesquisa.tbPesquisa.getValueAt( i, 1 ) ); }
            //PRODUTO X
            //PRODUTO X
                   
            //PRODUTO 
            try{ ProdutosdavendaNew.setIdProdutos(Produtos.getId() );               }catch(Exception e ){}
            try{ ProdutosdavendaNew.setIdVenda(Venda.getId() );    }catch(Exception e ){}
            System.out.println( "ProdutosdavendaNew.getId() - " + ProdutosdavendaNew.getId() );
            System.out.println( "ProdutosdavendaNew.getIdProdutos() - " + ProdutosdavendaNew.getIdProdutos() );
            System.out.println( "ProdutosdavendaNew.getIdProdutos() - " + ProdutosdavendaNew.getIdVenda() );
            //PRODUTO                
              
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA( ProdutosdavendaNew, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
                      
        }catch(Exception e ){ e.printStackTrace(); } 
        
        return list;
    }

    public void setarDadosDoBancoNoJPanel( venda.Venda Venda, List<venda.Produtosdavenda> list_vendaprodutos ) {          
        try{
            
            Venda_New.Clientes.setId( Venda.getIdClientes() );  
            
            Venda_New.tfTotal.setText( String.valueOf( Venda.getTotal() ) );
            
            Venda_New.Tabela_New_Pesquisa.mostrarLista( list_vendaprodutos );
            
            try{
                ////////////////////////////////////////////////////////////////////
                Clientes Clientes = new Clientes();

                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CLIENTES WHERE ID = ?", Clientes.class );
                q.setParameter(1, Venda.getIdClientes() );   
                    
                List<clientes.Clientes> list = q.getResultList();
                    
                for (int i = 0; i < list.size(); i++){
                    Clientes = list.get(i);
                }
            
                Venda_New.tfClientes.setText( Clientes.getNome() );
                ///////////////////////////////////////////////////////////////////
            }catch(Exception e ){} 
      
        }catch(Exception e ){} 
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            //Produto_Por_Fornecedor_New.tfDescricaoDoProduto       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
