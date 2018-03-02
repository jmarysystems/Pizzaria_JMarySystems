/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assunto;

import assunto_new.Assunto_New_Inicio;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import jpa.JPAUtil;
import utilidades.Arquivo_Ou_Pasta;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class Controle_Assunto extends Thread { 
    
    String                     instrucao;
    boolean                    alterar;
    
    assunto.Assunto            Assunto;
    Assunto_New_Inicio         Assunto_New_Inicio;
                
    String                     origem = "";                
    String                     excluirArquivoHtmlAnterior;
     
    String                     nomeAssuntoAnterior = "";
    boolean                    alterarNomeSubcategoriaAnterior;
    int                        idMateriaAnterior = 0;
    
    int                        idCategoriaAnterior = 0;
    int                        idSubcategoriaAnterior = 0;
    
    String home   = System.getProperty("user.dir");
            
    //Verificar_Files_Html///////////Criar_Subcategoria/////////////////////////
    public Controle_Assunto( String instrucao2, boolean alterar2, 
            assunto.Assunto Assunto2, Assunto_New_Inicio Assunto_New_Inicio2,
            String origem2, String excluirArquivoHtmlAnterior2,
            String nomeCategoriaAnterior2, boolean alterarNomeSubcategoriaAnterior2, int idMateriaAnterior2, 
            int idCategoriaAnterior2, int idSubcategoriaAnterior2 ){   
        
        instrucao                    = instrucao2;
        alterar                      = alterar2; 
        
        Assunto                      = Assunto2;                
        Assunto_New_Inicio     = Assunto_New_Inicio2;  
                        
        origem                       = origem2;        
        excluirArquivoHtmlAnterior   = excluirArquivoHtmlAnterior2; 
        
        nomeAssuntoAnterior        = nomeCategoriaAnterior2;
        alterarNomeSubcategoriaAnterior = alterarNomeSubcategoriaAnterior2;
        idMateriaAnterior            = idMateriaAnterior2;
        
        idCategoriaAnterior            = idCategoriaAnterior2;
        idSubcategoriaAnterior         = idSubcategoriaAnterior2;
    } 
    
    public void run(){  
        synchronized ( this ) {
            
            switch( instrucao ){
                
                case "Verificar_PastaDaSubcategoria"  : verificar_PastaDaSubcategoria();   break;
                case "Criar_Assunto"                  : criar_Pasta_do_Assunto(); break;  
                case "Excluir_Assunto"                : excluir_Pasta_da_Categoria(); break;   
                case "Copiar_Html"                    : copiar_Arquivo_html(); break;     
            }          
        }  
    }
    
    ////////////////////////////////////////////////////////////////////////////    
    public void verificar_PastaDaSubcategoria(){  
        synchronized ( this ) {
            
            String nomePastaDaMateria   = retornarNomeMateria(Assunto.getIdMateria() );
            String nomePastaDaCategoria = retornarNomeCategoria(Assunto.getIdCategoria() );
            String nomePastaDaSubcategoria  = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );
            
            String endPastaDaSubcategoria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria + System.getProperty("file.separator") + nomePastaDaSubcategoria;

            if ( new File( home + endPastaDaSubcategoria ).exists() == false ) {
                
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_PastaDaSubcategoria()\n"
                        ,"\nPasta: " + nomePastaDaSubcategoria
                        +"\nA Pasta da Categoria referente ao endereço onde criar a Subcategoria não existe"
                        +"\nPara criar uma subcategoria é preciso criar antes a Categoria"
                        ,this.getClass().getName()
                );
            }   
            else { Assunto_New_Inicio.confirmarSalvar(Assunto, alterar ); }
        }  
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void criar_Pasta_do_Assunto(){ 
        synchronized ( this ) {
            
            String pastaDaMateria      = retornarNomeMateria(Assunto.getIdMateria() );
            String pastaDaCategoria    = retornarNomeCategoria(Assunto.getIdCategoria() );
            String pastaDaSubcategoria = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria + System.getProperty("file.separator") + pastaDaSubcategoria;
            
            if ( Arquivo_Ou_Pasta.criarPasta(home + cont, Assunto.getAssunto() ) == true ) {
                
                if( alterar == false ) {
                    String str = home + cont + System.getProperty("file.separator") + Assunto.getAssunto();
                
                    try{
               
                        Arquivo_Ou_Pasta.copiarArquivoDoJar( "/sistema_Html/modelo.html", str );     
                    }catch( Exception e ){}                   
                }   
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_do_Assunto()\n"
                        ,"\nPasta Assunto:"
                        +"\nO Assunto " + Assunto.getAssunto() + " foi criada com sucesso!"
                        +"\nE salvo no Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Assunto.getAssunto() + " não foi criada"
                        +"\nMais foi salva no Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void copiar_Arquivo_html(){ 
        synchronized ( this ) {
            if( alterarNomeSubcategoriaAnterior == true ){  
                
                renomearArquivo();
                copiar_Arquivo_html_true();
                copiar_assunto_para_outra_subcategoria();
                copiar_assunto_para_outra_materia();
            }else{
                
                renomearArquivo();
                copiar_assunto_para_outra_subcategoria();
                copiar_assunto_para_outra_materia();
            }
        }
    }
    
    public void copiar_Arquivo_html_true(){
        synchronized ( this ) {
            
            String pastaDaMateria      = retornarNomeMateria(Assunto.getIdMateria() );
            String pastaDaCategoria    = retornarNomeCategoria(Assunto.getIdCategoria() );
            String pastaDaSubcategoria = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria + System.getProperty("file.separator") + pastaDaSubcategoria;
            
            try{
                
                String str = home + cont + System.getProperty("file.separator") + Assunto.getAssunto();
                
                String excluirArquivoHtml = home + cont + System.getProperty("file.separator") + Assunto.getAssunto() + System.getProperty("file.separator") + excluirArquivoHtmlAnterior;
                
                File f  = new File( origem );
                File f2 = new File( excluirArquivoHtml );
                
                if( !origem.equals( str + System.getProperty("file.separator") + f.getName() ) ){
                 
                    if( !f.getCanonicalPath().equals( f2.getCanonicalPath() ) ){
                        
                        Arquivo_Ou_Pasta.deletar( f2 );
                        Arquivo_Ou_Pasta.copiarArquivo( f, str );  
                    }
                }
                
            }catch( Exception e ){}    
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void copiar_assunto_para_outra_subcategoria(){
        synchronized ( this ) {
            
            if( idSubcategoriaAnterior != 0 ) {
            
                String nomePastaDaMateria    = retornarNomeMateria  (Assunto.getIdMateria() );
                
                String nomeCategoriaAnterior = retornarNomeCategoria( idCategoriaAnterior );
                String nomePastaDaCategoria  = retornarNomeCategoria(Assunto.getIdCategoria() );  
                
                String nomePastaDaSubcategoriaAnterior = retornarNomeSubcategoria( idSubcategoriaAnterior      );
                String nomePastaDaSubcategoria         = retornarNomeSubcategoria( Assunto.getIdSubcategoria() );
            
                if( !nomePastaDaSubcategoriaAnterior.equals("") && !nomePastaDaSubcategoriaAnterior.equals( nomePastaDaSubcategoria ) ){
            
                    String endPastaDaCategoriaAnterior   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomeCategoriaAnterior;
            
                    try{                
                        String strSubcategoria = home + endPastaDaCategoriaAnterior + System.getProperty("file.separator") + nomePastaDaSubcategoriaAnterior + System.getProperty("file.separator") + Assunto.getAssunto();
              
                        String endPastaDaSubcategoriaAtual = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria + System.getProperty("file.separator") + nomePastaDaSubcategoria;
                        
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.copiar( new File( strSubcategoria ), endPastaDaSubcategoriaAtual );
                        }
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.deletar( new File( strSubcategoria ) );
                        }
              
                    }catch( Exception e ){}                
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
        
    ////////////////////////////////////////////////////////////////////////////
    public void copiar_assunto_para_outra_materia(){
        synchronized ( this ) {
            
            if( idMateriaAnterior != 0 ) {
            
                String nomeMateriaAnterior = retornarNomeMateria( idMateriaAnterior );
                String nomePastaDaMateria  = retornarNomeMateria(Assunto.getIdMateria() );
                
                String nomeCategoriaAnterior = retornarNomeCategoria( idCategoriaAnterior );
                String nomePastaDaCategoria  = retornarNomeCategoria(Assunto.getIdCategoria() );
                
                String nomePastaDaSubcategoriaAnterior = retornarNomeSubcategoria( idSubcategoriaAnterior      );
                String nomePastaDaSubcategoria         = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );
            
                if( !nomeMateriaAnterior.equals("") && !nomeMateriaAnterior.equals( nomePastaDaMateria ) ){
            
                    String endPastaDaMateriaAnterior   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomeMateriaAnterior + System.getProperty("file.separator") + nomeCategoriaAnterior;
            
                    try{                
                        String strSubcategoria = home + endPastaDaMateriaAnterior + System.getProperty("file.separator") + nomePastaDaSubcategoriaAnterior + System.getProperty("file.separator") + Assunto.getAssunto();
              
                        String endPastaDaMateriaAtual = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria + System.getProperty("file.separator") + nomePastaDaSubcategoria;
                        
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.copiar( new File( strSubcategoria ), endPastaDaMateriaAtual );
                        }
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.deletar( new File( strSubcategoria ) );
                        }
              
                    }catch( Exception e ){}                
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////    
    private void renomearArquivo() {
        if( !nomeAssuntoAnterior.equals("") && !nomeAssuntoAnterior.equals( Assunto.getAssunto() ) ){
            
            String nomePastaDaMateria   = retornarNomeMateria(Assunto.getIdMateria() );
            String nomePastaDaCategoria = retornarNomeCategoria(Assunto.getIdCategoria() );
            String pastaDaSubcategoria  = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );
            
            String endPastaDaAssunto   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria + System.getProperty("file.separator") + pastaDaSubcategoria;
            
            String strAssunto  = home + endPastaDaAssunto + System.getProperty("file.separator") + Assunto.getAssunto();
            String strAssunto2 = home + endPastaDaAssunto + System.getProperty("file.separator") + nomeAssuntoAnterior;
            
            File f  = new File( strAssunto2 );
            File f2 = new File( strAssunto );
            
            boolean success = f.renameTo(f2);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void excluir_Pasta_da_Categoria(){ 
        synchronized ( this ) {
            
            String pastaDaMateria   = retornarNomeMateria(Assunto.getIdMateria() );
            String pastaDaCategoria = retornarNomeCategoria(Assunto.getIdCategoria() );
            String pastaDaSubcategoria  = retornarNomeSubcategoria(Assunto.getIdSubcategoria() );

            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria + System.getProperty("file.separator") + pastaDaSubcategoria;
            String str    = home + cont + System.getProperty("file.separator") + Assunto.getAssunto();
            
            if ( Arquivo_Ou_Pasta.deletar( new File(str) ) == true ) {
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Categoria " + Assunto.getAssunto() + " foi excluída com sucesso!"
                        +"\nE retirada do Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Assunto.getAssunto() + " não foi excluída"
                        +"\nMais foi retirada ndo Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    private String retornarNomeMateria( int idMateria ){ String retorno = "";
        
        try{
            
            List<materias.Materia> ListMateria = new ArrayList();
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE ID = ?", materias.Materia.class );
            q.setParameter(1, idMateria );
            
            ListMateria = q.getResultList();
            for (int i = 0; i < ListMateria.size(); i++){ 
                
                retorno = ListMateria.get(i).getMateria();
            }
        } catch( Exception e ){}
        
        return retorno;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    private String retornarNomeCategoria( int idCategoria ){ String retorno = "";
        
        try{
            
            List<categorias.Categoria> ListCategoria = new ArrayList();
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA WHERE ID = ?", categorias.Categoria.class );
            q.setParameter(1, idCategoria );
            
            ListCategoria = q.getResultList();
            for (int i = 0; i < ListCategoria.size(); i++){ 
                
                retorno = ListCategoria.get(i).getCategoria();
            }
        } catch( Exception e ){}
        
        return retorno;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    private String retornarNomeSubcategoria( int idSubcategoria ){ String retorno = "";
        
        try{
            
            List<subcategoria.Subcategoria> ListSubcategoria = new ArrayList();
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.SUBCATEGORIA WHERE ID = ?", subcategoria.Subcategoria.class );
            q.setParameter(1, idSubcategoria );
            
            ListSubcategoria = q.getResultList();
            for (int i = 0; i < ListSubcategoria.size(); i++){ 
                
                retorno = ListSubcategoria.get(i).getSubcategoria();
            }
        } catch( Exception e ){}
        
        return retorno;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
   
               
}