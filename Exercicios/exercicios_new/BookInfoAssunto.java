package exercicios_new;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaMariana
 */
public class BookInfoAssunto {
    
        public int    ID;    
        public String ASSUNTO;

        public BookInfoAssunto(int ID2, String ASSUNTO2 ) {
            ID                 = ID2     ;    
            ASSUNTO       = ASSUNTO2; 
        }
        
        @Override
        public String toString() {
            return ASSUNTO;
        }

}
