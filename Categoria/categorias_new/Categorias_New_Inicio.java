/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package categorias_new;

import categorias.Controle_Categoria;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Categorias_New_Inicio {
        
    Categorias_New Categorias_New;//Materias_Home; 
    
    public Categorias_New_Inicio( Categorias_New Categorias_New2 ) {
        
        Categorias_New = Categorias_New2;
        
        inicioCBS();
        inicio();
    }
    
    private void inicioCBS(){        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );         
            Color c = new Color( 255, 255, 255 );
        
            Categorias_New.cbMateria     .setBackground( c );           
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicioCBS(), \n"
                + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start();       
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Categorias_New_Inicio( Categorias_New Categorias_New2, categorias.Categoria Categoria ) {
        
        Categorias_New = Categorias_New2;
          
        setarDadosDoBancoNoJPanel( Categoria, false );
        
        setarCBMateria( true, Categoria );   
        //Eventos
        try{
            MouseListener[] MouseListener = Categorias_New.btSalvar.getMouseListeners(); for ( MouseListener MouseListener1 : MouseListener) {
                Categorias_New.btSalvar.removeMouseListener( MouseListener1 ); }
                Categorias_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() { @Override public void mousePressed(java.awt.event.MouseEvent evt) {
                                 
                salvar( Categorias_New.Categoria, true ); } });    
                
        }catch(Exception e ){} 
        
        Categorias_New.btSalvar.setEnabled(true);        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            setarCBMateria(false, new categorias.Categoria());
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start();                 
    }
      
    //setar CB Matéria
    public void setarCBMateria(boolean alterar, categorias.Categoria Categoria) {       
        try {
        //new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE MATERIA LIKE ?", materias.Materia.class );
            q.setParameter(1, "%"+""+"%");            
            List<materias.Materia> list = q.getResultList();
            
            if( Categorias_New.cbMateria.getItemCount() > 0 ) { Categorias_New.cbMateria.removeAllItems(); }
            
            for (int i = 0; i < list.size(); i++){ 
                Categorias_New.cbMateria.addItem( new BookInfoMateria( 
                    list.get(i).getId(),list.get(i).getMateria()
                    )
                );    
            }
            
            if( alterar == true ) {
                
                for (int i = 0; i < Categorias_New.cbMateria.getItemCount(); i++){
                
                    BookInfoMateria obj = (BookInfoMateria) Categorias_New.cbMateria.getItemAt(i);
                    //System.out.println( "I: " + i + " - " +  "obj:" + obj.ID + " -- Categoria.getIdMateria(): " + Categoria.getIdMateria() );
                    if( obj.ID == Categoria.getIdMateria() ){
                    
                        Categorias_New.cbMateria.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
        } catch( Exception e ){}    
                        
        //} catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setarCBMateria(), \n"
        //        + e.getMessage() + "\n", "Categorias_New_Inicio" ); } } }.start(); 
    } 
   
   //Salvar
   public void salvar( categorias.Categoria Categoria, boolean alterar ) { 
       
       if( Categorias_New.btSalvar.isEnabled() ) {
            
            if( Categorias_New.tfNome.getText().trim().length() > 3 ) {
                
                if( Categorias_New.cbMateria.getItemCount() > 0 ) { 
                    
                    Categoria = pegarDadosDoJPanelParaSalvar( Categoria, alterar );
                    
                    Controle_Categoria t1 = new Controle_Categoria( "Verificar_PastaDaMateria", alterar, Categoria, this, "", "", "", false, 0  ); t1.setName("Controle_Categoria"); t1.start();                                        
                }else{ semMateria(); }
            }
            else{ sem1(); }
        }
    } 
   
   public void confirmarSalvar( categorias.Categoria Categoria, boolean alterar ) {                  
        if( verificarRepeticao( Categoria ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Categoria, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            
            if( alterar == false ) {
                Controle_Categoria t1 = new Controle_Categoria( "Criar_Categoria", alterar, Categoria, this, "", "", "", false, 0 ); t1.setName("Controle_Categoria"); t1.start();
            }
            else if( alterar == true ) {
                
                if( !copiarArquivoHtml.equals("") ){ String strOrig = copiarArquivoHtml;

                    copiarArquivoHtml = "";                  //Renomea Matéria Anterior e Copia o novo arquivo html
                    Controle_Categoria t1 = new Controle_Categoria( "Copiar_Html", alterar, Categoria, this, strOrig, excluirArquivoHtmlAnterior, nomeCategoriaAnterior, true, idMateriaAnterior ); t1.setName("Controle_Categoria"); t1.start();           
                }
                else {
                                                            //Renomea Matéria Anterior
                    Controle_Categoria t1 = new Controle_Categoria( "Copiar_Html", alterar, Categoria, this, "", "", nomeCategoriaAnterior, false, idMateriaAnterior ); t1.setName("Controle_Categoria"); t1.start();           
                }
            }
            Categorias_New.Categorias_Home.Inicio.cancelar();
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
   
   private boolean verificarRepeticao( categorias.Categoria Categoria ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA", categorias.Categoria.class );
            List<categorias.Categoria> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Categoria.getId() ){
                    
                    if( list.get(i).getCategoria().equals( Categoria.getCategoria() ) ){
                    
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
   String nomeCategoriaAnterior = "";
   int    idMateriaAnterior = 0;
    private categorias.Categoria pegarDadosDoJPanelParaSalvar( categorias.Categoria Categoria, boolean alterar ) {          
        try{
            
            //
            try{
                
                if( alterar == true ){
                    
                    idMateriaAnterior     = Categoria.getIdMateria();
                    nomeCategoriaAnterior = Categoria.getCategoria();
                    Categoria.setCategoria( Categorias_New.tfNome.getText().trim().toUpperCase() );
                    
                    BookInfoMateria obj = (BookInfoMateria) Categorias_New.cbMateria.getSelectedItem();
                    Categoria.setIdMateria(obj.ID);
                }
                else if( alterar == false ){
                    
                    idMateriaAnterior     = 0;
                    nomeCategoriaAnterior = "";
                    Categoria.setCategoria( Categorias_New.tfNome.getText().trim().toUpperCase() );
                    
                    BookInfoMateria obj = (BookInfoMateria) Categorias_New.cbMateria.getSelectedItem();
                    Categoria.setIdMateria(obj.ID);
                }                
            }catch(Exception e ){}
            //
            
            //
            if( alterar == false ){
                try{ 
                                                            
                    Categoria.setCategoriapaginahtml( "modelo.html" );
                }catch(Exception e ){}            
            }
            else if( alterar == true ){
                try{ 
                    
                    String str = "";
                    try{ 
                        
                        if( !Categorias_New.tfPaHtml.getText().trim().equals("") ){
                            
                            File f = new File( Categorias_New.tfPaHtml.getText().trim() );
                            
                            if( f.exists() == true ){
                                
                                str = f.getName().trim(); 
                            
                                copiarArquivoHtml = Categorias_New.tfPaHtml.getText().trim();
                            }
                        }
                    }catch(Exception e ){}
                    
                    if( !str.equals("") ){
                        
                        excluirArquivoHtmlAnterior = Categoria.getCategoriapaginahtml();
                        Categoria.setCategoriapaginahtml( str );                        
                    }

                }catch(Exception e ){} 
            }
            //
                        
        }catch(Exception e ){} 
        
        return Categoria;
    }
   
   public void setarDadosDoBancoNoJPanel( categorias.Categoria Categoria, boolean alterar ) {          
        try{
            
            //  
            try{ Categorias_New.tfNome.setText( Categoria.getCategoria() ); }catch(Exception e ){}
            //
            
            //  
            try{ Categorias_New.tfPaHtml.setText( Categoria.getCategoriapaginahtml() ); }catch(Exception e ){}
            //
            
        }catch(Exception e ){} 
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Categorias_New.tfNome       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
