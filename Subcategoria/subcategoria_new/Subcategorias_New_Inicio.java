/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subcategoria_new;

import categorias_new.BookInfoMateria;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import subcategoria.Controle_Subcategoria;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Subcategorias_New_Inicio {
        
    Subcategorias_New Subcategorias_New;//Materias_Home; 
    
    public Subcategorias_New_Inicio( Subcategorias_New Subcategorias_New2 ) {
        
        Subcategorias_New = Subcategorias_New2;
        
        inicioCBS();
        inicio();
    }
    
    private void inicioCBS(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );         
            Color c = new Color( 255, 255, 255 );
        
            Subcategorias_New.cbMateria     .setBackground( c );
            Subcategorias_New.cbCategoria   .setBackground( c );            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicioCBS(), \n"
                + e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();       
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Subcategorias_New_Inicio( Subcategorias_New Subcategorias_New2, subcategoria.Subcategoria Subcategoria ) {
        
        Subcategorias_New = Subcategorias_New2;
          
        setarDadosDoBancoNoJPanel( Subcategoria, false );
        
        setarCBMateria( true, Subcategoria );  
        setarCBCategoria( true, Subcategoria );
        //Eventos
        try{
            MouseListener[] MouseListener = Subcategorias_New.btSalvar.getMouseListeners(); for ( MouseListener MouseListener1 : MouseListener) {
                Subcategorias_New.btSalvar.removeMouseListener( MouseListener1 ); }
                Subcategorias_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() { @Override public void mousePressed(java.awt.event.MouseEvent evt) {
                                 
                salvar( Subcategorias_New.Subcategoria, true ); } });    
                
        }catch(Exception e ){} 
        
        Subcategorias_New.btSalvar.setEnabled(true);        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            setarCBMateria(false, new subcategoria.Subcategoria());
                        
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Subcategorias_New_Inicio" ); } } }.start();                 
    }
      
    //setar CB Matéria
    public void setarCBMateria(boolean alterar, subcategoria.Subcategoria Subcategoria) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE MATERIA LIKE ?", materias.Materia.class );
            q.setParameter(1, "%"+""+"%");            
            List<materias.Materia> list = q.getResultList();
            
            if( Subcategorias_New.cbMateria.getItemCount() > 0 ) { Subcategorias_New.cbMateria.removeAllItems(); }
            
            for (int i = 0; i < list.size(); i++){ 
                Subcategorias_New.cbMateria.addItem( new BookInfoMateria( 
                    list.get(i).getId(),list.get(i).getMateria()
                    )
                );    
            }
            
            if( alterar == true ) {
                
                for (int i = 0; i < Subcategorias_New.cbMateria.getItemCount(); i++){
                
                    BookInfoMateria obj = (BookInfoMateria) Subcategorias_New.cbMateria.getItemAt(i);
                    //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Categoria.getIdMateria(): " + Categoria.getIdMateria() );
                    if( obj.ID == Subcategoria.getIdMateria() ){
                    
                        Subcategorias_New.cbMateria.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
        } catch( Exception e ){}    
    } 
    
    //setar CB Matéria
    public void setarCBCategoria(boolean alterar, subcategoria.Subcategoria Subcategoria) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA WHERE ID_MATERIA = ?", categorias.Categoria.class );
            q.setParameter( 1, Subcategoria.getIdMateria() );            
            List<categorias.Categoria> list = q.getResultList();
            
            if( Subcategorias_New.cbCategoria.getItemCount() > 0 ) { Subcategorias_New.cbCategoria.removeAllItems(); }
            
            for (int i = 0; i < list.size(); i++){ 
                Subcategorias_New.cbCategoria.addItem( new BookInfoCategoria( 
                    list.get(i).getId(),list.get(i).getCategoria()
                    )
                );    
            }
            
            if( alterar == true ) {
                
                for (int i = 0; i < Subcategorias_New.cbCategoria.getItemCount(); i++){
                
                    BookInfoCategoria obj = (BookInfoCategoria) Subcategorias_New.cbCategoria.getItemAt(i);
                    //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Subcategoria.getIdCategoria(): " + Subcategoria.getIdCategoria() );
                    if( obj.ID == Subcategoria.getIdCategoria() ){
                    
                        Subcategorias_New.cbCategoria.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
        } catch( Exception e ){}    
                        
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start(); 
    } 
   
   //Salvar
   public void salvar( subcategoria.Subcategoria Subcategoria, boolean alterar ) {  
        if( Subcategorias_New.btSalvar.isEnabled() ) {
            
            if( !Subcategorias_New.tfNome.getText().trim().equals("") ) {
                
                if( Subcategorias_New.cbMateria.getItemCount() > 0 ) {  
                                        
                    if( Subcategorias_New.cbCategoria.getItemCount() > 0 ) { 
                                                
                        Controle_Subcategoria t1 = new Controle_Subcategoria( "Verificar_PastaDaCategoria", alterar, Subcategoria , this, "", "", "", false, 0, 0 ); t1.setName("Controle_Subcategoria"); t1.start(); 
                    }else{ semCategoria(); }
                    
                }else{ semMateria(); }
            }
            else{
                JOPM JOptionPaneMod = new JOPM( 2, "Nome da subcategoria, "
                        + "\nO Campo nome da subcategoria não pode ser nulo"
                        + "\nInforme o nome da subcategoria"
                        + "\n", "Nome da Subcategoria" );
                
                Subcategorias_New.tfNome.requestFocus();
            }
        }
    } 
   
   public void semCategoria() {
       JOPM JOptionPaneMod = new JOPM( 2, "semCategoria(), "
                        + "\nNenhuma categoria encontrada"
                        + "\nCadastre uma categoria"
                        + "\n", "Subcategorias_New_Inicio" );
   }
   
   public void confirmarSalvar( subcategoria.Subcategoria Subcategoria, boolean alterar ) {  
        Subcategoria = pegarDadosDoJPanelParaSalvar( Subcategoria, alterar );
        
        if( verificarRepeticao( Subcategoria ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Subcategoria, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            
            if( alterar == false ) {
                Controle_Subcategoria t1 = new Controle_Subcategoria( "Criar_Subcategoria", alterar, Subcategoria , this, "", "", "", false, 0, 0 ); t1.setName("Controle_Subcategoria"); t1.start();
            }
            else if( alterar == true ) {
                
                if( !copiarArquivoHtml.equals("") ){ String strOrig = copiarArquivoHtml;
                
                    copiarArquivoHtml = "";
                    Controle_Subcategoria t1 = new Controle_Subcategoria( "Copiar_Html", alterar, Subcategoria, this, strOrig, excluirArquivoHtmlAnterior, nomeSubcategoriaAnterior, true, idMateriaAnterior, idCategoriaAnterior ); t1.setName("Controle_Subcategoria"); t1.start();           
                }
                else{
                                                            //Renomea Matéria Anterior
                    Controle_Subcategoria t1 = new Controle_Subcategoria( "Copiar_Html", alterar, Subcategoria, this, "", "", nomeSubcategoriaAnterior, false, idMateriaAnterior, idCategoriaAnterior ); t1.setName("Controle_Subcategoria"); t1.start();  
                }
            }
            Subcategorias_New.Subcategorias_Home.Inicio.cancelar();
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
   
   private void semMateria() {
                JOPM JOPM = new JOPM( "EXCEÇÃO: " + "MATÉRIA\n"
                        ,"\nPARA SALVAR UMA NOVA CATEGORIA:"
                        +"\nUMA MATÉRIA TEM QUE ESTAR SELECIONADA\n"
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
   
   private boolean verificarRepeticao( subcategoria.Subcategoria Subcategoria ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA", subcategoria.Subcategoria.class );
            List<subcategoria.Subcategoria> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Subcategoria.getId() ){
                    
                    if( list.get(i).getSubcategoria().equals( Subcategoria.getSubcategoria() ) ){
                    
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
   String nomeSubcategoriaAnterior = "";
   int    idMateriaAnterior = 0;
   int    idCategoriaAnterior = 0;
    private subcategoria.Subcategoria pegarDadosDoJPanelParaSalvar( subcategoria.Subcategoria Subcategoria, boolean alterar ) {          
        try{
            
            //
            try{
                
                if( alterar == true ){
                    
                    idMateriaAnterior        = Subcategoria.getIdMateria();
                    idCategoriaAnterior      = Subcategoria.getIdCategoria();
                    nomeSubcategoriaAnterior = Subcategoria.getSubcategoria();
                    Subcategoria.setSubcategoria( Subcategorias_New.tfNome.getText().trim().toUpperCase() );
                    
                    BookInfoMateria obj = (BookInfoMateria) Subcategorias_New.cbMateria.getSelectedItem();
                    Subcategoria.setIdMateria(obj.ID);

                    BookInfoCategoria obj2 = (BookInfoCategoria) Subcategorias_New.cbCategoria.getSelectedItem();
                    Subcategoria.setIdCategoria(obj2.ID);
                }
                else if( alterar == false ){
                    
                    idMateriaAnterior     = 0;
                    idCategoriaAnterior   = 0;
                    nomeSubcategoriaAnterior = "";
                    Subcategoria.setSubcategoria( Subcategorias_New.tfNome.getText().trim().toUpperCase() );
                    
                    BookInfoMateria obj = (BookInfoMateria) Subcategorias_New.cbMateria.getSelectedItem();
                    Subcategoria.setIdMateria(obj.ID);

                    BookInfoCategoria obj2 = (BookInfoCategoria) Subcategorias_New.cbCategoria.getSelectedItem();
                    Subcategoria.setIdCategoria(obj2.ID);
                }                
            }catch(Exception e ){}
            //
            
            //
            if( alterar == false ){
                try{ 
                                                            
                    Subcategoria.setSubcategoriapaginahtml( "modelo.html" );
                }catch(Exception e ){}            
            }
            else if( alterar == true ){
                try{ 
                    
                    String str = "";
                    try{ 
                        
                        if( !Subcategorias_New.tfPaHtml.getText().trim().equals("") ){
                            
                            File f = new File( Subcategorias_New.tfPaHtml.getText().trim() );
                            
                            if( f.exists() == true ){
                                
                                str = f.getName().trim(); 
                            
                                copiarArquivoHtml = Subcategorias_New.tfPaHtml.getText().trim();
                            }
                        }
                    }catch(Exception e ){}
                    
                    if( !str.equals("") ){
                        
                        excluirArquivoHtmlAnterior = Subcategoria.getSubcategoriapaginahtml();
                        Subcategoria.setSubcategoriapaginahtml( str );                        
                    }

                }catch(Exception e ){} 
            }
                        
        }catch(Exception e ){} 
        
        return Subcategoria;
    }
   
   public void setarDadosDoBancoNoJPanel( subcategoria.Subcategoria Subcategoria, boolean alterar ) {          
        try{
            
            //  
            try{ Subcategorias_New.tfNome.setText( Subcategoria.getSubcategoria() ); }catch(Exception e ){}
            //
            
            //  
            try{ Subcategorias_New.tfPaHtml.setText( Subcategoria.getSubcategoriapaginahtml() ); }catch(Exception e ){}
            //
            
        }catch(Exception e ){} 
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Subcategorias_New.tfNome       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
