/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package materias;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import materias_new.Materia_New_Inicio;
import utilidades.Arquivo_Ou_Pasta;
import utilidades.JOPM;
import utilidades_imagens.Imagens;

/**
 *
 * @author Ana
 */
public class Controle_Materia extends Thread { 
    
    String             instrucao;
    boolean            alterar;
    
    materias.Materia   Materia;        
    Materia_New_Inicio Materia_New_Inicio;  
    
    String             nomeMateriaAnterior = "";
    boolean            alterarNomeMateriaAnterior;
            
    String origem = "";
    String excluirArquivoHtmlAnterior;
    
    String home   = System.getProperty("user.dir");
            
    public Controle_Materia( String instrucao2, boolean alterar2, 
            materias.Materia Materia2, Materia_New_Inicio Materia_New_Inicio2,
            String origem2, String excluirArquivoHtmlAnterior2,
            String nomeMateriaAnterior2, boolean alterarNomeMateriaAnterior2 ){   
        
        instrucao                  = instrucao2;
        alterar                    = alterar2; 
        
        Materia                    = Materia2;                
        Materia_New_Inicio         = Materia_New_Inicio2;    
        
        origem                     = origem2;        
        excluirArquivoHtmlAnterior = excluirArquivoHtmlAnterior2;
        
        nomeMateriaAnterior        = nomeMateriaAnterior2;
        alterarNomeMateriaAnterior = alterarNomeMateriaAnterior2;
    } 
    
    public void run(){  
        synchronized ( this ) {
            
            switch( instrucao ){
                
                case "Verificar_Files_Html": verificar_Files_Html();   break;
                case "Criar_Matéria"       : criar_Pasta_da_Materia(); break;  
                case "Excluir_Matéria"     : excluir_Pasta_da_Materia(); break;   
                case "Copiar_Html"         : copiar_Arquivo_html(); break;     
            }          
        }  
    }
    
    ////////////////////////////////////////////////////////////////////////////
    String arq   = home + System.getProperty("file.separator") + "Files_Html";
    
