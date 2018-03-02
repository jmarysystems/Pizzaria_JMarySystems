/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_atualizar;

import exercicios.Exercicios;
import exercicios_new.Exercicios_New;
import java.awt.event.MouseListener;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Exercicios_Atualizar_Inicio extends Thread { 
    
    Exercicios_Atualizar  Exercicios_Atualizar;
    Exercicios            Exercicios;
    Exercicios_New        Exercicios_New;
    
    public Exercicios_Atualizar_Inicio( Exercicios_Atualizar Exercicios_Atualizar2 ) {
        
        Exercicios_Atualizar = Exercicios_Atualizar2;
        
        Exercicios     = Exercicios_Atualizar.Exercicios;
        Exercicios_New = Exercicios_Atualizar.Exercicios_New;
        
        inicio();
    }
    
    private void inicio(){
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 

            synchronized ( this ) {
                Exercicios_Atualizar_Conf();
                Exercicios_Atualizar_Eventos();
            }
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Categorias_Atualizar_Inicio" ); } } }.start();                 
    }
    
    private void Exercicios_Atualizar_Conf(){
        try{
            
            synchronized ( this ) { 
                            
                if( Exercicios_New.cbMateria.getItemCount() > 0 )      { Exercicios_New.cbMateria.removeAllItems(); }
                if( Exercicios_New.cbCategoria.getItemCount() > 0 )    { Exercicios_New.cbCategoria.removeAllItems(); }
                if( Exercicios_New.cbSubcategoria.getItemCount() > 0 ) { Exercicios_New.cbSubcategoria.removeAllItems(); }
                if( Exercicios_New.cbAssunto.getItemCount() > 0 )      { Exercicios_New.cbAssunto.removeAllItems(); }
            
                Exercicios_New.Exercicios_New_Inicio.setarCBMateria( true,Exercicios );
            
                exercicios_Atualizar_Conf2();
            }                                                                                    
        } 
        catch(Exception e){}
    }
            
    private void exercicios_Atualizar_Conf2(){
        try{
            synchronized ( this ) {
            
                if( Exercicios_New.cbMateria.getItemCount() > 0 ) {
                
                    /*BookInfoMateria obj = (BookInfoMateria) Exercicios_New.cbMateria.getSelectedItem();
                
                    Exercicios.setIdMateria(obj.ID);*/
                
                    Exercicios_New.Exercicios_New_Inicio.setarCBCategoria(true,Exercicios);       
                
                    categorias_Atualizar_Conf3();
                }
                else{ exercicios_Atualizar_setarRbs(); }
            }
        } 
        catch(Exception e){}
    }
    
    private void categorias_Atualizar_Conf3(){
        try{
            synchronized ( this ) {
                
                if( Exercicios_New.cbCategoria.getItemCount() > 0 ) {
                
                    /*BookInfoCategoria obj2 = (BookInfoCategoria) Exercicios_New.cbCategoria.getSelectedItem();
                
                    Exercicios.setIdCategoria(obj2.ID);*/
                
                    //System.out.println( Exercicios.getIdMateria() + " - " + Exercicios.getIdCategoria() + " - " + Exercicios.getIdSubcategoria() );
                    Exercicios_New.Exercicios_New_Inicio.setarCBSubcategoria(true,Exercicios);    
                    
                    categorias_Atualizar_Conf4();
                }   
                else{ exercicios_Atualizar_setarRbs(); }
            }
        } 
        catch(Exception e){}
    }
    
    private void categorias_Atualizar_Conf4(){
        try{
            synchronized ( this ) {
                
                if( Exercicios_New.cbSubcategoria.getItemCount() > 0 ) {
                
                    /*BookInfoCategoria obj2 = (BookInfoCategoria) Exercicios_New.cbCategoria.getSelectedItem();
                
                    Exercicios.setIdCategoria(obj2.ID);*/
                
                    //System.out.println( Exercicios.getIdMateria() + " - " + Exercicios.getIdCategoria() + " - " + Exercicios.getIdSubcategoria() );
                    Exercicios_New.Exercicios_New_Inicio.setarCBAssunto(true,Exercicios); 
                                        
                }   
                exercicios_Atualizar_setarRbs();
            }
        } 
        catch(Exception e){}
    }
    
    private void exercicios_Atualizar_setarRbs(){
        try{
            synchronized ( this ) {
                Exercicios_New.tfEnderecoPergunta.setText( Exercicios.getPergunta() );
                Exercicios_New.tfEnderecoResposta.setText( Exercicios.getRespostahtml() );
            
                if( Exercicios.getRespostacerta().trim().equals("A") ) {
                            
                    Exercicios_New.rbA.setSelected(true);                
                } else if( Exercicios.getRespostacerta().trim().equals("B") ) {
                    
                    Exercicios_New.rbB.setSelected(true); 
                } else if( Exercicios.getRespostacerta().trim().equals("C") ) {
                    
                    Exercicios_New.rbC.setSelected(true);
                } else if( Exercicios.getRespostacerta().trim().equals("D") ) {
                    
                    Exercicios_New.rbD.setSelected(true); 
                }       
            }
        } 
        catch(Exception e){}
    }
    
    private void Exercicios_Atualizar_Eventos() {  
         
        MouseListener[] MouseListener = Exercicios_New.btSalvar.getMouseListeners();
        for ( MouseListener MouseListener1 : MouseListener) {
            Exercicios_New.btSalvar.removeMouseListener( MouseListener1 );
        }
        
        Exercicios_New.btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {

                Exercicios_New.Exercicios_New_Inicio.salvar(Exercicios);
            }
        });                  
    }
             
}
