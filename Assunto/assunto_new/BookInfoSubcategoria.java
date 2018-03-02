package assunto_new;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaMariana
 */
public class BookInfoSubcategoria {
    
        public int    ID;    
        public String SUBCATEGORIA;

        public BookInfoSubcategoria(int ID2, String SUBCATEGORIA2 ) {
            ID                 = ID2     ;    
            SUBCATEGORIA       = SUBCATEGORIA2; 
        }
        
        @Override
        public String toString() {
            return SUBCATEGORIA;
        }

}
