/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_search;

import exercicios.Exercicios_Home;
import java.util.List;
import javax.persistence.Query;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import jpa.JPAUtil;
import utilidades.Alinhar_Tabela_Centro;
import utilidades.JOPM;

/**
 *
 * @author ana
 */
public class Tabela_Pesquisa_BD_Exercicios extends javax.swing.JPanel {
   
    private Exercicios_Home              Exercicios_Home;
    private Menu_Pesquisa_Exercicios     Menu_Pesquisa_Exercicios;
        
    private List<exercicios.Exercicios> list;
    private ListSelectionModel                      lsmPesquisa;
    private final DefaultTableModel                 tmPesquisa = new DefaultTableModel( null, new String[]{ "   ID", "OPÇÃO CORRETA", "Exercicio"} );
    
    public Tabela_Pesquisa_BD_Exercicios( Exercicios_Home Exercicios_Home2 ) {
         
        Exercicios_Home      = Exercicios_Home2;
                
        initComponents();
                 
        tabelaInicio();                        
    }
    
    public void tabela(Menu_Pesquisa_Exercicios Menu_Pesquisa_Exercicios2){ 
                
        try {                
            Menu_Pesquisa_Exercicios = Menu_Pesquisa_Exercicios2;                                    
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabela, \n"
                + e.getMessage() + "\n", "Tabela_Pesquisa_BD_Exercicios" ); }     
    }
    
    private void tabelaInicio(){
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
            
            Query q = JPAUtil.em().createNativeQuery( "SELECT * FROM SCHEMAJMARY.EXERCICIOS", exercicios.Exercicios.class );
            List<exercicios.Exercicios> list = q.getResultList();
            mostrarLista( list );
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabelaInicio(), \n"
                + e.getMessage() + "\n", "Tabela_Pesquisa_BD_Exercicios" ); } } }.start();              
    }
    
    private void tbPreferedSize(){        
        try{
            tbPesquisa.getColumnModel().getColumn(0).setPreferredWidth(55);
            tbPesquisa.getColumnModel().getColumn(0).setWidth(55);
            tbPesquisa.getColumnModel().getColumn(0).setMinWidth(55);
            tbPesquisa.getColumnModel().getColumn(0).setMaxWidth(55);
            
            tbPesquisa.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbPesquisa.getColumnModel().getColumn(1).setWidth(120);
            tbPesquisa.getColumnModel().getColumn(1).setMinWidth(120);
            tbPesquisa.getColumnModel().getColumn(1).setMaxWidth(120);
            
            tbPesquisa.getColumnModel().getColumn(2).setPreferredWidth(190);
            tbPesquisa.getColumnModel().getColumn(2).setWidth(190);
            tbPesquisa.getColumnModel().getColumn(2).setMinWidth(190);
        
            TableCellRenderer tcr = new Alinhar_Tabela_Centro();

            TableColumn column0 = tbPesquisa.getColumnModel().getColumn( 0 );
            column0.setCellRenderer( tcr );
            
            TableColumn column1 = tbPesquisa.getColumnModel().getColumn( 1 );
            column1.setCellRenderer( tcr );
        } catch( Exception e ){}
    }
    
    Query q;
    public void pesquisa(Query q2){
        q = q2;
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
            
            List<exercicios.Exercicios> list = q.getResultList();
            mostrarLista( list );
            
        } catch( Exception e ){ 
            try{ 
                                
                while ( tmPesquisa.getRowCount() > 0){ 
                    tmPesquisa.removeRow(0); 
                } 
            } catch( Exception e2 ){}
            /*JOPM JOPM = new JOPM( 2, "pesquisa(Query q2), \n"
                + e.getMessage() + "\n", "Tabela_Pesquisa_BD_Exercicios" );*/ } } }.start();              
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
        
    public void mostrarLista( List<exercicios.Exercicios> listR ){  try {                    
            
            while ( tmPesquisa.getRowCount() > 0){ tmPesquisa.removeRow(0); }
            if ( listR.isEmpty() ){ 
                list.clear(); 
                Menu_Pesquisa_Exercicios.btExercicios.setEnabled(false);
                //JOptionPane.showMessageDialog( null , "Nenhum dado encontrado!"); 
            }else{ //System.out.println("one");
                String [] campos = new String[] {null, null};
                for (int i = 0; i < listR.size(); i++){
                    tmPesquisa.addRow(campos);
                    tmPesquisa.setValueAt( listR.get(i).getId()             , i, 0);
                    tmPesquisa.setValueAt( listR.get(i).getRespostacerta()  , i, 1);
                    tmPesquisa.setValueAt( listR.get(i).getPergunta()       , i, 2);
                }
                list = listR;
            }    
        } catch( Exception e ){ 
            Menu_Pesquisa_Exercicios.btExercicios.setEnabled(false);
            /*JOPM JOPM = new JOPM( 2, "mostrarLista( List<subcategoria_control.Subcategoria> list2 ), \n"
                + e.getMessage() + "\n", "Tabela_Pesquisa_BD_Exercicios" );*/ } 
    }
    
    private void tbPesquisaLinhaSelecionada() { 
        try{
            if ( tbPesquisa.getSelectedRow() != -1){
                           
                Menu_Pesquisa_Exercicios.IDSELECIONADA = list.get( tbPesquisa.getSelectedRow() ).getId();
                
                Menu_Pesquisa_Exercicios.botoesEstado(true, true, true);
                Menu_Pesquisa_Exercicios.btAlterar    .setEnabled( true );
                Menu_Pesquisa_Exercicios.btExcluir    .setEnabled( true );  
                Menu_Pesquisa_Exercicios.btVisualizar .setEnabled( true );  
            } else{
                      
                Menu_Pesquisa_Exercicios.IDSELECIONADA = -1;  
                Menu_Pesquisa_Exercicios.botoesEstado(false, false, false);
            }
        } catch( Exception e ) {}
    }
        
}
