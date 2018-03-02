/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_tabelas;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import utilidades.DB;

/**
 *
 * @author AnaMariana
 */
public class Subcategoria {
    
    public static boolean criar() {     
        Connection con = null;     
        Statement s;
                
        boolean retorno;
        
        DB DB = new DB();
               
        try {

            con = DB.derby();
            
            retorno = true;
            
        } catch ( Exception e ) {
            
            retorno = false;
            JOptionPane.showMessageDialog( null, "Erro! \n" + e.getMessage().toString() );    
        } 

        try {                     
            
            s = con.createStatement(); 
            
            s       
            .execute( "CREATE TABLE SCHEMAJMARY.SUBCATEGORIA ( "
                    + "ID          INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    
                    + "SUBCATEGORIA             VARCHAR(70)  ,"
                    + "SUBCATEGORIAPAGINAHTML   VARCHAR(500),"
                    
                    + "ID_MATERIA    INTEGER NOT NULL,"                    
                    + "CONSTRAINT MATERIA_ID_SUBCATEGORIA FOREIGN KEY (ID_MATERIA) references SCHEMAJMARY.MATERIA (ID),"
                    
                    + "ID_CATEGORIA    INTEGER NOT NULL,"                    
                    + "CONSTRAINT CATEGORIA_ID_SUBCATEGORIA FOREIGN KEY (ID_CATEGORIA) references SCHEMAJMARY.CATEGORIA (ID)"
                    
                    + ")" 
            );
            
        } catch ( Exception e ) {
            
            retorno = false;
            JOptionPane.showMessageDialog( null, "Erro! \n" + e.getMessage().toString() );    
        } 
        
        return retorno;
    }
    
    /******************Executar Teste*************************************
     * @param args************************/
    public static void main(String[] args) {            
        criar();
    }
    /******************Executar Teste*************************************/
    
}
