package categorias_new;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaMariana
 */
public class BookInfoMateria {
    
        public int    ID;    
        public String MATERIA; 

        public BookInfoMateria(int ID2, String MATERIA2 ) {
            ID                 = ID2     ;    
            MATERIA            = MATERIA2; 
        }
        
        @Override
        public String toString() {
            return MATERIA;
        }

}
