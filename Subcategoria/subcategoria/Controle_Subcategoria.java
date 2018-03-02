/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subcategoria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import jpa.JPAUtil;
import subcategoria_new.Subcategorias_New_Inicio;
import utilidades.Arquivo_Ou_Pasta;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class Controle_Subcategoria extends Thread { 
    
    String                     instrucao;
    boolean                    alterar;
    
    subcategoria.Subcategoria  Subcategoria;
    Subcategorias_New_Inicio   Subcategorias_New_Inicio;
                
    String                     origem = "";                
    String                     excluirArquivoHtmlAnterior;
     
    String                     nomeSubcategoriaAnterior = "";
    boolean                    alterarNomeSubcategoriaAnterior;
    int                        idMateriaAnterior = 0;
    
    int                        idCategoriaAnterior = 0;
    
    String home   = System.getProperty("user.dir");
            
    //Verificar_Files_Html///////////Criar_Subcategoria/////////////////////////
    public Controle_Subcategoria( String instrucao2, boolean alterar2, 
            subcategoria.Subcategoria Subcategoria2, Subcategorias_New_Inicio Subcategorias_New_Inicio2,
            String origem2, String excluirArquivoHtmlAnterior2,
            String nomeCategoriaAnterior2, boolean alterarNomeSubcategoriaAnterior2, int idMateriaAnterior2, 
            int idCategoriaAnterior2 ){   
        
        instrucao                    = instrucao2;
        alterar                      = alterar2; 
        
        Subcategoria                    = Subcategoria2;                
        Subcategorias_New_Inicio        = Subcategorias_New_Inicio2;  
                        
        origem                       = origem2;        
        excluirArquivoHtmlAnterior   = excluirArquivoHtmlAnterior2; 
        
        nomeSubcategoriaAnterior        = nomeCategoriaAnterior2;
        alterarNomeSubcategoriaAnterior = alterarNomeSubcategoriaAnterior2;
        idMateriaAnterior            = idMateriaAnterior2;
        
        idCategoriaAnterior            = idCategoriaAnterior2;
    } 
    
    public void run(){  
        synchronized ( this ) {
            
            switch( instrucao ){
                
                case "Verificar_PastaDaCategoria": verificar_PastaDaCategoria();   break;
                case "Criar_Subcategoria"        : criar_Pasta_da_Subcategoria(); break;  
                case "Excluir_Subcategoria"      : excluir_Pasta_da_Categoria(); break;   
                case "Copiar_Html"               : copiar_Arquivo_html(); break;     
            }          
        }  
    }
    
    ////////////////////////////////////////////////////////////////////////////    
    public void verificar_PastaDaCategoria(){  
        synchronized ( this ) {
            
            String nomePastaDaMateria   = retornarNomeMateria( Subcategoria.getIdMateria() );
            String nomePastaDaCategoria = retornarNomeCategoria( Subcategoria.getIdCategoria() );
            
            String endPastaDaSubcategoria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria;

            if ( new File( home + endPastaDaSubcategoria ).exists() == false ) {
                
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_PastaDaCategoria()\n"
                        ,"\nPasta: " + nomePastaDaCategoria
                        +"\nA Pasta da Categoria referente ao endereço onde criar a Subcategoria não existe"
                        +"\nPara criar uma subcategoria é preciso criar antes a Categoria"
                        ,this.getClass().getName()
                );
            }   
            else { Subcategorias_New_Inicio.confirmarSalvar( Subcategoria, alterar ); }
        }  
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void criar_Pasta_da_Subcategoria(){ 
        synchronized ( this ) {
            
            String pastaDaMateria   = retornarNomeMateria( Subcategoria.getIdMateria() );
            String pastaDaCategoria = retornarNomeCategoria( Subcategoria.getIdCategoria() );
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria;
            
            if ( Arquivo_Ou_Pasta.criarPasta(home + cont, Subcategoria.getSubcategoria()) == true ) {
                
                if( alterar == false ) {
                    String str = home + cont + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
                
                    try{
               
                        Arquivo_Ou_Pasta.copiarArquivoDoJar( "/sistema_Html/modelo.html", str );     
                    }catch( Exception e ){}                   
                }   
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Categoria " + Subcategoria.getSubcategoria() + " foi criada com sucesso!"
                        +"\nE salva no Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Subcategoria.getSubcategoria() + " não foi criada"
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
                copiar_subcategoria_para_outra_categoria();
                copiar_subcategoria_para_outra_materia();
            }else{
                
                renomearArquivo();
                copiar_subcategoria_para_outra_categoria();
                copiar_subcategoria_para_outra_materia();
            }
        }
    }
    
    public void copiar_Arquivo_html_true(){
        synchronized ( this ) {
            
            String pastaDaMateria   = retornarNomeMateria( Subcategoria.getIdMateria() );
            String pastaDaCategoria = retornarNomeCategoria( Subcategoria.getIdCategoria() );
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria;
            
            try{
                
                String str = home + cont + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
                
                String excluirArquivoHtml = home + cont + System.getProperty("file.separator") + Subcategoria.getSubcategoria() + System.getProperty("file.separator") + excluirArquivoHtmlAnterior;
                
                File f  = new File( origem );
                File f2 = new File( excluirArquivoHtml );
                
                if( !origem.equals( str + "\\" + f.getName() ) ){
                 
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
    public void copiar_subcategoria_para_outra_categoria(){
        synchronized ( this ) {
            
            if( idCategoriaAnterior != 0 ) {
            
                String nomePastaDaMateria    = retornarNomeMateria  ( Subcategoria.getIdMateria() );
                
                String nomeCategoriaAnterior = retornarNomeCategoria( idCategoriaAnterior );
                String nomePastaDaCategoria  = retornarNomeCategoria( Subcategoria.getIdCategoria() );                
            
                if( !nomeCategoriaAnterior.equals("") && !nomeCategoriaAnterior.equals( nomePastaDaCategoria ) ){
            
                    String endPastaDaCategoriaAnterior   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomeCategoriaAnterior;
            
                    try{                
                        String strCategoria = home + endPastaDaCategoriaAnterior + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
              
                        String endPastaDaCategoriaAtual = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria;
                        
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.copiar( new File( strCategoria ), endPastaDaCategoriaAtual );
                        }
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.deletar( new File( strCategoria ) );
                        }
              
                    }catch( Exception e ){}                
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void copiar_subcategoria_para_outra_materia(){
        synchronized ( this ) {
            
            if( idMateriaAnterior != 0 ) {
            
                String nomeMateriaAnterior = retornarNomeMateria( idMateriaAnterior );
                String nomePastaDaMateria  = retornarNomeMateria( Subcategoria.getIdMateria() );
                
                String nomeCategoriaAnterior = retornarNomeCategoria( idCategoriaAnterior );
                String nomePastaDaCategoria  = retornarNomeCategoria( Subcategoria.getIdCategoria() );
            
                if( !nomeMateriaAnterior.equals("") && !nomeMateriaAnterior.equals( nomePastaDaMateria ) ){
            
                    String endPastaDaMateriaAnterior   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomeMateriaAnterior + System.getProperty("file.separator") + nomeCategoriaAnterior;
            
                    try{                
                        String strSubcategoria = home + endPastaDaMateriaAnterior + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
              
                        String endPastaDaMateriaAtual = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria;
                        
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
        if( !nomeSubcategoriaAnterior.equals("") && !nomeSubcategoriaAnterior.equals( Subcategoria.getSubcategoria() ) ){
            
            String nomePastaDaMateria   = retornarNomeMateria( Subcategoria.getIdMateria() );
            String nomePastaDaCategoria = retornarNomeCategoria( Subcategoria.getIdCategoria() );
            
            String endPastaDaSubcategoria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria + System.getProperty("file.separator") + nomePastaDaCategoria;
            
            String strCategoria  = home + endPastaDaSubcategoria + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
            String strCategoria2 = home + endPastaDaSubcategoria + System.getProperty("file.separator") + nomeSubcategoriaAnterior;
            
            File f  = new File( strCategoria2 );
            File f2 = new File( strCategoria );
            
            boolean success = f.renameTo(f2);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void excluir_Pasta_da_Categoria(){ 
        synchronized ( this ) {
            
            String pastaDaMateria   = retornarNomeMateria( Subcategoria.getIdMateria() );
            String pastaDaCategoria = retornarNomeCategoria( Subcategoria.getIdCategoria() );

            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + pastaDaMateria + System.getProperty("file.separator") + pastaDaCategoria;
            String str    = home + cont + System.getProperty("file.separator") + Subcategoria.getSubcategoria();
            
            if ( Arquivo_Ou_Pasta.deletar( new File(str) ) == true ) {
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Categoria " + Subcategoria.getSubcategoria() + " foi excluída com sucesso!"
                        +"\nE retirada do Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Subcategoria.getSubcategoria() + " não foi excluída"
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
    
    
   
               
}