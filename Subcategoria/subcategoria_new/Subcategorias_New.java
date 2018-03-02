/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subcategoria_new;

import categorias_new.BookInfoMateria;
import java.awt.Color;
import subcategoria.Subcategorias_Home;
import utilidades.Alterar_Propriedades;
import utilidades.JFileChooserJM;

/**
 *
 * @author AnaMariana
 */
public class Subcategorias_New extends javax.swing.JPanel {

    Subcategorias_Home              Subcategorias_Home;
    public Subcategorias_New_Inicio Inicio;
    
    /**
     * Creates new form Cliente
     * @param Subcategorias_Home2
     */
    public Subcategorias_New( Subcategorias_Home Subcategorias_Home2 ) {
        initComponents();
        
        Subcategorias_Home = Subcategorias_Home2;
        
        Inicio = new Subcategorias_New_Inicio(this); 
        
        jpPgHtml.setVisible( false );
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public subcategoria.Subcategoria Subcategoria;
    public Subcategorias_New( Subcategorias_Home Subcategorias_Home2, subcategoria.Subcategoria Subcategoria2 ) {
        initComponents();
        
        Subcategorias_Home  = Subcategorias_Home2;
        
        Subcategoria = Subcategoria2;        
        Inicio = new Subcategorias_New_Inicio( this, Subcategoria2 );
        
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
        cbMateria = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jpStatus = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jpPgHtml = new javax.swing.JPanel();
        tfPaHtml = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Dados da subcategoria");

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
        jLabel2.setText("Subcategoria");

        cbMateria.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbMateria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        cbMateria.setPreferredSize(new java.awt.Dimension(212, 23));
        cbMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbMateriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbMateriaMouseExited(evt);
            }
        });
        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Matéria");

        cbCategoria.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        cbCategoria.setPreferredSize(new java.awt.Dimension(212, 23));
        cbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbCategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbCategoriaMouseExited(evt);
            }
        });
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMateria, 0, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addGap(23, 23, 23))))
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
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpStatusLayout = new javax.swing.GroupLayout(jpStatus);
        jpStatus.setLayout(jpStatusLayout);
        jpStatusLayout.setHorizontalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap())
        );

        jpStatusLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAtualizar, btSalvar});

        jpStatusLayout.setVerticalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btAtualizar))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jpPgHtml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPgHtml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Inicio.salvar( new subcategoria.Subcategoria(), false );
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyReleased
        evtBotaoSalvar();
    }//GEN-LAST:event_tfNomeKeyReleased

    private void tfNomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseEntered
        tfNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tfNome.setForeground(new java.awt.Color(0, 0, 204));
        
        tfNome.setBackground(Color.YELLOW);
        tfNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));      
    }//GEN-LAST:event_tfNomeMouseEntered

    private void tfNomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseExited
        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNome.setForeground(new java.awt.Color(0, 0, 0));
        
        tfNome.setBackground(Color.WHITE);        
        tfNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));                   
    }//GEN-LAST:event_tfNomeMouseExited

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        try{
            
            if( cbMateria.getItemCount() > 0 ) {
                
                BookInfoMateria obj = (BookInfoMateria) cbMateria.getSelectedItem();
                
                subcategoria.Subcategoria Subcategoria2 = new subcategoria.Subcategoria();
                Subcategoria2.setIdMateria(obj.ID);
                
                Inicio.setarCBCategoria(false, Subcategoria2 );                
            }
        }
        catch( Exception e ){}
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        Inicio.setarCBMateria(false,new subcategoria.Subcategoria());
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        try{
            //MeuObjeto obj = (MeuObjeto) combobox.getSelectedItem();
            BookInfoCategoria obj = (BookInfoCategoria) cbCategoria.getSelectedItem();
            evtBotaoSalvar();
            //System.out.println( "obj.ID "+obj.ID );
        }
        catch( Exception e ){}
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void tfPaHtmlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMouseEntered
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfPaHtml, true );
    }//GEN-LAST:event_tfPaHtmlMouseEntered

    private void tfPaHtmlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMouseExited
        Alterar_Propriedades A_P = new Alterar_Propriedades( tfPaHtml, false );
    }//GEN-LAST:event_tfPaHtmlMouseExited

    private void tfPaHtmlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPaHtmlMousePressed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            JFileChooserJM JFileChooserJM = new JFileChooserJM( "  html    -   jmarysystems.blogspot.com.br", new String [] { "HTM" , "HTML" } );
            tfPaHtml.setText( JFileChooserJM.getString( 2 )  );

        } catch( Exception e ){ } } }.start();
    }//GEN-LAST:event_tfPaHtmlMousePressed

    private void tfPaHtmlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPaHtmlKeyReleased
        evtBotaoSalvar();
    }//GEN-LAST:event_tfPaHtmlKeyReleased

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            JFileChooserJM JFileChooserJM = new JFileChooserJM( "  html    -   jmarysystems.blogspot.com.br", new String [] { "HTM" , "HTML" } );
            tfPaHtml.setText( JFileChooserJM.getString( 2 )  );

        } catch( Exception e ){ } } }.start();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void cbMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMateriaMouseEntered
        Alterar_Propriedades A_P = new Alterar_Propriedades( cbMateria, true );
    }//GEN-LAST:event_cbMateriaMouseEntered

    private void cbMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMateriaMouseExited
        Alterar_Propriedades A_P = new Alterar_Propriedades( cbMateria, false );
    }//GEN-LAST:event_cbMateriaMouseExited

    private void cbCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCategoriaMouseEntered
        Alterar_Propriedades A_P = new Alterar_Propriedades( cbCategoria, true );
    }//GEN-LAST:event_cbCategoriaMouseEntered

    private void cbCategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCategoriaMouseExited
        Alterar_Propriedades A_P = new Alterar_Propriedades( cbCategoria, false );
    }//GEN-LAST:event_cbCategoriaMouseExited
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAtualizar;
    public javax.swing.JButton btPesquisar;
    public javax.swing.JButton btSalvar;
    public javax.swing.JComboBox cbCategoria;
    public javax.swing.JComboBox cbMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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