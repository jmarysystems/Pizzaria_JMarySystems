/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produtos_new;

import java.awt.event.MouseListener;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Produtos_New_Inicio {
        
    Produtos_New Produtos_New;//Materias_Home; 
    
    public Produtos_New_Inicio( Produtos_New Produtos_New2 ) {
        
        Produtos_New = Produtos_New2;

        inicio();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Produtos_New_Inicio( Produtos_New Produtos_New2, produtos.Produtos Produtos ) {
        
        Produtos_New = Produtos_New2;
          
        setarDadosDoBancoNoJPanel( Produtos );
        
        //Eventos
        try{
            MouseListener[] MouseListener = Produtos_New.btSalvar.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Produtos_New.btSalvar.removeMouseListener( MouseListener1 );
            }
        
            Produtos_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    salvar(Produtos_New.Produtos, true );
                }
            });    
        }catch(Exception e ){} 
        Produtos_New.btSalvar.setEnabled(true);
        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            
                        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();                 
    }
    
    //Salvar
    public void salvar( produtos.Produtos Produtos, boolean alterar ) {  
        if( Produtos_New.btSalvar.isEnabled() ) {
            
            if( Produtos_New.tfCodigo.getText().trim().length() > 1 ) {
                
                if( Produtos_New.tfNome.getText().trim().length() > 1 ) {
                
                    if( Produtos_New.tfValor.getText().trim().length() > 1 ) {
                        
                       confirmarSalvar( Produtos, alterar );  
                    }
                    else{ sem1(); }
                
                }
                else{ sem1(); }                
            }
            else{ sem1(); }
        }
    } 
    
    public void confirmarSalvar( produtos.Produtos Produtos, boolean alterar ) { 
        Produtos = pegarDadosDoJPanelParaSalvar( Produtos );
        
        if( verificarRepeticao( Produtos ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Produtos, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            Produtos_New.Produtos_Home.Inicio.cancelar();
        }
        else{
            
            repetido();
        }
    }
   
   private void sem1() {
       JOPM JOptionPaneMod = new JOPM( 2, "PARA CADASTRAR UM PRODUTO, "
                        + "\nO Campo CÓDIGO DO PRODUTO não pode ter menos que 2 caracteres"
                        + "\nO Campo DESCRIÇAO DO PRODUTO não pode ter menos que 2 caracteres"
                        + "\nO Campo VALOR DO PRODUTO não pode ser nulo"
                        + "\n", "PARA CADASTRAR UM PRODUTO" );
   }
   
   private void repetido() {
       JOPM JOptionPaneMod = new JOPM( 2, "CÓDIGO DO PRODUTO, "
                        + "\nO CÓDIGO DO PRODUTO informado já existe cadastrado"
                        + "\nInforme um CÓDIGO DO PRODUTO ainda não cadastrado"
                        + "\n", "CÓDIGO DO PRODUTO" );
   }
   
   private boolean verificarRepeticao( produtos.Produtos Produtos ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.PRODUTOS", produtos.Produtos.class );
            List<produtos.Produtos> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Produtos.getId() ){
                    
                    if( list.get(i).getCodigo().equals( Produtos.getCodigo() ) ){
                    
                        retorno = true;
                        break;                    
                    }
                }
            }

        }catch(Exception e ){} 
        
        return retorno;
    }
   
    private produtos.Produtos pegarDadosDoJPanelParaSalvar( produtos.Produtos Produtos ) {          
                    
        try{ Produtos.setCodigo( Produtos_New.tfCodigo.getText().trim().toUpperCase() ); }catch(Exception e ){}
        try{ Produtos.setNome  ( Produtos_New.tfNome.getText().trim().toUpperCase() ); }catch(Exception e ){} 
        
        // Valor Produto
        try{ 
            Produtos.setCusto ( Double.parseDouble( Produtos_New.tfValor.getText().trim() ) ); 
        }catch(Exception e ){} 
        // Valor Produto
                
        return Produtos;
    }
    
    public void setarDadosDoBancoNoJPanel( produtos.Produtos Produtos ) {          
            
        try{ Produtos_New.tfCodigo.setText     ( Produtos.getCodigo()  ); }catch(Exception e ){}
        try{ Produtos_New.tfNome.setText       ( Produtos.getNome()    ); }catch(Exception e ){} 
        
        // Valor Produto
        try{ 
            Produtos_New.tfValor.setText( String.valueOf( Produtos.getCusto() ) );
        }catch(Exception e ){} 
        // Valor Produto            
            
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Produtos_New.tfNome       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
