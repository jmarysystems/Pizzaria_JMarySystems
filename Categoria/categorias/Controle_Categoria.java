/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package categorias;

import categorias_new.Categorias_New_Inicio;
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
public class Controle_Categoria extends Thread { 
    
    String                instrucao;
    boolean               alterar;
    
    categorias.Categoria  Categoria;
    Categorias_New_Inicio Categorias_New_Inicio;
            
    String                origem = "";                
    String                excluirArquivoHtmlAnterior;
    
    String                nomeCategoriaAnterior = "";
    boolean               alterarNomeCategoriaAnterior;
    int                   idMateriaAnterior = 0;
    
    String home   = System.getProperty("user.dir");
            
    public Controle_Categoria( String instrucao2, boolean alterar2, 
            categorias.Categoria Categoria2, Categorias_New_Inicio Categorias_New_Inicio2,
            String origem2, String excluirArquivoHtmlAnterior2,
            String nomeCategoriaAnterior2, boolean alterarNomeCategoriaAnterior2, int idMateriaAnterior2 ){   
        
        instrucao                    = instrucao2;
        alterar                      = alterar2; 
        
        Categoria                    = Categoria2;                
        Categorias_New_Inicio        = Categorias_New_Inicio2;  
                        
        origem                       = origem2;        
        excluirArquivoHtmlAnterior   = excluirArquivoHtmlAnterior2; 
        
        nomeCategoriaAnterior        = nomeCategoriaAnterior2;
        alterarNomeCategoriaAnterior = alterarNomeCategoriaAnterior2;
        idMateriaAnterior            = idMateriaAnterior2;
    } 
    
    public void run(){  
        synchronized ( this ) {
            
            switch( instrucao ){
                
                case "Verificar_PastaDaMateria": verificar_PastaDaMateria();   break;
                case "Criar_Categoria"         : criar_Pasta_da_Categoria(); break;  
                case "Excluir_Categoria"       : excluir_Pasta_da_Categoria(); break;   
                case "Copiar_Html"             : copiar_Arquivo_html(); break;     
            }          
        }  
    }
    
    ////////////////////////////////////////////////////////////////////////////    
    public void verificar_PastaDaMateria(){  
        synchronized ( this ) {
            
            String nomePastaDaMateria = retornarNomeMateria( Categoria.getIdMateria() );
            
            String endPastaDaMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
               
            if ( new File( home + endPastaDaMateria ).exists() == false ) {
                
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_PastaDaMateria()\n"
                        ,"\nPasta: " + nomePastaDaMateria
                        +"\nA Pasta da matéria referente ao endereço onde criar a Categoria não existe"
                        +"\nPara criar uma categoria é preciso criar antes a matéria"
                        ,this.getClass().getName()
                );
            }   
            else { Categorias_New_Inicio.confirmarSalvar(Categoria, alterar ); }
        }  
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void criar_Pasta_da_Categoria(){ 
        synchronized ( this ) {
            
            String nomePastaDaMateria = retornarNomeMateria( Categoria.getIdMateria() );
            
            String endPastaDaMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
            
            if ( Arquivo_Ou_Pasta.criarPasta(home + endPastaDaMateria, Categoria.getCategoria() ) == true ) {
                
                if( alterar == false ) {
                    String str = home + endPastaDaMateria + System.getProperty("file.separator") + Categoria.getCategoria();
                
                    try{
               
                        Arquivo_Ou_Pasta.copiarArquivoDoJar( "/sistema_Html/modelo.html", str );     
                    }catch( Exception e ){}                   
                }   
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Categoria " + Categoria.getCategoria() + " foi criada com sucesso!"
                        +"\nE salva no Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Categoria.getCategoria() + " não foi criada"
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
            if( alterarNomeCategoriaAnterior == true ){  
                
                renomearArquivo();
                copiar_Arquivo_html_true();
                copiar_categoria_para_outra_materia();
            }else{
                
                renomearArquivo();
                copiar_categoria_para_outra_materia();
            }
        }
    }
    public void copiar_Arquivo_html_true(){
        synchronized ( this ) {
            
            String nomePastaDaMateria = retornarNomeMateria( Categoria.getIdMateria() );
            
            String endPastaDaMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
            
            try{                
                String strCategoria = home + endPastaDaMateria + System.getProperty("file.separator") + Categoria.getCategoria();
                
                String excluirArquivoHtml = home + endPastaDaMateria + System.getProperty("file.separator") + Categoria.getCategoria() + System.getProperty("file.separator") + excluirArquivoHtmlAnterior;
                
                File f  = new File( origem );
                File f2 = new File( excluirArquivoHtml );
                
                if( !origem.equals( strCategoria + System.getProperty("file.separator") + f.getName() ) ){
                    //System.out.println( "---- " + excluirArquivoHtml );
                 
                    if( !f.getCanonicalPath().equals( f2.getCanonicalPath() ) ){
                        
                        Arquivo_Ou_Pasta.deletar( f2 );
                        Arquivo_Ou_Pasta.copiarArquivo( f, strCategoria );  
                    }
                }
                
            }catch( Exception e ){}    
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void copiar_categoria_para_outra_materia(){
        synchronized ( this ) {
            
            if( idMateriaAnterior != 0 ) {
            
                String nomeMateriaAnterior = retornarNomeMateria( idMateriaAnterior );
                String nomePastaDaMateria  = retornarNomeMateria( Categoria.getIdMateria() );
            
                if( !nomeMateriaAnterior.equals("") && !nomeMateriaAnterior.equals( nomePastaDaMateria ) ){
            
                    String endPastaDaMateriaAnterior   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomeMateriaAnterior;
            
                    try{                
                        String strCategoria = home + endPastaDaMateriaAnterior + System.getProperty("file.separator") + Categoria.getCategoria();
              
                        String endPastaDaMateriaAtual = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
                        
                        synchronized ( this ) {
                            
                            Arquivo_Ou_Pasta.copiar( new File( strCategoria ), endPastaDaMateriaAtual );
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
    private void renomearArquivo() {
        if( !nomeCategoriaAnterior.equals("") && !nomeCategoriaAnterior.equals( Categoria.getCategoria() ) ){
            
            String nomePastaDaMateria = retornarNomeMateria( Categoria.getIdMateria() );
            
            String endPastaDaMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
            
            String strCategoria  = home + endPastaDaMateria + System.getProperty("file.separator") + Categoria.getCategoria();
            String strCategoria2 = home + endPastaDaMateria + System.getProperty("file.separator") + nomeCategoriaAnterior;
            
            File f  = new File( strCategoria2 );
            File f2 = new File( strCategoria );
            
            boolean success = f.renameTo(f2);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void excluir_Pasta_da_Categoria(){ 
        synchronized ( this ) {
            
            String nomePastaDaMateria = retornarNomeMateria( Categoria.getIdMateria() );
            
            String endPastaDaMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia" + System.getProperty("file.separator") + nomePastaDaMateria;
            String str    = home + endPastaDaMateria + System.getProperty("file.separator") + Categoria.getCategoria();
            
            if ( Arquivo_Ou_Pasta.deletar( new File(str) ) == true ) {
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Categoria " + Categoria.getCategoria() + " foi excluída com sucesso!"
                        +"\nE retirada do Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Categoria()\n"
                        ,"\nPasta Categoria:"
                        +"\nA Pasta " + Categoria.getCategoria() + " não foi excluída"
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
    
    
   
               
}