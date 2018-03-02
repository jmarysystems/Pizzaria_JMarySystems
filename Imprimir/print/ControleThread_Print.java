/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package print;

import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;
import jpa.JPAUtil;
import utilidades.Arquivo_Ou_Pasta;

/**
 *
 * @author Ana
 */
public class ControleThread_Print extends Thread { 
    
    //////////////////////////////////////////
    PrinterJob  PrinterJob = null;
    JEditorPane htmlPanePrincipal = new JEditorPane();
    /////////////////////////////////////////
    
    //VENDA/////////////////////////////////
    venda.Venda Venda;
    /////////////////////////////////////////
    
    //CLIENTE////////////////////////////////
    clientes.Clientes Clientes;
    /////////////////////////////////////////

    //PRODUTOS///////////////////////////////
    List<venda.Produtosdavenda> ListProdutosdavenda;
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    String pastadoarquivo   = System.getProperty("user.home") + System.getProperty("file.separator") + "JMarySystems_Print";
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    int arquivo = 1;
    /////////////////////////////////////////
    
    String enderecohtmlfile = "";
    
    StringBuilder sb = new StringBuilder();
    
    public int IDVENDARECEBIDA;
    
    public ControleThread_Print( int IDVENDARECEBIDA2 ){   
        IDVENDARECEBIDA = IDVENDARECEBIDA2;
    } 
            
    public void run(){  
        synchronized ( this ) { try{ Thread.sleep( 1 );
            
            a(); Thread.sleep( 1 ); 
            b(); Thread.sleep( 1 );
            c(); Thread.sleep( 1 );
            d(); Thread.sleep( 1 );
            e(); Thread.sleep( 1 );
            f(); Thread.sleep( 1 );
            g(); 
            
        } catch( Exception e ) {} }  
    }  

    public void a(){ 
        synchronized ( this ) { try{
            
            Venda = new venda.Venda();

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.VENDA WHERE ID = ?", venda.Venda.class );
            q.setParameter(1, IDVENDARECEBIDA );   
                    
            List<venda.Venda> list = q.getResultList();
                    
            for (int i = 0; i < list.size(); i++){
                Venda = list.get(i);
            }
                
        } catch( Exception e ) {} }  
    }
    
    public void b(){ 
        synchronized ( this ) { try{
            
            Clientes = new clientes.Clientes();

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.CLIENTES WHERE ID = ?", clientes.Clientes.class );
            q.setParameter(1, Venda.getIdClientes() );   
                    
            List<clientes.Clientes> list = q.getResultList();
                    
            for (int i = 0; i < list.size(); i++){
                Clientes = list.get(i);
            }
                
        } catch( Exception e ) {} }  
    }
    
    public void c(){ 
        synchronized ( this ) { try{
            
            ListProdutosdavenda = new ArrayList();

            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.PRODUTOSDAVENDA WHERE ID_VENDA = ?", venda.Produtosdavenda.class );
            q.setParameter(1, IDVENDARECEBIDA );   
                    
            List<venda.Produtosdavenda> list = q.getResultList();
                    
            ListProdutosdavenda = list;
                
        } catch( Exception e ) {} }  
    }
    
    public void d(){ 
        synchronized ( this ) { try{
            
            File File_Pasta = new File( pastadoarquivo );
            
            if( File_Pasta.exists() == false ){
                
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.home"), "JMarySystems_Print" );
            }
                
        } catch( Exception e ) {} }  
    }
    
    public void e(){ 
        synchronized ( this ) { try{
            
            enderecohtmlfile = pastadoarquivo + System.getProperty("file.separator") + arquivo + ".txt"; 
            File File_Arquivo = new File( enderecohtmlfile );
            
            if( File_Arquivo.exists() == true ){
                
                arquivo++;
                e();
            }
                
        } catch( Exception e ) {} }  
    }
    
    public void f(){ 
        synchronized ( this ) { try{
                                                
            sb.append( "==========================================" ); sb.append( "\n" );           
            sb.append( "              SKINA DA PIZZA              " ); sb.append( "\n" );
            sb.append( "==========================================" ); sb.append( "\n" );
            sb.append( "********** NAO E DOCUMENTO FISCAL ********" ); sb.append( "\n" );
            sb.append( "==========================================" ); sb.append( "\n" );
            sb.append( "PRODUTO      QTDE      VALOR UN.     VALOR" ); sb.append( "\n" );
            sb.append( "==========================================" ); sb.append( "\n" );
            //dados da tabela  
            for (int i = 0; i < ListProdutosdavenda.size(); i++){
                produtos.Produtos Produtos = new produtos.Produtos();
                    
                try{
                    Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.PRODUTOS WHERE ID = ?", produtos.Produtos.class );
                    q.setParameter(1, ListProdutosdavenda.get(i).getIdProdutos());   
                    
                    List<produtos.Produtos> list = q.getResultList();
                    
                    for (int ie = 0; ie < list.size(); ie++){
                        Produtos = list.get(ie);
                    }
                    
                    try{ sb.append( Produtos.getNome() + " QTDE " + 1                                   ); sb.append( "\n" ); } catch( Exception e ){}
                    try{ sb.append( "VALOR UN. " + Produtos.getCusto() + " VALOR " + Produtos.getCusto() ); sb.append( "\n" ); } catch( Exception e ){}
                    
                } catch( Exception e ){}
            }
            //dados da tabela
            sb.append( "==========================================" );                                               sb.append( "\n" );
            sb.append( "DATA:"+ Venda.getData()                     );                                               sb.append( "\n" );
            sb.append( "==========================================" );                                               sb.append( "\n" );
            sb.append( "========================TOTAL R$: "+ Venda.getTotal() );                                     sb.append( "\n" );
            sb.append( "==========================================" );                                               sb.append( "\n" );
            sb.append( "CLIENTE: " + Clientes.getNome() );                                                           sb.append( "\n" );
            sb.append( "ENDEREÇO: " + Clientes.getEndereco() );                                                      sb.append( "\n" );
            sb.append( "NÚMERO: " + Clientes.getNumero() + " - PONTO REF.: " + Clientes.getPontodereferencia() );    sb.append( "\n" );
            sb.append( "==========================================" );                                               sb.append( "\n" );
            sb.append( "TELEFONE CLIENTE: " + Clientes.getTelefone() );                                              sb.append( "\n" );
            sb.append( "==============SKINA DA PIZZA==============" );                                               sb.append( "\n" );
            sb.append( "==========================================" );                                               sb.append( "\n" );
            sb.append( "ENTREGA EM DOMICÍLIO: ( 85 ) 3269.7237 ===" );                                               sb.append( "\n" );
            sb.append( "==========================================" );                                               sb.append( "\n" );
          
        } catch( Exception e ) {} }  
    }
    
    public void g(){ 
        synchronized ( this ) { try{
            
            PrintService impressoraPadrao = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob dpj = impressoraPadrao.createPrintJob(); 
            
            String txtHtml = sb.toString();            
            InputStream stream = new ByteArrayInputStream((txtHtml + "\n").getBytes());
            
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;    
            Doc doc = new SimpleDoc(stream, flavor, null); 
            
            dpj.print(doc, null); 
                  
        } catch( Exception e ) {} }  
    }
       
      
    /******************Executar Teste*************************************  
     * @param args************************
    public static void main(String[] args) {            
          
        ControleThread_Print t1 = new ControleThread_Print(13); 
        
        t1.setName("ControleThread_Print");   
        
        t1.start();  
    }
    /******************Executar Teste*************************************/
    
}
