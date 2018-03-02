/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientes_new;

import java.awt.event.MouseListener;
import java.util.List;
import javax.persistence.Query;
import javax.swing.text.MaskFormatter;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Clientes_New_Inicio {
        
    Clientes_New Clientes_New;//Materias_Home; 
    
    public Clientes_New_Inicio( Clientes_New Clientes_New2 ) {
        
        Clientes_New = Clientes_New2;

        inicio();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Clientes_New_Inicio( Clientes_New Clientes_New2, clientes.Clientes Clientes ) {
        
        Clientes_New = Clientes_New2;
          
        setarDadosDoBancoNoJPanel( Clientes );
        
        //Eventos
        try{
            MouseListener[] MouseListener = Clientes_New.btSalvar.getMouseListeners();
            for ( MouseListener MouseListener1 : MouseListener) {
                Clientes_New.btSalvar.removeMouseListener( MouseListener1 );
            }
        
            Clientes_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                 public void mousePressed(java.awt.event.MouseEvent evt) {

                    salvar(Clientes_New.Clientes, true );
                }
            });    
        }catch(Exception e ){} 
        Clientes_New.btSalvar.setEnabled(true);
        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            
                        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();                 
    }
    
    //Salvar
    public void salvar( clientes.Clientes Clientes, boolean alterar ) {  
        if( Clientes_New.btSalvar.isEnabled() ) {
            
            if( Clientes_New.tfNomeDaCategoriaDoProduto.getText().trim().length() > 1 ) {
                
                if( Clientes_New.tfEndereco.getText().trim().length() > 1 ) {
                    
                    if( Clientes_New.tfNumero.getText().trim().length() > 1 ) {
                        
                        if( Clientes_New.tfTelefone.getText().trim().length() > 1 ) {
                        
                           confirmarSalvar( Clientes, alterar ); 
                        }
                        else{ sem2(); }
                    }
                    else{ sem2(); }
                }
                else{ sem2(); }
                
            }
            else{ sem1(); }
        }
    } 
    
    public void confirmarSalvar( clientes.Clientes Clientes, boolean alterar ) { 
        Clientes = pegarDadosDoJPanelParaSalvar( Clientes );
        
        if( verificarRepeticao( Clientes ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Clientes, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            Clientes_New.Clientes_Home.Inicio.cancelar();
        }
        else{
            
            repetido();
        }
    }
   
   private void sem1() {
       JOPM JOptionPaneMod = new JOPM( 2, "NOME DO CLIENTE, "
                        + "\nO Campo NOME DO CLIENTE não pode ter menos que 4 caracteres"
                        + "\nInforme um NOME DO CLIENTE com no mínimo 4 caracteres"
                        + "\n", "NOME DO CLIENTE" );
   }
   
   private void sem2() {
       JOPM JOptionPaneMod = new JOPM( 2, "PARA CADASTRAR UM CLIENTE, "
                        + "\nO Campo NOME DO CLIENTE não pode ter menos que 4 caracteres"
                        + "\nO Campo ENDEREÇO DO CLIENTE não pode ter menos que 2 caracteres"
                        + "\nO Campo NÚMERO DO ENDEREÇO DO CLIENTE não pode ter menos que 2 caracteres"
                        + "\nO Campo TELEFONE DO CLIENTE não pode Ser NULO"
                        + "\n", "PARA CADASTRAR UM CLIENTE" );
   }
   
   private void repetido() {
       JOPM JOptionPaneMod = new JOPM( 2, "TELEFONE JÁ CADASTRADO PARA OUTRO CLIENTE, "
                        + "\nO TELEFONE DO CLIENTE informado já existe cadastrado"
                        + "\nInforme um NÚMERO DE TELEFONE ainda não cadastrado"
                        + "\n", "NÚMERO DE TELEFONE DO CLIENTE" );
   }
   
   private boolean verificarRepeticao( clientes.Clientes Clientes ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CLIENTES", clientes.Clientes.class );
            List<clientes.Clientes> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Clientes.getId() ){
                    
                    if( list.get(i).getTelefone().equals( Clientes.getTelefone() ) ){
                    
                        retorno = true;
                        break;                    
                    }
                }
            }

        }catch(Exception e ){} 
        
        return retorno;
    }
   
    private clientes.Clientes pegarDadosDoJPanelParaSalvar( clientes.Clientes Clientes ) {  
        
        try{ Clientes.setNome( Clientes_New.tfNomeDaCategoriaDoProduto.getText().trim().toUpperCase() ); }catch(Exception e ){}             
        try{ Clientes.setEndereco( Clientes_New.tfEndereco.getText().trim().toUpperCase() ); }catch(Exception e ){} 
        try{ Clientes.setNumero( Clientes_New.tfNumero.getText().trim().toUpperCase() ); }catch(Exception e ){} 
        
        try{ Clientes.setEmail( Clientes_New.tfEmail.getText().trim().toUpperCase() ); }catch(Exception e ){}
        try{ Clientes.setPontodereferencia( Clientes_New.tfPontodereferencia.getText().trim().toUpperCase() ); }catch(Exception e ){}
        try{ Clientes.setTelefone( Clientes_New.tfTelefone.getText().trim().toUpperCase() ); }catch(Exception e ){}
        
        try{ Clientes.setObservacao( Clientes_New.tfObs.getText().trim().toUpperCase() ); }catch(Exception e ){}
        
        return Clientes;
    }
    
    public void setarDadosDoBancoNoJPanel( clientes.Clientes Clientes ) {          
        try{
            
            try{ Clientes_New.tfNomeDaCategoriaDoProduto.setText( Clientes.getNome() ); }catch(Exception e ){}             
            try{ Clientes_New.tfEndereco.setText                ( Clientes.getEndereco() ); }catch(Exception e ){} 
            try{ Clientes_New.tfNumero.setText                  ( Clientes.getNumero() ); }catch(Exception e ){} 
        
            try{ Clientes_New.tfEmail.setText                   ( Clientes.getEmail() ); }catch(Exception e ){}
            try{ Clientes_New.tfPontodereferencia.setText       ( Clientes.getPontodereferencia() ); }catch(Exception e ){}
            
            // Telefone
            try{ 
                MaskFormatter mascaraTelefone = new MaskFormatter("+ ## ( ## ) #### - ####");
                mascaraTelefone.setValidCharacters("0123456789");
                
                Clientes_New.tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory( mascaraTelefone ) ); 
                
                String str = Clientes.getTelefone().replace("+", "").replace("(", "").replace(")", "").replace("-", "");
                //System.out.println( "Telefone: " + str );
                
                Clientes_New.tfTelefone.setText( str ); 
            }catch(Exception e ){}
            // Telefone
        
            try{ Clientes_New.tfObs.setText                     ( Clientes.getObservacao() ); }catch(Exception e ){}
                    
        }catch(Exception e ){} 
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Clientes_New.tfNomeDaCategoriaDoProduto       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
