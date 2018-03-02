/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios_display;

import java.io.File;
import java.net.URL;
import java.util.List;
import javax.persistence.Query;
import jpa.JPAUtil;
import utilidades.JOPM;

/**
 *
 * @author Ana
 */
public class Exercicios_Display_Setar_ProcuraBD {
    
    Query               q;
    int                 exe;
    Exercicios_Dysplay  Exercicios_Dysplay;  
    
    BookInfoExercicios BookInfoExercicios;
    
    public Exercicios_Display_Setar_ProcuraBD( Query q2, int exe2, Exercicios_Dysplay Exercicios_Dysplay2 ) {

        q                   = q2;
        exe                 = exe2;
        Exercicios_Dysplay  = Exercicios_Dysplay2;

        inicio(); 
    }     
     
    private void inicio(){
                        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                              
            List<exercicios.Exercicios> list = q.getResultList();
            
            for (int i = 0; i < list.size(); i++){  //System.out.println( i + " - " + list.get(i).getPergunta() );
                
                if( i == exe-1 ) {  //System.out.println( i + " - " + list.get(i).getPergunta() );
                    
                    BookInfoExercicios = new BookInfoExercicios(
                            list.get(i).getId(),
                            list.get(i).getPergunta(),
                            list.get(i).getRespostacerta(),
                            list.get(i).getRespostahtml(),
                            
                            list.get(i).getIdMateria(),
                            list.get(i).getIdCategoria(),
                            list.get(i).getIdSubcategoria(),
                            list.get(i).getIdAssunto()
                    );
                    
                    Exercicios_Dysplay.setBookInfoExercicios(BookInfoExercicios);
                       
                    setarConteudo();
                }
                
                int ci = i + 1;
                int cl = list.size();
                if( ci == cl ) {  
                    Exercicios_Dysplay.exeQtd = cl;
                    Exercicios_Dysplay.tfQtdQuestoes.setText( String.valueOf( cl ) );
                }
            }
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_Display_Setar_ProcuraBD" ); } } }.start(); 
        
    }
    
    private void setarConteudo(){
                        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            if( Exercicios_Dysplay.conteudo == false ) {  
                
                //MATERIA
                Query q2 = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.MATERIA WHERE ID = ?", materias.Materia.class );
                q2.setParameter(1, Exercicios_Dysplay.getBookInfoExercicios().ID_MATERIA ); 
                
                List<materias.Materia> list2 = q2.getResultList();
                for (int i = 0; i < list2.size(); i++){ 
                    
                    Exercicios_Dysplay.materiaEx = list2.get(i).getMateria();
                }
                //System.out.println( " - " + Exercicios_Dysplay.materiaEx );
                //MATERIA
                
                //CATEGORIA
                Query q3 = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CATEGORIA WHERE ID = ?", categorias.Categoria.class );
                q3.setParameter(1, Exercicios_Dysplay.getBookInfoExercicios().ID_CATEGORIA ); 
                
                List<categorias.Categoria> list3 = q3.getResultList();
                for (int i = 0; i < list3.size(); i++){ 
                    
                    Exercicios_Dysplay.categoriaEx = list3.get(i).getCategoria();
                }
                //System.out.println( " - " + Exercicios_Dysplay.categoriaEx );
                //CATEGORIA
                
                //SUBCATEGORIA
                Query q4 = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.SUBCATEGORIA WHERE ID = ?", subcategoria.Subcategoria.class );
                q4.setParameter(1, Exercicios_Dysplay.getBookInfoExercicios().ID_SUBCATEGORIA ); 
                
                List<subcategoria.Subcategoria> list4 = q4.getResultList();
                for (int i = 0; i < list4.size(); i++){ 
                    
                    Exercicios_Dysplay.subcategoriaEx = list4.get(i).getSubcategoria();
                }
                //System.out.println( " - " + Exercicios_Dysplay.subcategoriaEx );
                //SUBCATEGORIA
                
                //ASSUNTO
                Query q5 = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.ASSUNTO WHERE ID = ?", assunto.Assunto.class );
                q5.setParameter(1, Exercicios_Dysplay.getBookInfoExercicios().ID_ASSUNTO ); 
                
                List<assunto.Assunto> list5 = q5.getResultList();
                for (int i = 0; i < list5.size(); i++){ 
                    
                    Exercicios_Dysplay.assuntoEx = list5.get(i).getAssunto();
                }
                //System.out.println( " - " + Exercicios_Dysplay.assuntoEx );
                //ASSUNTO
                
                Exercicios_Dysplay.cbEscolhaExe.removeAllItems();
                Exercicios_Dysplay.cbEscolhaExe.addItem( "Digite" );
                for (int i = 1; i <= Exercicios_Dysplay.exeQtd; i++){
                    Exercicios_Dysplay.cbEscolhaExe.addItem(i);
                }
                
                Exercicios_Dysplay.conteudo = true;
                setarUrl();
            }
            else{
                setarUrl();
            }
            
        } catch( Exception e ){ 
            Exercicios_Dysplay.conteudo = false;
            JOPM JOptionPaneMod = new JOPM( 2, "setarConteudo(), \n"
                + e.getMessage() + "\n", "Exercicios_Display_Setar_ProcuraBD" ); } } }.start(); 
        
    }
    
    private void setarUrl(){
                        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                      
            String e = System.getProperty("file.separator");
            
            String endereco = System.getProperty("user.dir")+ e + "FILES"+ e +"EXERCÍCIOS"+ e 
                    +Exercicios_Dysplay.materiaEx     + e +Exercicios_Dysplay.categoriaEx+ e 
                    +Exercicios_Dysplay.subcategoriaEx+ e +Exercicios_Dysplay.assuntoEx  + e 
                    +BookInfoExercicios.PERGUNTA;//"fonema_e_letra.html";
            
            URL url = new File(endereco).toURI().toURL();
            //System.out.println( url.toString() );
            
            Exercicios_Display_Setar_Url Exercicios_Display_Setar_Url = new Exercicios_Display_Setar_Url( 
                        url.toString(), 
                        Exercicios_Dysplay );  
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "inicio(), \n"
                + e.getMessage() + "\n", "Exercicios_Display_Setar_ProcuraBD" ); } } }.start(); 
        
    }
    
}
