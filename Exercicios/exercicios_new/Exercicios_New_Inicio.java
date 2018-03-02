/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_new;

import assunto_new.BookInfoSubcategoria;
import categorias_new.BookInfoMateria;
import java.awt.Color;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import subcategoria_new.BookInfoCategoria;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Exercicios_New_Inicio {
        
    Exercicios_New Exercicios_New;//Materias_Home; 
    
    public Exercicios_New_Inicio( Exercicios_New Exercicios_New2 ) {
        
        Exercicios_New = Exercicios_New2;
        
        inicioCBS();
        inicio();
    }
    
    private void inicioCBS(){        
        new Thread() {   @Override public void run() { try { //Thread.sleep( 1 );         
            Color c = new Color( 255, 255, 255 );
        
            Exercicios_New.cbMateria     .setBackground( c );
            Exercicios_New.cbCategoria   .setBackground( c );
            Exercicios_New.cbSubcategoria.setBackground( c );
            Exercicios_New.cbAssunto     .setBackground( c );            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicioCBS(), \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start();       
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { //Thread.sleep( 1 ); 
        
            setarCBMateria(false, new exercicios.Exercicios());
                        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_New_Inicio" ); } } }.start();                 
    }
      
    //setar CB Matéria
    public void setarCBMateria(boolean alterar, exercicios.Exercicios Exercicios) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Exercicios_New.cbMateria.getItemCount() > 0 ) { Exercicios_New.cbMateria.removeAllItems(); }

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE MATERIA LIKE ?", materias.Materia.class );
            q.setParameter(1, "%"+""+"%");            
            List<materias.Materia> list = q.getResultList();
                                    
            for (int i = 0; i < list.size(); i++){ 
                Exercicios_New.cbMateria.addItem( new BookInfoMateria( 
                    list.get(i).getId(),list.get(i).getMateria()
                    )
                );    
            }
            
            if( alterar == true ) {
                
                for (int i = 0; i < Exercicios_New.cbMateria.getItemCount(); i++){
                
                    BookInfoMateria obj = (BookInfoMateria) Exercicios_New.cbMateria.getItemAt(i);
                    //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Categoria.getIdMateria(): " + Categoria.getIdMateria() );
                    if( obj.ID == Exercicios.getIdMateria() ){
                    
                        Exercicios_New.cbMateria.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            if( Exercicios_New.cbMateria.getItemCount() > 0 ) {
                BookInfoMateria obj = (BookInfoMateria) Exercicios_New.cbMateria.getSelectedItem();
                Exercicios_New.cbMateria.setToolTipText(obj.MATERIA);
            }else{ Exercicios_New.cbMateria.setToolTipText(""); }
        } catch( Exception e ){}                            
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Exercicios_New_Inicio" ); } } }.start(); 
    } 
    
    //setar CB Categoria
    public void setarCBCategoria(boolean alterar, exercicios.Exercicios Exercicios) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Exercicios_New.cbCategoria.getItemCount() > 0 ) { Exercicios_New.cbCategoria.removeAllItems(); }
            if( Exercicios_New.cbMateria.getItemCount() > 0 ) {
            
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA WHERE ID_MATERIA = ?", categorias.Categoria.class );
                q.setParameter( 1, Exercicios.getIdMateria() );            
                List<categorias.Categoria> list = q.getResultList();

                for (int i = 0; i < list.size(); i++){ 
                    Exercicios_New.cbCategoria.addItem( new BookInfoCategoria( 
                        list.get(i).getId(),list.get(i).getCategoria()
                        )
                    );    
                }
            
                if( alterar == true ) {
                
                    for (int i = 0; i < Exercicios_New.cbCategoria.getItemCount(); i++){
                
                        BookInfoCategoria obj = (BookInfoCategoria) Exercicios_New.cbCategoria.getItemAt(i);
                        //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Subcategoria.getIdCategoria(): " + Subcategoria.getIdCategoria() );
                        if( obj.ID == Exercicios.getIdCategoria() ){
                    
                            Exercicios_New.cbCategoria.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
        } catch( Exception e ){}    
                        
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Exercicios_New_Inicio" ); } } }.start(); 
    } 
    
    //setar CB Subcategoria
    public void setarCBSubcategoria(boolean alterar, exercicios.Exercicios Exercicios) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Exercicios_New.cbSubcategoria.getItemCount() > 0 ) { Exercicios_New.cbSubcategoria.removeAllItems(); }
            if( Exercicios_New.cbCategoria.getItemCount() > 0 ) {
                                                
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.SUBCATEGORIA WHERE ID_CATEGORIA = ?", subcategoria.Subcategoria.class );
                q.setParameter( 1, Exercicios.getIdCategoria() );            
                List<subcategoria.Subcategoria> list = q.getResultList();
                        
                for (int i = 0; i < list.size(); i++){ 
                    Exercicios_New.cbSubcategoria.addItem( new BookInfoSubcategoria( 
                        list.get(i).getId(),list.get(i).getSubcategoria()
                        )
                    );    
                }
            
                if( alterar == true ) {
                
                    for (int i = 0; i < Exercicios_New.cbSubcategoria.getItemCount(); i++){
                
                        BookInfoSubcategoria obj = (BookInfoSubcategoria) Exercicios_New.cbSubcategoria.getItemAt(i);
                        //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Subcategoria.getIdCategoria(): " + Subcategoria.getIdCategoria() );
                        if( obj.ID == Exercicios.getIdSubcategoria() ){
                    
                            Exercicios_New.cbSubcategoria.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
            
        } catch( Exception e ){}                           
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Exercicios_New_Inicio" ); } } }.start(); 
    } 
    
    //setar CB Assunto
    public void setarCBAssunto(boolean alterar, exercicios.Exercicios Exercicios) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Exercicios_New.cbAssunto.getItemCount() > 0 ) { Exercicios_New.cbAssunto.removeAllItems(); }
            if( Exercicios_New.cbSubcategoria.getItemCount() > 0 ) {
                                                
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.ASSUNTO WHERE ID_SUBCATEGORIA = ?", assunto.Assunto.class );
                q.setParameter( 1, Exercicios.getIdSubcategoria() );            
                List<assunto.Assunto> list = q.getResultList();
                        
                for (int i = 0; i < list.size(); i++){ 
                    Exercicios_New.cbAssunto.addItem( new BookInfoAssunto( 
                        list.get(i).getId(),list.get(i).getAssunto()
                        )
                    );    
                }
            
                if( alterar == true ) {
                
                    for (int i = 0; i < Exercicios_New.cbAssunto.getItemCount(); i++){
                
                        BookInfoAssunto obj = (BookInfoAssunto) Exercicios_New.cbAssunto.getItemAt(i);
                        //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Subcategoria.getIdCategoria(): " + Subcategoria.getIdCategoria() );
                        if( obj.ID == Exercicios.getId() ){
                    
                            Exercicios_New.cbAssunto.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
            
        } catch( Exception e ){}                           
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Exercicios_New_Inicio" ); } } }.start(); 
    } 
   
   //Salvar
   public void salvar( exercicios.Exercicios Exercicios ) {  
        if( Exercicios_New.btSalvar.isEnabled() ) {
            
            if( !Exercicios_New.tfEnderecoPergunta.getText().trim().equals("") ) {
                
                Exercicios.setPergunta     ( Exercicios_New.tfEnderecoPergunta.getText().trim() );
                Exercicios.setRespostacerta( respostaCerta() );
                Exercicios.setRespostahtml ( Exercicios_New.tfEnderecoResposta.getText().trim() );
                                
                if( Exercicios_New.cbMateria.getItemCount() > 0 ) {  
                    BookInfoMateria obj = (BookInfoMateria) Exercicios_New.cbMateria.getSelectedItem();
                
                    Exercicios.setIdMateria(obj.ID);
                    
                    if( Exercicios_New.cbCategoria.getItemCount() > 0 ) { 
                        BookInfoCategoria obj2 = (BookInfoCategoria) Exercicios_New.cbCategoria.getSelectedItem();
                        
                        Exercicios.setIdCategoria(obj2.ID);
                        
                        if( Exercicios_New.cbSubcategoria.getItemCount() > 0 ) {
                            BookInfoSubcategoria obj3 = (BookInfoSubcategoria) Exercicios_New.cbSubcategoria.getSelectedItem();
                            
                            Exercicios.setIdSubcategoria(obj3.ID);
                            
                            if( Exercicios_New.cbAssunto.getItemCount() > 0 ) {
                                BookInfoAssunto obj4 = (BookInfoAssunto) Exercicios_New.cbAssunto.getSelectedItem();
                                
                                Exercicios.setIdAssunto(obj4.ID);
                                
                                DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Exercicios, JPAUtil.em());
                                DAOGenericoJPA.gravanovoOUatualizar();
                            }
                            
                        }else{ semSubcategoria(); }
                        
                    }else{ semCategoria(); }
                    
                }else{ semMateria(); }
                                                
                Exercicios_New.btSalvar.setEnabled( false );
                Exercicios_New.tfEnderecoPergunta.setText("");
                Exercicios_New.Exercicios_Home.Inicio.cancelar();
            }
            else{
                JOPM JOptionPaneMod = new JOPM( 2, "Nome do Endereco da Pergunta, "
                        + "\nO Campo Endereco da Pergunta não pode ser nulo"
                        + "\nInforme o Endereco da Pergunta"
                        + "\n", "Endereco da Pergunta" );
                
                Exercicios_New.tfEnderecoPergunta.requestFocus();
            }
        }
    } 
   
   private String respostaCerta() {
       String retorno = "";
       
       if( Exercicios_New.rbA.isSelected() ){
           
           retorno = "A";
       } 
       else if( Exercicios_New.rbB.isSelected() ){
           
           retorno = "B";
       }
       else if( Exercicios_New.rbC.isSelected() ){
           
           retorno = "C";
       }
       else if( Exercicios_New.rbD.isSelected() ){
           
           retorno = "D";
       }
               
       return retorno;
   }
   
   public void semMateria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semMateria(), "
                        + "\nNenhuma matéria encontrada"
                        + "\nCadastre uma matéria"
                        + "\n", "Exercicios_New_Inicio" );
   }
   
   public void semCategoria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semCategoria(), "
                        + "\nNenhuma categoria encontrada"
                        + "\nCadastre uma categoria"
                        + "\n", "Exercicios_New_Inicio" );
   }
   
   public void semSubcategoria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semSubcategoria(), "
                        + "\nNenhuma subcategoria encontrada"
                        + "\nCadastre uma subcategoria"
                        + "\n", "Exercicios_New_Inicio" );
   }
    
}
