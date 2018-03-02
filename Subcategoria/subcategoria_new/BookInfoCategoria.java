package subcategoria_new;

import categorias_new.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaMariana
 */
public class BookInfoCategoria {
    
        public int    ID;    
        public String CATEGORIA; 

        public BookInfoCategoria(int ID2, String CATEGORIA2 ) {
            ID                 = ID2     ;    
            CATEGORIA            = CATEGORIA2; 
        }
        
        @Override
        public String toString() {
            return CATEGORIA;
        }

}
