/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario_control;

/**
 *
 * @author ana
 */
public class Bean_Usuario {
    
    private static int ID                                   ;
                    
    private static boolean PERMITIRACESSO               = false;
    private static String  LOGIN                        = "";
    private static String  SENHA                        = "";
            
    /*_____Matéria____________________________________________*/
    private static boolean CADASTRARMATERIA            = false;
    private static boolean CADASTRARCATEGORIA          = false;                   
    private static boolean CADASTRARSUBCATEGORIA       = false;
    private static boolean CADASTRARASSUNTO            = false;
    
    private static boolean ALTERARMATERIA              = false;
    private static boolean ALTERARCATEGORIA            = false;                   
    private static boolean ALTERARSUBCATEGORIA         = false;
    private static boolean ALTERARASSUNTO              = false;
    
    private static boolean EXCLUIRMATERIA              = false;
    private static boolean EXCLUIRCATEGORIA            = false;                   
    private static boolean EXCLUIRSUBCATEGORIA         = false;
    private static boolean EXCLUIRASSUNTO              = false;
    
    private static boolean PESQUISARMATERIA            = false;
    private static boolean PESQUISARCATEGORIA          = false;                   
    private static boolean PESQUISARSUBCATEGORIA       = false;
    private static boolean PESQUISARASSUNTO            = false;

    /**
     * @return the ID
     */
    public static int getID() {
        return ID;
    }

    /**
     * @param aID the ID to set
     */
    public static void setID(int aID) {
        ID = aID;
    }

    /**
     * @return the PERMITIRACESSO
     */
    public static boolean isPERMITIRACESSO() {
        return PERMITIRACESSO;
    }

    /**
     * @param aPERMITIRACESSO the PERMITIRACESSO to set
     */
    public static void setPERMITIRACESSO(boolean aPERMITIRACESSO) {
        PERMITIRACESSO = aPERMITIRACESSO;
    }

    /**
     * @return the LOGIN
     */
    public static String getLOGIN() {
        return LOGIN;
    }

    /**
     * @param aLOGIN the LOGIN to set
     */
    public static void setLOGIN(String aLOGIN) {
        LOGIN = aLOGIN;
    }

    /**
     * @return the SENHA
     */
    public static String getSENHA() {
        return SENHA;
    }

    /**
     * @param aSENHA the SENHA to set
     */
    public static void setSENHA(String aSENHA) {
        SENHA = aSENHA;
    }

    /**
     * @return the CADASTRARMATERIA
     */
    public static boolean isCADASTRARMATERIA() {
        return CADASTRARMATERIA;
    }

    /**
     * @param aCADASTRARMATERIA the CADASTRARMATERIA to set
     */
    public static void setCADASTRARMATERIA(boolean aCADASTRARMATERIA) {
        CADASTRARMATERIA = aCADASTRARMATERIA;
    }

    /**
     * @return the CADASTRARCATEGORIA
     */
    public static boolean isCADASTRARCATEGORIA() {
        return CADASTRARCATEGORIA;
    }

    /**
     * @param aCADASTRARCATEGORIA the CADASTRARCATEGORIA to set
     */
    public static void setCADASTRARCATEGORIA(boolean aCADASTRARCATEGORIA) {
        CADASTRARCATEGORIA = aCADASTRARCATEGORIA;
    }

    /**
     * @return the CADASTRARSUBCATEGORIA
     */
    public static boolean isCADASTRARSUBCATEGORIA() {
        return CADASTRARSUBCATEGORIA;
    }

    /**
     * @param aCADASTRARSUBCATEGORIA the CADASTRARSUBCATEGORIA to set
     */
    public static void setCADASTRARSUBCATEGORIA(boolean aCADASTRARSUBCATEGORIA) {
        CADASTRARSUBCATEGORIA = aCADASTRARSUBCATEGORIA;
    }

    /**
     * @return the CADASTRARASSUNTO
     */
    public static boolean isCADASTRARASSUNTO() {
        return CADASTRARASSUNTO;
    }

    /**
     * @param aCADASTRARASSUNTO the CADASTRARASSUNTO to set
     */
    public static void setCADASTRARASSUNTO(boolean aCADASTRARASSUNTO) {
        CADASTRARASSUNTO = aCADASTRARASSUNTO;
    }

    /**
     * @return the ALTERARMATERIA
     */
    public static boolean isALTERARMATERIA() {
        return ALTERARMATERIA;
    }

    /**
     * @param aALTERARMATERIA the ALTERARMATERIA to set
     */
    public static void setALTERARMATERIA(boolean aALTERARMATERIA) {
        ALTERARMATERIA = aALTERARMATERIA;
    }

    /**
     * @return the ALTERARCATEGORIA
     */
    public static boolean isALTERARCATEGORIA() {
        return ALTERARCATEGORIA;
    }

