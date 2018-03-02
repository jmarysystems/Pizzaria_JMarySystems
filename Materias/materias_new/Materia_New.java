/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package materias_new;

import materias.Materias_Home;
import utilidades.Alterar_Propriedades;
import utilidades.JFileChooserJM;

/**
 *
 * @author AnaMariana
 */
public class Materia_New extends javax.swing.JPanel {

    Materias_Home Materias_Home;
    Materia_New_Inicio Inicio;
    
    /**
     * Creates new form Cliente
     * @param Materias_Home2
     */
    public Materia_New( Materias_Home Materias_Home2 ) {
        initComponents();
        
        Materias_Home = Materias_Home2;
        Inicio = new Materia_New_Inicio( this );
        
        jpPgHtml.setVisible( false );
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public materias.Materia Materia;
    public Materia_New( Materias_Home Materias_Home2, materias.Materia Materia2 ) {
        initComponents();
        
        Materias_Home  = Materias_Home2;
        
        Materia = Materia2;        
        Inicio = new Materia_New_Inicio( this, Materia2 );
        
        jpPgHtml.setVisible( true );
    }
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpStatus = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jpPgHtml = new javax.swing.JPanel();
        tfPaHtml = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Dados da matéria");

        tfNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tfNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfNomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfNomeMouseExited(evt);
            }
        });
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Matéria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addComponent(tfNome))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(201, 239, 237)));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades_imagens/salvar.gif"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.setPreferredSize(new java.awt.Dimension(91, 27));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades_imagens/atualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setEnabled(false);

        javax.swing.GroupLayout jpStatusLayout = new javax.swing.GroupLayout(jpStatus);
        jpStatus.setLayout(jpStatusLayout);
        jpStatusLayout.setHorizontalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap())
        );

        jpStatusLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAtualizar, btSalvar});

        jpStatusLayout.setVerticalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar)))
        );

        jpStatusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAtualizar, btSalvar});

        tfPaHtml.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tfPaHtml.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfPaHtml.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfPaHtmlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfPaHtmlMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfPaHtmlMousePressed(evt);
            }
        });
        tfPaHtml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPaHtmlKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Página HTML");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades_imagens/pesquisar.gif"))); // NOI18N
        btPesquisar.setText("Localizar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPgHtmlLayout = new javax.swing.GroupLayout(jpPgHtml);
        jpPgHtml.setLayout(jpPgHtmlLayout);
        jpPgHtmlLayout.setHorizontalGroup(
            jpPgHtmlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPgHtmlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPgHtmlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPgHtmlLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpPgHtmlLayout.createSequentialGroup()
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPaHtml)))
                .addContainerGap())
        );
        jpPgHtmlLayout.setVerticalGroup(
            jpPgHtmlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPgHtmlLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPgHtmlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(tfPaHtml, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jpPgHtmlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btPesquisar, tfPaHtml});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jpStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jpPgHtml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPgHtml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Inicio.salvar( new materias.Materia(), false );
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyReleased
        evtBotaoSalvar();
    }//GEN-LAST:event_tfNomeKeyReleased

    private void tfNomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseEntered
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfNome, true );                                    
    }//GEN-LAST:event_tfNomeMouseEntered

    private void tfNomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseExited
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfNome, false );                 
    }//GEN-LAST:event_tfNomeMouseExited

    private void tfPaHtmlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMouseEntered
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfPaHtml, true );
    }//GEN-LAST:event_tfPaHtmlMouseEntered

    private void tfPaHtmlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMouseExited
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfPaHtml, false );
    }//GEN-LAST:event_tfPaHtmlMouseExited

    private void tfPaHtmlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPaHtmlKeyReleased
        evtBotaoSalvar();
    }//GEN-LAST:event_tfPaHtmlKeyReleased

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            JFileChooserJM JFileChooserJM = new JFileChooserJM( "  html    -   jmarysystems.blogspot.com.br", new String [] { "HTM" , "HTML" } );
            tfPaHtml.setText( JFileChooserJM.getString( 2 )  );
            
        } catch( Exception e ){ } } }.start();   
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfPaHtmlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 ); 
        
            JFileChooserJM JFileChooserJM = new JFileChooserJM( "  html    -   jmarysystems.blogspot.com.br", new String [] { "HTM" , "HTML" } );
            tfPaHtml.setText( JFileChooserJM.getString( 2 )  );
            
        } catch( Exception e ){ } } }.start();   
    }//GEN-LAST:event_tfPaHtmlMousePressed

    
        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAtualizar;
    public javax.swing.JButton btPesquisar;
    public javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpPgHtml;
    private javax.swing.JPanel jpStatus;
    public javax.swing.JTextField tfNome;
    public javax.swing.JTextField tfPaHtml;
    // End of variables declaration//GEN-END:variables
        
    private void evtBotaoSalvar(){
        
        if( !tfNome.getText().trim().equals( "" ) ){
            
            btSalvar.setEnabled( true );
        }        
        else{
            
            btSalvar.setEnabled( false );
        }
    }
    
}
