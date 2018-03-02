/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assunto_new;

import assunto.Controle_Assunto;
import categorias_new.BookInfoMateria;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.File;
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
public class Assunto_New_Inicio {
        
    Assunto_New Assunto_New;//Materias_Home; 
    
    public Assunto_New_Inicio( Assunto_New Assunto_New2 ) {
        
        Assunto_New = Assunto_New2;
        
        inicioCBS();
        inicio();
    }
    
    private void inicioCBS(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );         
            Color c = new Color( 255, 255, 255 );
        
            Assunto_New.cbMateria     .setBackground( c );
            Assunto_New.cbCategoria   .setBackground( c );
            Assunto_New.cbSubcategoria.setBackground( c );            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicioCBS(), \n"
                + e.getMessage() + "\n", "Exercicios_Home_Inicio" ); } } }.start();       
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Assunto_New_Inicio( Assunto_New Assunto_New2, assunto.Assunto Assunto ) {
        
        Assunto_New = Assunto_New2;
          
        setarDadosDoBancoNoJPanel( Assunto, false );
        
        setarCBMateria( true, Assunto );  
        setarCBCategoria( true, Assunto );
        setarCBSubcategoria( true, Assunto );
        //Eventos
        try{
            MouseListener[] MouseListener = Assunto_New.btSalvar.getMouseListeners(); for ( MouseListener MouseListener1 : MouseListener) {
                Assunto_New.btSalvar.removeMouseListener( MouseListener1 ); }
                Assunto_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() { @Override public void mousePressed(java.awt.event.MouseEvent evt) {
                                 
                salvar( Assunto_New.Assunto, true ); } });    
                
        }catch(Exception e ){} 
        
        Assunto_New.btSalvar.setEnabled(true);        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            setarCBMateria(false, new assunto.Assunto());
                        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();                 
    }
      
    //setar CB Matéria
    public void setarCBMateria(boolean alterar, assunto.Assunto Assunto) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Assunto_New.cbMateria.getItemCount() > 0 ) { Assunto_New.cbMateria.removeAllItems(); }

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE MATERIA LIKE ?", materias.Materia.class );
            q.setParameter(1, "%"+""+"%");            
            List<materias.Materia> list = q.getResultList();
                                    
            for (int i = 0; i < list.size(); i++){ 
                Assunto_New.cbMateria.addItem( new BookInfoMateria( 
                    list.get(i).getId(),list.get(i).getMateria()
                    )
                );    
            }
            
            if( alterar == true ) {
                
                for (int i = 0; i < Assunto_New.cbMateria.getItemCount(); i++){
                
                    BookInfoMateria obj = (BookInfoMateria) Assunto_New.cbMateria.getItemAt(i);
                    //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Categoria.getIdMateria(): " + Categoria.getIdMateria() );
                    if( obj.ID == Assunto.getIdMateria() ){
                    
                        Assunto_New.cbMateria.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
        } catch( Exception e ){}                            
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start(); 
    } 
    
    //setar CB Categoria
    public void setarCBCategoria(boolean alterar, assunto.Assunto Assunto) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Assunto_New.cbCategoria.getItemCount() > 0 ) { Assunto_New.cbCategoria.removeAllItems(); }
            if( Assunto_New.cbMateria.getItemCount() > 0 ) {
            
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA WHERE ID_MATERIA = ?", categorias.Categoria.class );
                q.setParameter( 1, Assunto.getIdMateria() );            
                List<categorias.Categoria> list = q.getResultList();

                for (int i = 0; i < list.size(); i++){ 
                    Assunto_New.cbCategoria.addItem( new BookInfoCategoria( 
                        list.get(i).getId(),list.get(i).getCategoria()
                        )
                    );    
                }
            
                if( alterar == true ) {
                
                    for (int i = 0; i < Assunto_New.cbCategoria.getItemCount(); i++){
                
                        BookInfoCategoria obj = (BookInfoCategoria) Assunto_New.cbCategoria.getItemAt(i);
                        //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Assunto.getIdCategoria(): " + Assunto.getIdCategoria() );
                        if( obj.ID == Assunto.getIdCategoria() ){
                    
                            Assunto_New.cbCategoria.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
        } catch( Exception e ){}    
                        
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start(); 
    } 
    
    //setar CB Assunto
    public void setarCBSubcategoria(boolean alterar, assunto.Assunto Assunto) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            if( Assunto_New.cbSubcategoria.getItemCount() > 0 ) { Assunto_New.cbSubcategoria.removeAllItems(); }
            if( Assunto_New.cbCategoria.getItemCount() > 0 ) {
                                                
                Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.SUBCATEGORIA WHERE ID_CATEGORIA = ?", subcategoria.Subcategoria.class );
                q.setParameter( 1, Assunto.getIdCategoria() );            
                List<subcategoria.Subcategoria> list = q.getResultList();
                        
                for (int i = 0; i < list.size(); i++){ 
                    Assunto_New.cbSubcategoria.addItem( new BookInfoSubcategoria( 
                        list.get(i).getId(),list.get(i).getSubcategoria()
                        )
                    );    
                }
            
                if( alterar == true ) {
                
                    for (int i = 0; i < Assunto_New.cbSubcategoria.getItemCount(); i++){
                
                        BookInfoSubcategoria obj = (BookInfoSubcategoria) Assunto_New.cbSubcategoria.getItemAt(i);
                        //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Assunto.getIdCategoria(): " + Assunto.getIdCategoria() );
                        if( obj.ID == Assunto.getIdSubcategoria() ){
                    
                            Assunto_New.cbSubcategoria.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
            
        } catch( Exception e ){}                           
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start(); 
    } 
   
   //Salvar
   public void salvar( assunto.Assunto Assunto, boolean alterar ) {
        if( Assunto_New.btSalvar.isEnabled() ) {
            
            if( !Assunto_New.tfNome.getText().trim().equals("") ) {

                if( Assunto_New.cbMateria.getItemCount() > 0 ) {  
                                        
                    if( Assunto_New.cbCategoria.getItemCount() > 0 ) { 
                                                
                        if( Assunto_New.cbSubcategoria.getItemCount() > 0 ) {
                            Assunto = pegarDadosDoJPanelParaSalvar( Assunto, alterar );
                            
                            Controle_Assunto t1 = new Controle_Assunto( "Verificar_PastaDaSubcategoria", alterar, Assunto, this, "", "", "", false, 0, 0, 0 ); t1.setName("Controle_Assunto"); t1.start(); 
                            
                        }else{ semSubcategoria(); }
                        
                    }else{ semCategoria(); }
                    
                }else{ semMateria(); }
            }
            else{
                JOPM JOptionPaneMod = new JOPM( 2, "Nome do assunto, "
                        + "\nO Campo nome do assunto não pode ser nulo"
                        + "\nInforme o nome do assunto"
                        + "\n", "Nome do Assunto" );
                
                Assunto_New.tfNome.requestFocus();
            }
        }
    } 
   
   public void semMateria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semMateria(), "
                        + "\nNenhuma matéria encontrada"
                        + "\nCadastre uma matéria"
                        + "\n", "Assunto_New_Inicio" );
   }
   
   public void semCategoria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semCategoria(), "
                        + "\nNenhuma categoria encontrada"
                        + "\nCadastre uma categoria"
                        + "\n", "Assunto_New_Inicio" );
   }
   
   public void semSubcategoria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semSubcategoria(), "
                        + "\nNenhuma subcategoria encontrada"
                        + "\nCadastre uma subcategoria"
                        + "\n", "Assunto_New_Inicio" );
   }
   
   public void confirmarSalvar( assunto.Assunto Assunto, boolean alterar ) {            
        if( verificarRepeticao( Assunto ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Assunto, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            
            if( alterar == false ) {
                Controle_Assunto t1 = new Controle_Assunto( "Criar_Assunto", alterar, Assunto, this, "", "", "", false, 0, 0, 0 ); t1.setName("Controle_Assunto"); t1.start();
            }
            else if( alterar == true ) {
                
                if( !copiarArquivoHtml.equals("") ){ String strOrig = copiarArquivoHtml;
                
                    copiarArquivoHtml = "";
                    Controle_Assunto t1 = new Controle_Assunto( "Copiar_Html", alterar, Assunto, this, strOrig, excluirArquivoHtmlAnterior, nomeAssuntoAnterior, true, idMateriaAnterior, idCategoriaAnterior, idSubcategoriaAnterior ); t1.setName("Controle_Assunto"); t1.start();           
                }
                else{
                                                            //Renomea Matéria Anterior
                    Controle_Assunto t1 = new Controle_Assunto( "Copiar_Html", alterar, Assunto, this, "", "", nomeAssuntoAnterior, false, idMateriaAnterior, idCategoriaAnterior, idSubcategoriaAnterior ); t1.setName("Controle_Assunto"); t1.start();  
                }
            }
            Assunto_New.Assunto_Home.Inicio.cancelar();
        }
        else{
            
            repetido();
        }
    }
   
   private void sem1() {
                JOPM JOPM = new JOPM( "EXCEÇÃO: " + "CATEGORIA\n"
                        ,"\nPARA SALVAR UMA NOVA CATEGORIA:"
                        +"\nO NOME INFORMADO DEVE TER NO MÍNIMO 4 LETRAS\n"
                        ,this.getClass().getName()
                );
   }
   
   private void repetido() {
                JOPM JOPM = new JOPM( "EXCEÇÃO: " + "NOME DA CATEGORIA\n"
                        ,"\nO NOME DA CATEGORIA INFORMADO JÁ EXISTE CADASTRADO"
                        +"\nINFORME UM NOME DE CATEGORIA AINDA NÃO CADASTRADO\n"
                        ,this.getClass().getName()
                );
   }
   
   private boolean verificarRepeticao( assunto.Assunto Assunto ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.ASSUNTO", assunto.Assunto.class );
            List<assunto.Assunto> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Assunto.getId() ){
                    
                    if( list.get(i).getAssunto().equals( Assunto.getAssunto() ) ){
                    
                        retorno = true;
                        break;                    
                    }
                }
            }

        }catch(Exception e ){} 
        
        return retorno;
    }
   
   String copiarArquivoHtml = "";
   String excluirArquivoHtmlAnterior = "";
   String nomeAssuntoAnterior = "";
   int    idMateriaAnterior = 0;
   int    idCategoriaAnterior = 0;
   int    idSubcategoriaAnterior = 0;
    private assunto.Assunto pegarDadosDoJPanelParaSalvar( assunto.Assunto Assunto, boolean alterar ) { 
                
        if( alterar == true ){
            
            try{ idMateriaAnterior        = Assunto.getIdMateria();       }catch(Exception e ){}
            try{ idCategoriaAnterior      = Assunto.getIdCategoria();     }catch(Exception e ){}
            try{ idSubcategoriaAnterior   = Assunto.getIdSubcategoria();  }catch(Exception e ){}
            try{ nomeAssuntoAnterior      = Assunto.getAssunto();         }catch(Exception e ){}
            
            ////////////////////////////////////////////////////////////////////
            try{ 
                    
                String str = "";
                try{ 
                        
                    if( !Assunto_New.tfPaHtml.getText().trim().equals("") ){
                            
                        File f = new File( Assunto_New.tfPaHtml.getText().trim() );
                            
                        if( f.exists() == true ){
                                
                            str = f.getName().trim(); 
                            
                            copiarArquivoHtml = Assunto_New.tfPaHtml.getText().trim();
                        }
                    }
                }catch(Exception e ){}
                    
                if( !str.equals("") ){
                        
                    excluirArquivoHtmlAnterior = Assunto.getAssuntopaginahtml();
                    Assunto.setAssuntopaginahtml( str );                        
                }
                    
            }catch(Exception e ){} 
            ////////////////////////////////////////////////////////////////////
        }
        else if( alterar == false ){
            
            idMateriaAnterior     = 0;
            idCategoriaAnterior   = 0;
            nomeAssuntoAnterior = "";
            
            ////////////////////////////////////////////////////////////////////
            Assunto.setAssuntopaginahtml( "modelo.html" );
        }  
        
        ////////////////////////////////////////////////////////////////////////
        try{ Assunto.setAssunto( Assunto_New.tfNome.getText().trim().toUpperCase() );                                                             }catch( Exception e ){}
        try{ BookInfoMateria       obj = (BookInfoMateria)      Assunto_New.cbMateria.getSelectedItem();      Assunto.setIdMateria(obj.ID);       }catch( Exception e ){}
        try{ BookInfoCategoria    obj2 = (BookInfoCategoria)    Assunto_New.cbCategoria.getSelectedItem();    Assunto.setIdCategoria(obj2.ID);    }catch( Exception e ){}
        try{ BookInfoSubcategoria obj3 = (BookInfoSubcategoria) Assunto_New.cbSubcategoria.getSelectedItem(); Assunto.setIdSubcategoria(obj3.ID); }catch( Exception e ){}
        ////////////////////////////////////////////////////////////////////////
        
        return Assunto;
    }
   
    public void setarDadosDoBancoNoJPanel( assunto.Assunto Assunto, boolean alterar ) {   
        
        try{ Assunto_New.tfNome.setText( Assunto.getAssunto() );                }catch( Exception e ){}
        try{ Assunto_New.tfPaHtml.setText( Assunto.getAssuntopaginahtml() );    }catch(Exception e ){}

    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Assunto_New.tfNome       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
