/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package home_usuario_logado;

import usuario_control.Bean_Usuario;
import java.util.List;

/**
 *
 * @author ana
 */
public class Home_Setar_Bean_logado { //Home_Bean_logado
    
    public Home_Setar_Bean_logado( List<Bean_Usuario> List_Bean_Logado ){
        
        mostrarLista( List_Bean_Logado );
    }
    
    private void mostrarLista( List<Bean_Usuario> Bean_Usuario ){
        
        for (int i = 0; i < Bean_Usuario.size(); i++){
                
            //System.out.println( "List - " + Bean_Usuario.size() + " - 1 - " + List_Bean_Logado.get(i).getNOME() );

            Bean_Usuario_Logado.PERMITIRACESSO                  = ( Bean_Usuario.get(i).isPERMITIRACESSO()       ); 
            Bean_Usuario_Logado.LOGIN                           = ( Bean_Usuario.get(i).getLOGIN()               ); 
            Bean_Usuario_Logado.SENHA                           = ( Bean_Usuario.get(i).getSENHA()               );                                
                
            /*_____Matéria____________________________________________*/
            Bean_Usuario_Logado.CADASTRARMATERIA                =( Bean_Usuario.get(i).isCADASTRARMATERIA()       );
            Bean_Usuario_Logado.CADASTRARCATEGORIA              =( Bean_Usuario.get(i).isCADASTRARCATEGORIA()       );               
            Bean_Usuario_Logado.CADASTRARSUBCATEGORIA           =( Bean_Usuario.get(i).isCADASTRARSUBCATEGORIA()       );
            Bean_Usuario_Logado.CADASTRARASSUNTO                =( Bean_Usuario.get(i).isCADASTRARASSUNTO()       );
                    
            Bean_Usuario_Logado.ALTERARMATERIA                  =( Bean_Usuario.get(i).isALTERARMATERIA()       );
            Bean_Usuario_Logado.ALTERARCATEGORIA                =( Bean_Usuario.get(i).isALTERARCATEGORIA()       );                    
            Bean_Usuario_Logado.ALTERARSUBCATEGORIA             =( Bean_Usuario.get(i).isALTERARSUBCATEGORIA()       );
            Bean_Usuario_Logado.ALTERARASSUNTO                  =( Bean_Usuario.get(i).isALTERARASSUNTO()       );
                    
            Bean_Usuario_Logado.EXCLUIRMATERIA                  =( Bean_Usuario.get(i).isEXCLUIRMATERIA()       );
            Bean_Usuario_Logado.EXCLUIRCATEGORIA                =( Bean_Usuario.get(i).isEXCLUIRCATEGORIA()       );                  
            Bean_Usuario_Logado.EXCLUIRSUBCATEGORIA             =( Bean_Usuario.get(i).isEXCLUIRSUBCATEGORIA()       );
            Bean_Usuario_Logado.EXCLUIRASSUNTO                  =( Bean_Usuario.get(i).isEXCLUIRASSUNTO()       );
                    
            Bean_Usuario_Logado.PESQUISARMATERIA                =( Bean_Usuario.get(i).isPESQUISARMATERIA()       );
            Bean_Usuario_Logado.PESQUISARCATEGORIA              =( Bean_Usuario.get(i).isPESQUISARCATEGORIA()       );                  
            Bean_Usuario_Logado.PESQUISARSUBCATEGORIA           =( Bean_Usuario.get(i).isPESQUISARSUBCATEGORIA()       );
            Bean_Usuario_Logado.PESQUISARASSUNTO                =( Bean_Usuario.get(i).isPESQUISARASSUNTO()       );                                               
                
            Bean_Usuario_Logado.ID                              =( Bean_Usuario.get(i).getID()   );
                        
        }
    }
   
}
