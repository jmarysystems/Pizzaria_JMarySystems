/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_de_dados;

import banco_de_dados_tabelas.Assunto;
import banco_de_dados_tabelas.Categoria;
import banco_de_dados_tabelas.Clientes;
import banco_de_dados_tabelas.Exercicios;
import banco_de_dados_tabelas.Materia;
import banco_de_dados_tabelas.Produtos;
import banco_de_dados_tabelas.Produtos_da_Venda;
import banco_de_dados_tabelas.Subcategoria;
import banco_de_dados_tabelas.Teste;
import banco_de_dados_tabelas.TestePovoar;
import banco_de_dados_tabelas.Usuario;
import banco_de_dados_tabelas.UsuarioPovoar;
import banco_de_dados_tabelas.Venda;
import banco_de_dados_tabelas.VerificarBanco;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class ControleThread_db extends Thread { 
    
    String endereco_db;
    
    public ControleThread_db( String endereco_db2 ){   
        endereco_db = endereco_db2;
    } 
            
    public void run(){  
        synchronized ( this ) {
            
            verificarsedbexiste(); 
        }  
    }  
    
    public void verificarsedbexiste(){  
        synchronized(this) {  
            if ( VerificarBanco.criar() == true ) {
    
                
            } else{ 
            
                a(); b(); c(); d(); e(); f(); g(); gpovoar(); 
                h(); i(); j(); k(); l(); m(); n(); o(); p();              
            }          
        }  
    } 
  
    public void a(){  
        synchronized(this) {  
            if ( CriarBancoDeDados.criar( endereco_db ) == true ) {              
                
            } else{ 
            
                JOPM JOptionPaneMod = new JOPM( 2, "Não foi possível estabelecer \n"
                + "Comunicação com o banco de dados, \n"
                + "Verificar se a pasta lib está junto com o arquivo JAR"        
                + "\n", "ControleThread_db" );
            }          
        }  
    }  
    
    public void b(){  
        synchronized(this){      
            if ( RequererAutenticacao.criar() == true ) {
                System.out.println( "b" );              
                
            } else{ 
                
            } 
        }
    }
  
    public void c(){  
        synchronized(this){ 
            if ( CriarSchema.criar() == true ) {
                System.out.println( "c" );
                
            } else{ 
           
            } 
        }
    } 
    
    public void d(){  
        synchronized(this){          
            if ( TestarUsuarioESenha.criar() == true ) {
                System.out.println( "d" );
                                
            } else{ 
                
            }   
        }  
    }
    
    public void e(){  
        synchronized(this){   
            if ( Teste.criar() == true ) {
                System.out.println( "e" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void f(){  
        synchronized(this){       
            if ( TestePovoar.criar() == true ) {
                System.out.println( "f" );
                
            } else{ 
            }  
        }  
    }    
        
    public void g(){  
        synchronized(this){   
            if ( Usuario.criar() == true ) {
                System.out.println( "g" );
                                              
            } else{ 
            }  
        }  
    }        
    
    public void gpovoar(){  
        synchronized(this){   
            if ( UsuarioPovoar.criar() == true ) {
                System.out.println( "gpovoar" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void h(){  
        synchronized(this){   
            if ( Materia.criar() == true ) {
                System.out.println( "h" );
                                              
            } else{ 
            }  
        }          
    }
    
    public void i(){  
        synchronized(this){   
            if ( Categoria.criar() == true ) {
                System.out.println( "i" );
                                              
            } else{ 
            }  
        }          
    }
    
    public void j(){  
        synchronized(this){   
            if ( Subcategoria.criar() == true ) {
                System.out.println( "j" );
                                              
            } else{ 
            }  
        }          
    }
    
    public void k(){  
        synchronized(this){   
            if ( Assunto.criar() == true ) {
                System.out.println( "k" );
                                              
            } else{ 
            }  
        }          
    }
        
    public void l(){  
        synchronized(this){   
            if ( Exercicios.criar() == true ) {
                System.out.println( "L" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void m(){  
        synchronized(this){   
            if ( Clientes.criar() == true ) {
                System.out.println( "M" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void n(){  
        synchronized(this){   
            if ( Produtos.criar() == true ) {
                System.out.println( "N" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void o(){  
        synchronized(this){   
            if ( Venda.criar() == true ) {
                System.out.println( "O" );
                                              
            } else{ 
            }  
        }  
    }
    
    public void p(){  
        synchronized(this){   
            if ( Produtos_da_Venda.criar() == true ) {
                System.out.println( "P" );
                                              
            } else{ 
            }  
        }  
    }
                    
    /******************Executar Teste*************************************
     * @param args************************
    public static void main(String[] args) {            
          
        ControleThread t1 = new ControleThread(); 
        
        t1.setName("Thread1");   
        
        t1.start();  
    }
    /******************Executar Teste*************************************/
    
}
