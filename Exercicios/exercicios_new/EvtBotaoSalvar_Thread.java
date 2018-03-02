/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_new;

/**
 *
 * @author Ana
 */
public class EvtBotaoSalvar_Thread extends Thread { 
    
    Exercicios_New Exercicios_New; 
    
    public EvtBotaoSalvar_Thread( Exercicios_New Exercicios_New2 ){   
        Exercicios_New = Exercicios_New2;
    } 
            
    public void run(){  
        synchronized ( this ) {
            
            iniciar(); 
        }  
    }  
    
    public void iniciar(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtCbMateria() == true ){
    
                categoria();
                
            } else{ btSalvarEstilo(); }          
        }  
    } 
  
    public void categoria(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtCbCategoria() == true ){
    
                subcategoria();
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void subcategoria(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtCbSubcategoria() == true ){
    
                assunto();
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void assunto(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtCbAssunto() == true ){
    
                enderecoPergunta();
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void enderecoPergunta(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtEnderecoPergunta() == true ){
    
                evtRbs();
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void evtRbs(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtRbs() == true ){
    
                evtEnderecoResposta();
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void evtEnderecoResposta(){  
        synchronized(this) {  
            if( Exercicios_New.Metodos.evtEnderecoResposta() == true ){
    
                Exercicios_New.btSalvar.setEnabled( true );
                
            } else{ btSalvarEstilo(); }          
        }  
    }
    
    public void btSalvarEstilo(){  
        
        Exercicios_New.btSalvar.setEnabled( false ); 
    }
    
}
