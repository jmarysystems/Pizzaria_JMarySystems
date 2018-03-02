package exercicios_display;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaMariana
 */
public class BookInfoExercicios {
    
        public int    ID;    
        public String PERGUNTA;
        public String RESPOSTACERTA;
        public String RESPOSTAHTML;
        
        public int    ID_MATERIA;
        public int    ID_CATEGORIA;
        public int    ID_SUBCATEGORIA;
        public int    ID_ASSUNTO;

        public BookInfoExercicios(int ID2, String PERGUNTA2, String RESPOSTACERTA2, String RESPOSTAHTML2, int ID_MATERIA2, int ID_CATEGORIA2, int ID_SUBCATEGORIA2, int ID_ASSUNTO2 ) {
            ID               = ID2     ;    
            PERGUNTA         = PERGUNTA2; 
            RESPOSTACERTA    = RESPOSTACERTA2;
            RESPOSTAHTML     = RESPOSTAHTML2;
            
            ID_MATERIA       = ID_MATERIA2;
            ID_CATEGORIA     = ID_CATEGORIA2;
            ID_SUBCATEGORIA  = ID_SUBCATEGORIA2;
            ID_ASSUNTO       = ID_ASSUNTO2;
        }
        
        @Override
        public String toString() {
            return PERGUNTA;
        }

}
