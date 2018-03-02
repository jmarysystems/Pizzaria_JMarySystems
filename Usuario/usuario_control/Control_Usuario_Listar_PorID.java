package usuario_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilidades.DB;
import utilidades.JOPM;

/**
 * @author ana
 */
public class Control_Usuario_Listar_PorID {
            
    private PreparedStatement pstm;
    private ResultSet rs;   
    
    public static final String consultar = "SELECT * FROM SCHEMAJMARY.USUARIO WHERE ID = ?" ;
                
    public List<Bean_Usuario> listar ( int id ){                            
        List<Bean_Usuario> listarJavaBD = new ArrayList();        
        try {
      
            DB DB = new DB();
            Connection con = DB.derby(); //con.close();
            
            pstm = con.prepareStatement(consultar);
            pstm.setInt( 1, id );//SELECT * FROM CLIENTES WHERE NOME LIKE claudio
            rs = pstm.executeQuery();
            Bean_Usuario Bean_Usuario;
            while(rs.next()) {
                Bean_Usuario = new Bean_Usuario();                

                Bean_Usuario.setPERMITIRACESSO          ( rs.getBoolean( "PERMITIRACESSO")            ); 
                Bean_Usuario.setLOGIN                   ( rs.getString( "LOGIN")                      ); 
                Bean_Usuario.setSENHA                   ( rs.getString( "SENHA")                      );
                
                /*_____Matéria____________________________________________*/
                Bean_Usuario.setCADASTRARMATERIA        ( rs.getBoolean( "CADASTRARMATERIA" )         );
                Bean_Usuario.setCADASTRARCATEGORIA      ( rs.getBoolean( "CADASTRARCATEGORIA" )       );                
                Bean_Usuario.setCADASTRARSUBCATEGORIA   ( rs.getBoolean( "CADASTRARSUBCATEGORIA" )    );
                Bean_Usuario.setCADASTRARASSUNTO        ( rs.getBoolean( "CADASTRARASSUNTO" )         );
                    
                Bean_Usuario.setALTERARMATERIA          ( rs.getBoolean( "ALTERARMATERIA" )           );
                Bean_Usuario.setALTERARCATEGORIA        ( rs.getBoolean( "ALTERARCATEGORIA" )         );                    
                Bean_Usuario.setALTERARSUBCATEGORIA     ( rs.getBoolean( "ALTERARSUBCATEGORIA" )      );
                Bean_Usuario.setALTERARASSUNTO          ( rs.getBoolean( "ALTERARASSUNTO" )           );
                    
                Bean_Usuario.setEXCLUIRMATERIA          ( rs.getBoolean( "EXCLUIRMATERIA" )           );
                Bean_Usuario.setEXCLUIRCATEGORIA        ( rs.getBoolean( "EXCLUIRCATEGORIA" )         );                   
                Bean_Usuario.setEXCLUIRSUBCATEGORIA     ( rs.getBoolean( "EXCLUIRSUBCATEGORIA" )      );
                Bean_Usuario.setEXCLUIRASSUNTO          ( rs.getBoolean( "EXCLUIRASSUNTO" )           );
                    
                Bean_Usuario.setPESQUISARMATERIA        ( rs.getBoolean( "PESQUISARMATERIA" )         );
                Bean_Usuario.setPESQUISARCATEGORIA      ( rs.getBoolean( "PESQUISARCATEGORIA" )       );                   
                Bean_Usuario.setPESQUISARSUBCATEGORIA   ( rs.getBoolean( "PESQUISARSUBCATEGORIA" )    );
                Bean_Usuario.setPESQUISARASSUNTO        ( rs.getBoolean( "PESQUISARASSUNTO" )         );
                                                                       
                Bean_Usuario.setID( rs.getInt( "ID" ) );
                                
                listarJavaBD.add( Bean_Usuario );                
            }
            
            con.close();
        } catch ( Exception e) { 
            JOPM JOptionPaneMod = new JOPM( 2, "List<Bean_Usuario> listar ( int id ), \n"
                + e.getMessage() + "\n", "Home_Control_logado" );
        }
        
        return listarJavaBD;        
    }
    
}
