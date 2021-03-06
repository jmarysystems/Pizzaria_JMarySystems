/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produtos_new;

import java.awt.Color;
import produtos.Produtos_Home;

/**
 *
 * @author pc
 */
public class Produtos_New extends javax.swing.JPanel {
    
    Produtos_Home              Produtos_Home;
    public Produtos_New_Inicio Inicio;

    /**
     * Creates new form Fornecedor_New
     */
    public Produtos_New(Produtos_Home Produtos_Home2) {
        initComponents();
        
        Produtos_Home       = Produtos_Home2;
        Inicio = new Produtos_New_Inicio( this );
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public produtos.Produtos Produtos;
    public Produtos_New(Produtos_Home Produtos_Home2, produtos.Produtos Produtos2 ) {
        initComponents();
        
        Produtos_Home  = Produtos_Home2;
        
        Produtos = Produtos2;
        
        Inicio = new Produtos_New_Inicio( this, Produtos2 );
        
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
        jpStatus1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jpPermitirAcesso = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Dados do Produto");

        jpStatus1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(201, 239, 237)));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades_imagens/salvar.gif"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(91, 27));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades_imagens/atualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setEnabled(false);

        javax.swing.GroupLayout jpStatus1Layout = new javax.swing.GroupLayout(jpStatus1);
        jpStatus1.setLayout(jpStatus1Layout);
        jpStatus1Layout.setHorizontalGroup(
            jpStatus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatus1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap())
        );
        jpStatus1Layout.setVerticalGroup(
            jpStatus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatus1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpStatus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar)))
        );

        tfNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Descrição do Produto");

        tfCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfCodigoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfCodigoMouseExited(evt);
            }
        });
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Código");

        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfValorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfValorMouseExited(evt);
            }
        });
        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Valor R$");

        javax.swing.GroupLayout jpPermitirAcessoLayout = new javax.swing.GroupLayout(jpPermitirAcesso);
        jpPermitirAcesso.setLayout(jpPermitirAcessoLayout);
        jpPermitirAcessoLayout.setHorizontalGroup(
            jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPermitirAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCodigo)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfValor)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jpPermitirAcessoLayout.setVerticalGroup(
            jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPermitirAcessoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(2, 2, 2)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(2, 2, 2)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jpStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpPermitirAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpPermitirAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Inicio.salvar( new produtos.Produtos(), false );
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfNomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseEntered
        mouseEntra(tfNome );
    }//GEN-LAST:event_tfNomeMouseEntered

    private void tfNomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseExited
        mouseSai(tfNome );
    }//GEN-LAST:event_tfNomeMouseExited

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyReleased
      
    }//GEN-LAST:event_tfNomeKeyReleased

    private void tfCodigoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodigoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoMouseEntered

    private void tfCodigoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodigoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoMouseExited

    private void tfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoKeyReleased

    private void tfValorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfValorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorMouseEntered

    private void tfValorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfValorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorMouseExited

    private void tfValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyReleased
        String caracteres=".0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            tfValor.setText("");
        }
    }//GEN-LAST:event_tfValorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAtualizar;
    public javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpPermitirAcesso;
    private javax.swing.JPanel jpStatus1;
    public javax.swing.JTextField tfCodigo;
    public javax.swing.JTextField tfNome;
    public javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

    private void mouseEntra(javax.swing.JComponent c) {                                                  
        try{
            c.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            c.setForeground(new java.awt.Color(0, 0, 204));

            c.setBackground(Color.YELLOW);
            c.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        }catch(Exception e ){}
    }
    
    private void mouseSai(javax.swing.JComponent c) {                                                  
        try{
            c.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
            c.setForeground(new java.awt.Color(0, 0, 0));

            c.setBackground(Color.WHITE);
            c.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        }catch(Exception e ){}
    }
        
}