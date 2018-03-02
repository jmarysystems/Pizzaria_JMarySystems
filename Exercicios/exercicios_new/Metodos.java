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
public class Metodos { 
    
    Exercicios_New Exercicios_New;
    
    public Metodos( Exercicios_New Exercicios_New2 ){   
        Exercicios_New = Exercicios_New2;
    } 
  
    public boolean evtCbMateria(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.cbMateria.getSelectedItem().equals("") ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }  
    
    public boolean evtCbCategoria(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.cbCategoria.getSelectedItem().equals("") ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
    public boolean evtCbSubcategoria(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.cbSubcategoria.getSelectedItem().equals("") ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
    public boolean evtCbAssunto(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.cbAssunto.getSelectedItem().equals("") ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
    public boolean evtEnderecoPergunta(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.tfEnderecoPergunta.getText().trim().equals( "" ) ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
    public boolean evtRbs(){ 
        boolean retorno = false;
        
        try{  
            if( Exercicios_New.rbA.isSelected() || Exercicios_New.rbB.isSelected() || Exercicios_New.rbC.isSelected() || Exercicios_New.rbD.isSelected() ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
    public boolean evtEnderecoResposta(){ 
        boolean retorno = false;
        
        try{  
            if( !Exercicios_New.tfEnderecoResposta.getText().trim().equals( "" ) ){
                
                retorno = true;
                
            } else{ Exercicios_New.btSalvar.setEnabled( false ); }         
            
        } catch( Exception e ){ retorno = false; }
        
        return retorno; 
    }
    
}
