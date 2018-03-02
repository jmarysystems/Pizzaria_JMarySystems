/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package materias_new;

import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import javax.persistence.Query;
import jpa.DAOGenericoJPA;
import jpa.JPAUtil;
import materias.Controle_Materia;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Materia_New_Inicio {
        
    Materia_New Materia_New;//Materias_Home; 
    
    public Materia_New_Inicio( Materia_New Materia_New2 ) {
        
        Materia_New = Materia_New2;

        inicio();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Materia_New_Inicio( Materia_New Materia_New2, materias.Materia Materia ) {
        
        Materia_New = Materia_New2;
          
        setarDadosDoBancoNoJPanel( Materia, false );
        
        //Eventos
        try{
            MouseListener[] MouseListener = Materia_New.btSalvar.getMouseListeners(); for ( MouseListener MouseListener1 : MouseListener) {
                Materia_New.btSalvar.removeMouseListener( MouseListener1 ); }
                Materia_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() { @Override public void mousePressed(java.awt.event.MouseEvent evt) {
                
                salvar( Materia_New.Materia, true ); } });    
                
        }catch(Exception e ){} 
        
        Materia_New.btSalvar.setEnabled(true);        
    }
    ///////////////////////////////////////////////////////////////////////////
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
                                    
        } catch( Exception e ){ JOPM JOPM = new JOPM( "MÉTODO: "+"inicio()\n", e.getMessage() +"\n", this.getClass().getName() ); }}}.start();                
    }
    
    //Salvar
    public void salvar( materias.Materia Materia, boolean alterar ) {  
        if( Materia_New.btSalvar.isEnabled() ) {
            
            if( Materia_New.tfNome.getText().trim().length() > 3 ) {
                
                Controle_Materia t1 = new Controle_Materia( "Verificar_Files_Html", alterar, Materia, this, "", "", "", false ); t1.setName("Controle_Materia"); t1.start();                             
            }
            else{ sem1(); }
        }
    } 
    
    public void confirmarSalvar( materias.Materia Materia, boolean alterar ) { 
        Materia = pegarDadosDoJPanelParaSalvar( Materia, alterar );
        
        if( verificarRepeticao( Materia ) == false ){
            
            DAOGenericoJPA DAOGenericoJPA = new DAOGenericoJPA(Materia, JPAUtil.em());
            DAOGenericoJPA.gravanovoOUatualizar();
            
            if( alterar == false ) {
                Controle_Materia t1 = new Controle_Materia( "Criar_Matéria", alterar, Materia, this, "", "", "", false ); t1.setName("Controle_Materia"); t1.start();
            }
            else if( alterar == true ) {
                
                if( !copiarArquivoHtml.equals("") ){ String strOrig = copiarArquivoHtml;

                    copiarArquivoHtml = "";                  //Renomea Matéria Anterior e Copia o novo arquivo html
                    Controle_Materia t1 = new Controle_Materia( "Copiar_Html", alterar, Materia, this, strOrig, excluirArquivoHtmlAnterior, nomeMateriaAnterior, true ); t1.setName("Controle_Materia"); t1.start();           
                }
                else{ String strOrig = copiarArquivoHtml;
                                                            //Renomea Matéria Anterior
                    Controle_Materia t1 = new Controle_Materia( "Copiar_Html", alterar, Materia, this, "", "", nomeMateriaAnterior, false ); t1.setName("Controle_Materia"); t1.start();           
                }
            }
            Materia_New.Materias_Home.Inicio.cancelar();
        }
        else{
            
            repetido();
        }
    }
   
   private void sem1() {
                JOPM JOPM = new JOPM( "EXCEÇÃO: " + "MATÉRIA\n"
                        ,"\nPARA SALVAR UMA NOVA MATÉRIA:"
                        +"\nO NOME INFORMADO DEVE TER NO MÍNIMO 4 LETRAS\n"
                        ,this.getClass().getName()
                );
   }
   
   private void repetido() {
                JOPM JOPM = new JOPM( "EXCEÇÃO: " + "NOME DA MATÉRIA\n"
                        ,"\nO NOME DA MATÉRIA INFORMADO JÁ EXISTE CADASTRADO"
                        +"\nINFORME UM NOME DE MATÉRIA AINDA NÃO CADASTRADO\n"
                        ,this.getClass().getName()
                );
   }
   
   private boolean verificarRepeticao( materias.Materia Materia ) {  
       boolean retorno = false;
        try{
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA", materias.Materia.class );
            List<materias.Materia> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){
                
                if( list.get(i).getId() != Materia.getId() ){
                    
                    if( list.get(i).getMateria().equals( Materia.getMateria() ) ){
                    
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
   String nomeMateriaAnterior = "";
    private materias.Materia pegarDadosDoJPanelParaSalvar( materias.Materia Materia, boolean alterar ) {          
        try{
            
            //
            try{
                
                if( alterar == true ){
                    
                    nomeMateriaAnterior = Materia.getMateria();
                    Materia.setMateria( Materia_New.tfNome.getText().trim().toUpperCase() );
                }
                else if( alterar == false ){
                    
                    nomeMateriaAnterior = "";
                    Materia.setMateria( Materia_New.tfNome.getText().trim().toUpperCase() );
                }                
            }catch(Exception e ){}
            //
            
            //
            if( alterar == false ){
                try{ 
                                                            
                    Materia.setMateriapaginahtml( "modelo.html" );
                }catch(Exception e ){}            
            }
            else if( alterar == true ){
                try{ 
                    
                    String str = "";
                    try{ 
                        
                        if( !Materia_New.tfPaHtml.getText().trim().equals("") ){
                            
                            File f = new File( Materia_New.tfPaHtml.getText().trim() );
                            
                            if( f.exists() == true ){
                                
                                str = f.getName().trim(); 
                            
                                copiarArquivoHtml = Materia_New.tfPaHtml.getText().trim();
                            }
                        }
                    }catch(Exception e ){}
                    
                    if( !str.equals("") ){
                        
                        excluirArquivoHtmlAnterior = Materia.getMateriapaginahtml();
                        Materia.setMateriapaginahtml( str );                        
                    }

                }catch(Exception e ){} 
            }
            //
                        
        }catch(Exception e ){} 
        
        return Materia;
    }
    
    public void setarDadosDoBancoNoJPanel( materias.Materia Materia, boolean alterar ) {          
        try{
            
            //  
            try{ Materia_New.tfNome.setText( Materia.getMateria() ); }catch(Exception e ){}
            //
            
            //  
            try{ Materia_New.tfPaHtml.setText( Materia.getMateriapaginahtml() ); }catch(Exception e ){}
            //
            
        }catch(Exception e ){} 
    }
    
    public void desabilitarComponentesDoJPanel( boolean b ) {          
        try{
            
            Materia_New.tfNome       .setEditable(b);       

        }catch(Exception e ){} 
    }
    
}