    /**
     * @param aALTERARCATEGORIA the ALTERARCATEGORIA to set
     */
    public static void setALTERARCATEGORIA(boolean aALTERARCATEGORIA) {
        ALTERARCATEGORIA = aALTERARCATEGORIA;
    }

    /**
     * @return the ALTERARSUBCATEGORIA
     */
    public static boolean isALTERARSUBCATEGORIA() {
        return ALTERARSUBCATEGORIA;
    }

    /**
     * @param aALTERARSUBCATEGORIA the ALTERARSUBCATEGORIA to set
     */
    public static void setALTERARSUBCATEGORIA(boolean aALTERARSUBCATEGORIA) {
        ALTERARSUBCATEGORIA = aALTERARSUBCATEGORIA;
    }

    /**
     * @return the ALTERARASSUNTO
     */
    public static boolean isALTERARASSUNTO() {
        return ALTERARASSUNTO;
    }

    /**
     * @param aALTERARASSUNTO the ALTERARASSUNTO to set
     */
    public static void setALTERARASSUNTO(boolean aALTERARASSUNTO) {
        ALTERARASSUNTO = aALTERARASSUNTO;
    }

    /**
     * @return the EXCLUIRMATERIA
     */
    public static boolean isEXCLUIRMATERIA() {
        return EXCLUIRMATERIA;
    }

    /**
     * @param aEXCLUIRMATERIA the EXCLUIRMATERIA to set
     */
    public static void setEXCLUIRMATERIA(boolean aEXCLUIRMATERIA) {
        EXCLUIRMATERIA = aEXCLUIRMATERIA;
    }

    /**
     * @return the EXCLUIRCATEGORIA
     */
    public static boolean isEXCLUIRCATEGORIA() {
        return EXCLUIRCATEGORIA;
    }

    /**
     * @param aEXCLUIRCATEGORIA the EXCLUIRCATEGORIA to set
     */
    public static void setEXCLUIRCATEGORIA(boolean aEXCLUIRCATEGORIA) {
        EXCLUIRCATEGORIA = aEXCLUIRCATEGORIA;
    }

    /**
     * @return the EXCLUIRSUBCATEGORIA
     */
    public static boolean isEXCLUIRSUBCATEGORIA() {
        return EXCLUIRSUBCATEGORIA;
    }

    /**
     * @param aEXCLUIRSUBCATEGORIA the EXCLUIRSUBCATEGORIA to set
     */
    public static void setEXCLUIRSUBCATEGORIA(boolean aEXCLUIRSUBCATEGORIA) {
        EXCLUIRSUBCATEGORIA = aEXCLUIRSUBCATEGORIA;
    }

    /**
     * @return the EXCLUIRASSUNTO
     */
    public static boolean isEXCLUIRASSUNTO() {
        return EXCLUIRASSUNTO;
    }

    /**
     * @param aEXCLUIRASSUNTO the EXCLUIRASSUNTO to set
     */
    public static void setEXCLUIRASSUNTO(boolean aEXCLUIRASSUNTO) {
        EXCLUIRASSUNTO = aEXCLUIRASSUNTO;
    }

    /**
     * @return the PESQUISARMATERIA
     */
    public static boolean isPESQUISARMATERIA() {
        return PESQUISARMATERIA;
    }

    /**
     * @param aPESQUISARMATERIA the PESQUISARMATERIA to set
     */
    public static void setPESQUISARMATERIA(boolean aPESQUISARMATERIA) {
        PESQUISARMATERIA = aPESQUISARMATERIA;
    }

    /**
     * @return the PESQUISARCATEGORIA
     */
    public static boolean isPESQUISARCATEGORIA() {
        return PESQUISARCATEGORIA;
    }

    /**
     * @param aPESQUISARCATEGORIA the PESQUISARCATEGORIA to set
     */
    public static void setPESQUISARCATEGORIA(boolean aPESQUISARCATEGORIA) {
        PESQUISARCATEGORIA = aPESQUISARCATEGORIA;
    }

    /**
     * @return the PESQUISARSUBCATEGORIA
     */
    public static boolean isPESQUISARSUBCATEGORIA() {
        return PESQUISARSUBCATEGORIA;
    }

    /**
     * @param aPESQUISARSUBCATEGORIA the PESQUISARSUBCATEGORIA to set
     */
    public static void setPESQUISARSUBCATEGORIA(boolean aPESQUISARSUBCATEGORIA) {
        PESQUISARSUBCATEGORIA = aPESQUISARSUBCATEGORIA;
    }

    /**
     * @return the PESQUISARASSUNTO
     */
    public static boolean isPESQUISARASSUNTO() {
        return PESQUISARASSUNTO;
    }

    /**
     * @param aPESQUISARASSUNTO the PESQUISARASSUNTO to set
     */
    public static void setPESQUISARASSUNTO(boolean aPESQUISARASSUNTO) {
        PESQUISARASSUNTO = aPESQUISARASSUNTO;
    }
          
}
