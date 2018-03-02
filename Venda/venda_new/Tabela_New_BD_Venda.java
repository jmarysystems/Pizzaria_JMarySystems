/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package venda_new;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import jpa.JPAUtil;
import utilidades.Alinhar_Tabela_Centro;
import utilidades.Alinhar_Tabela_Direita;
import utilidades.JOPM;
import venda.Venda_Home;

/**
 *
 * @author ana
 */
public class Tabela_New_BD_Venda extends javax.swing.JPanel {
   
    private Venda_Home   Venda_Home;
    private Venda_New    Venda_New;
        
    private List<venda.Produtosdavenda> list = new ArrayList(); 
    private ListSelectionModel               lsmPesquisa;
                                                                                                                                                                                             // 
    public final DefaultTableModel          tmPesquisa = new DefaultTableModel( null, new String[]{ "     ID","CÓDIGO DO PRODUTO","DESCRIÇÃO DO PRODUTO","VALOR R$" } ) {
        
        Class[] types = new Class [] {
            java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        };
        
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };
        
        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    };
    
    public Tabela_New_BD_Venda( Venda_Home Venda_Home2, Venda_New Venda_New2 ) {
        
        Venda_Home      = Venda_Home2;
        Venda_New       = Venda_New2;
                
        initComponents();
        
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            tbPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lsmPesquisa = tbPesquisa.getSelectionModel();
            lsmPesquisa.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (! e.getValueIsAdjusting()){
                        tbPesquisaLinhaSelecionada();
                    }
                }
            });
                                    
            tbPreferedSize();
            tabelaInicio(); 
            
        } catch( Exception e ){ /*JOPM JOPM = new JOPM( 2, "tabelaInicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() );*/ } } }.start();                                        
    }
    
    public void tabela(Venda_New Venda_New2){ 
                
        try {              
            Venda_New = Venda_New2;                                    
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabela, \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); }     
    }
    
    private void tabelaInicio(){
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
                    
            /*
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.GESTORDECOMPRAS", gestor.Venda.class );
            list = q.getResultList();
            
            mostrarLista( list );*/
            
        } catch( Exception e ){ /*JOPM JOPM = new JOPM( 2, "tabelaInicio(), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() );*/ } } }.start();              
    }
    
    private void tbPreferedSize(){        
        try{
            TableCellRenderer tcrC = new Alinhar_Tabela_Centro();
            TableCellRenderer tcrD = new Alinhar_Tabela_Direita();
            
            tbPesquisa.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbPesquisa.getColumnModel().getColumn(0).setResizable(false);
            tbPesquisa.getColumnModel().getColumn(0).setCellRenderer( tcrC );
            
            tbPesquisa.getColumnModel().getColumn(1).setPreferredWidth(145);
            tbPesquisa.getColumnModel().getColumn(1).setResizable(false);
            
            tbPesquisa.getColumnModel().getColumn(2).setPreferredWidth(310);
            tbPesquisa.getColumnModel().getColumn(2).setResizable(false);
                        
            tbPesquisa.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbPesquisa.getColumnModel().getColumn(3).setResizable(true);
            tbPesquisa.getColumnModel().getColumn(3).setCellRenderer( tcrD );
                    
            tbPesquisa.setRowHeight(30);
            tbPesquisa.setSelectionBackground(Color.YELLOW);
            tbPesquisa.setSelectionForeground(Color.BLUE);
            
            tbPesquisa.getTableHeader().setReorderingAllowed(false);
            tbPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
        } catch( Exception e ){}
    }
    
    Query q;
    public void pesquisa(Query q2){
        q = q2;
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            list = q.getResultList();                        
            mostrarLista( list );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "pesquisa(Query q2), \n"
                + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();              
    }
                
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPesquisa = new javax.swing.JTable();

        jScrollPane1.setBorder(null);

        tbPesquisa.setModel(tmPesquisa);
        jScrollPane1.setViewportView(tbPesquisa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbPesquisa;
    // End of variables declaration//GEN-END:variables
        
    public void mostrarLista( List<venda.Produtosdavenda> listR ){  try {  
        
            list = listR;
            
            while ( tmPesquisa.getRowCount() > 0){ tmPesquisa.removeRow(0); }
            if ( listR.isEmpty() ){ //JOptionPane.showMessageDialog( null , "Nenhum dado encontrado!"); 
            }else{
                String [] campos = new String[] {null, null};
                for (int i = 0; i < listR.size(); i++){
                    tmPesquisa.addRow(campos);
                    
                    produtos.Produtos Produtos = new produtos.Produtos();
                    
                    try{
                        Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.PRODUTOS WHERE ID = ?", produtos.Produtos.class );
                        q.setParameter(1, listR.get(i).getIdProdutos());   
                    
                        List<produtos.Produtos> list = q.getResultList();
                    
                        for (int ie = 0; ie < list.size(); ie++){
                            Produtos = list.get(ie);
                        }
                    } catch( Exception e ){}     
      
                    try{ tmPesquisa.setValueAt( Produtos.getId()         , i, 0); } catch( Exception e ){}
                    try{ tmPesquisa.setValueAt( Produtos.getCodigo()     , i, 1); } catch( Exception e ){}
                    try{ tmPesquisa.setValueAt( Produtos.getNome()       , i, 2); } catch( Exception e ){} 
                    try{ tmPesquisa.setValueAt( Produtos.getCusto()      , i, 3); } catch( Exception e ){}
                
                }
            }    
        } catch( Exception e ){ /*JOPM JOPM = new JOPM( 2, "mostrarLista( List<materias_control.Materia> list2 ), \n"
                + e.getMessage() + "\n", "Tabela_Pesquisa_BD_Usuario" );*/ } 
    }
    
    public void mostrarLista2( produtos.Produtos Produtos2 ){ try {                    

        int nCols = tmPesquisa.getColumnCount();
        Object[] linha = new Object[nCols] ;  
        
        int i = tmPesquisa.getRowCount();
        
        //System.out.println( "nLinhas - " + i);
        try{ tmPesquisa.getRowCount(); } catch( Exception e ){}
        
        tmPesquisa.addRow( linha ); 
        
        tmPesquisa.setValueAt( Produtos2.getId()        , i, 0);                    
        tmPesquisa.setValueAt( Produtos2.getCodigo()    , i, 1);                    
        tmPesquisa.setValueAt( Produtos2.getNome()      , i, 2);  
        tmPesquisa.setValueAt( Produtos2.getCusto()     , i, 3);
        
        } catch( Exception e ){} 
    }
    
    private void tbPesquisaLinhaSelecionada() {
        new Thread() {   @Override public void run() { try {  

            if ( tbPesquisa.getSelectedRow() != -1){
                                                           
                Venda_New.IDSELECIONADA = list.get( tbPesquisa.getSelectedRow() ).getId();
                                
                //if( Usuario_Permissoes.booAlterarprodutoporfornecedor(Usuario_Logado.ID ) == true ) { Gestor_New.btAlterar.setEnabled(true);  }

                //if( Usuario_Permissoes.booExcluirprodutoporfornecedor( Usuario_Logado.ID ) == true ) { Gestor_New.btExcluir    .setEnabled(true); }
                
            } else{
                      
                Venda_New.IDSELECIONADA = -1;  
                /*
                Gestor_New.btAlterar   .setEnabled(false);
                Gestor_New.btExcluir   .setEnabled(false);*/
            }                  
        } catch( Exception e ){} } }.start();   
    }
        
}