    public void verificar_Files_Html(){  
        synchronized ( this ) {
                
            if ( new File( arq ).exists() == false ) {
                
                JOPM JOPM = new JOPM( "MÉTODO: " + "files_existe()\n"
                        ,"\nPasta Files_Html:"
                        +"\nA Pasta Files_Html não está localizada junto ao JAR"
                        ,this.getClass().getName()
                );
                
                Class<Imagens> clazzHome = Imagens.class;
                int n = JOptionPane.showConfirmDialog(null, 
                        "EXCEÇÃO: Pasta Files_Html não existe" + "\n"
                        + "\nClique em sim para criar a pasta", 
                        this.getClass().getName(), 
                        JOptionPane.OK_OPTION, JOptionPane.CANCEL_OPTION, 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png"))
                ); //System.out.println( "N: " + n );
                
                if( n == 0 ){
                    
                    if ( Arquivo_Ou_Pasta.criarPasta( home, "Files_Html" ) == true ) {
                        
                        JOPM JOPM2 = new JOPM( "MÉTODO: " + "files_existe()\n"
                                ,"\nPasta Files_Html:"
                                        +"\nA Pasta Files_Html foi criada junto ao JAR"
                                ,this.getClass().getName()
                        );

                    } else{
                        
                        JOPM JOPM2 = new JOPM( "MÉTODO: " + "files_existe()\n"
                                ,"\nPasta Files_Html:"
                                        +"\nA Pasta Files_Html não foi criada"
                                ,this.getClass().getName()
                        );
                    }
                }

            }   
            else if ( new File( arq ).exists() == true ) {
                
                verificar_Materia();
            }
        }  
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    String arqM   = home + System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator")+ "Materia";
    
    public void verificar_Materia(){ 
        synchronized ( this ) {
            
            if ( new File( arqM ).exists() == false ) {
                
                JOPM JOPM = new JOPM( "MÉTODO: " + "verificar_Materia()\n"
                        ,"\nPasta Matéria:"
                        +"\nA Pasta Matéria não está localizada dentro da pasta Files_Html"
                        ,this.getClass().getName()
                );
                
                Class<Imagens> clazzHome = Imagens.class;
                int n = JOptionPane.showConfirmDialog(null, 
                        "EXCEÇÃO: Pasta Matéria não existe" + "\n"
                        + "\nClique em sim para criar a pasta", 
                        this.getClass().getName(), 
                        JOptionPane.OK_OPTION, JOptionPane.CANCEL_OPTION, 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png"))
                ); //System.out.println( "N: " + n );
                
                if( n == 0 ){
                    String cont   = System.getProperty("file.separator") + "Files_Html";
                    
                    if ( Arquivo_Ou_Pasta.criarPasta( home + cont, "Materia" ) == true ) {
                            //System.out.println( "strEnd: " + strEnd + cont );
                        JOPM JOPM2 = new JOPM( "MÉTODO: " + "verificar_Materia()\n"
                                ,"\nPasta Matéria:"
                                        +"\nA Pasta Matéria foi criada dentro da pasta Files_Html"
                                ,this.getClass().getName()
                        );

                    } else{
                        
                        JOPM JOPM2 = new JOPM( "MÉTODO: " + "verificar_Materia()\n"
                                ,"\nPasta Matéria:"
                                        +"\nA Pasta Files_Htm\\Matéria não foi criada"
                                ,this.getClass().getName()
                        );
                    }
                }

            }   
            else if ( new File( arqM ).exists() == true ) {
                
                Materia_New_Inicio.confirmarSalvar( Materia, alterar );
            }            
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void criar_Pasta_da_Materia(){ 
        synchronized ( this ) {
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia";
            
            if ( Arquivo_Ou_Pasta.criarPasta( home + cont, Materia.getMateria() ) == true ) {
                
                if( alterar == false ) {
                    String strMateria = home + cont + System.getProperty("file.separator") + Materia.getMateria();
                
                    try{
               
                        Arquivo_Ou_Pasta.copiarArquivoDoJar( "/sistema_Html/modelo.html", strMateria );     
                    }catch( Exception e ){}                   
                }   
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Materia()\n"
                        ,"\nPasta Matéria:"
                        +"\nA Matéria " + Materia.getMateria() + " foi criada com sucesso!"
                        +"\nE salva no Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "criar_Pasta_da_Materia()\n"
                        ,"\nPasta Matéria:"
                        +"\nA Pasta " + Materia.getMateria() + " não foi criada"
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
            if( alterarNomeMateriaAnterior == true ){  
                
                renomearArquivo();
                copiar_Arquivo_html_true();
            }else{
                
                renomearArquivo();
            }
        }
    }
    public void copiar_Arquivo_html_true(){ 
        synchronized ( this ) {
            String strMateria   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia";            
            try{
                
                String strOrig = home + strMateria + System.getProperty("file.separator") + Materia.getMateria();
                
                String excluirArquivoHtml = home + strMateria + System.getProperty("file.separator") + Materia.getMateria() + System.getProperty("file.separator") + excluirArquivoHtmlAnterior;
                
                File f = new File( origem );
                File f2 = new File( excluirArquivoHtml );
                
                if( !origem.equals( strOrig + System.getProperty("file.separator") + f.getName() ) ){
                    
                    if( !f.getCanonicalPath().equals( f2.getCanonicalPath() ) ){
                        
                        Arquivo_Ou_Pasta.deletar(new File(excluirArquivoHtml) );
                        Arquivo_Ou_Pasta.copiarArquivo( f, strOrig );  
                    }
                }                
            }catch( Exception e ){}    
        }        
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    private void renomearArquivo() {
        if( !nomeMateriaAnterior.equals("") && !nomeMateriaAnterior.equals( Materia.getMateria() ) ){
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia";
            
            String str  = home + cont + System.getProperty("file.separator") + Materia.getMateria();
            String str2 = home + cont + System.getProperty("file.separator") + nomeMateriaAnterior;
            
            File f  = new File( str2 );
            File f2 = new File( str );
            
            boolean success = f.renameTo(f2);
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    public void excluir_Pasta_da_Materia(){ 
        synchronized ( this ) {
            
            String cont   = System.getProperty("file.separator") + "Files_Html" + System.getProperty("file.separator") + "Materia";
            String str    = home + cont + System.getProperty("file.separator") + Materia.getMateria();
            
            if ( Arquivo_Ou_Pasta.deletar( new File(str) ) == true ) {
                     
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Materia()\n"
                        ,"\nPasta Matéria:"
                        +"\nA Matéria " + Materia.getMateria() + " foi excluída com sucesso!"
                        +"\nE retirada do Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
            else{
                        
                JOPM JOPM2 = new JOPM( "MÉTODO: " + "excluir_Pasta_da_Materia()\n"
                        ,"\nPasta Matéria:"
                        +"\nA Pasta " + Materia.getMateria() + " não foi excluída"
                        +"\nMais foi retirada ndo Banco de Dados" 
                        ,this.getClass().getName()
                );
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
   
               
}