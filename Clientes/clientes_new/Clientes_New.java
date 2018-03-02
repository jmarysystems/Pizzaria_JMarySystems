package clientes_new;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import clientes.Clientes_Home;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import utilidades.JOPM;

/**
 *
 * @author pc
 */
public class Clientes_New extends javax.swing.JPanel {
    
    Clientes_Home              Clientes_Home;
    public Clientes_New_Inicio Inicio;

    /**
     * Creates new form Fornecedor_New
     */
    public Clientes_New(Clientes_Home Clientes_Home2) {
        initComponents();
        
        Clientes_Home       = Clientes_Home2;
        Inicio = new Clientes_New_Inicio( this );
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public clientes.Clientes Clientes;
    public Clientes_New(Clientes_Home Clientes_Home2, clientes.Clientes Clientes2 ) {
        initComponents();
        
        Clientes_Home  = Clientes_Home2;
        
        Clientes = Clientes2;
        
        Inicio = new Clientes_New_Inicio( this, Clientes2 );
        
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
        tfNomeDaCategoriaDoProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jpPermitirAcesso1 = new javax.swing.JPanel();
        tfEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfPontodereferencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        jpPermitirAcesso2 = new javax.swing.JPanel();
        tfObs = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Dados do Cliente");

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

        tfNomeDaCategoriaDoProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNomeDaCategoriaDoProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfNomeDaCategoriaDoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfNomeDaCategoriaDoProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfNomeDaCategoriaDoProdutoMouseExited(evt);
            }
        });
        tfNomeDaCategoriaDoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomeDaCategoriaDoProdutoKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Nome ");

        tfEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEndereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfEndereco.setPreferredSize(new java.awt.Dimension(247, 23));
        tfEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfEnderecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfEnderecoMouseExited(evt);
            }
        });
        tfEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEnderecoKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Endereço");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfNumero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfNumero.setPreferredSize(new java.awt.Dimension(185, 23));
        tfNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfNumeroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfNumeroMouseExited(evt);
            }
        });
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNumeroKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Número");

        javax.swing.GroupLayout jpPermitirAcessoLayout = new javax.swing.GroupLayout(jpPermitirAcesso);
        jpPermitirAcesso.setLayout(jpPermitirAcessoLayout);
        jpPermitirAcessoLayout.setHorizontalGroup(
            jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNomeDaCategoriaDoProduto)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpPermitirAcessoLayout.setVerticalGroup(
            jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPermitirAcessoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPermitirAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPermitirAcessoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(tfNomeDaCategoriaDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        tfEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfEmailMouseExited(evt);
            }
        });
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEmailKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("E-mail");

        tfPontodereferencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfPontodereferencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfPontodereferencia.setPreferredSize(new java.awt.Dimension(247, 23));
        tfPontodereferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfPontodereferenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfPontodereferenciaMouseExited(evt);
            }
        });
        tfPontodereferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPontodereferenciaKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Ponto de Referência");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Telefone");

        tfTelefone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setPreferredSize(new java.awt.Dimension(185, 23));
        tfTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTelefoneFocusLost(evt);
            }
        });
        tfTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfTelefoneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfTelefoneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpPermitirAcesso1Layout = new javax.swing.GroupLayout(jpPermitirAcesso1);
        jpPermitirAcesso1.setLayout(jpPermitirAcesso1Layout);
        jpPermitirAcesso1Layout.setHorizontalGroup(
            jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermitirAcesso1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEmail)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPontodereferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPermitirAcesso1Layout.setVerticalGroup(
            jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPermitirAcesso1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPermitirAcesso1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(24, 24, 24))
                    .addGroup(jpPermitirAcesso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpPermitirAcesso1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(2, 2, 2)
                            .addComponent(tfPontodereferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpPermitirAcesso1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(2, 2, 2)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        tfObs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfObs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfObs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfObsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfObsMouseExited(evt);
            }
        });
        tfObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfObsKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Obsevação");

        javax.swing.GroupLayout jpPermitirAcesso2Layout = new javax.swing.GroupLayout(jpPermitirAcesso2);
        jpPermitirAcesso2.setLayout(jpPermitirAcesso2Layout);
        jpPermitirAcesso2Layout.setHorizontalGroup(
            jpPermitirAcesso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermitirAcesso2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermitirAcesso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfObs, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPermitirAcesso2Layout.setVerticalGroup(
            jpPermitirAcesso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPermitirAcesso2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addComponent(tfObs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jpStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpPermitirAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPermitirAcesso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPermitirAcesso2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPermitirAcesso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPermitirAcesso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Inicio.salvar( new clientes.Clientes(), false );
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfNomeDaCategoriaDoProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeDaCategoriaDoProdutoMouseEntered
        mouseEntra( tfNomeDaCategoriaDoProduto );
    }//GEN-LAST:event_tfNomeDaCategoriaDoProdutoMouseEntered

    private void tfNomeDaCategoriaDoProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeDaCategoriaDoProdutoMouseExited
        mouseSai( tfNomeDaCategoriaDoProduto );
    }//GEN-LAST:event_tfNomeDaCategoriaDoProdutoMouseExited

    private void tfNomeDaCategoriaDoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeDaCategoriaDoProdutoKeyReleased
      
    }//GEN-LAST:event_tfNomeDaCategoriaDoProdutoKeyReleased

    private void tfEnderecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEnderecoMouseEntered
        mouseEntra( tfEndereco );
    }//GEN-LAST:event_tfEnderecoMouseEntered

    private void tfEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEnderecoMouseExited
        mouseSai( tfEndereco );
    }//GEN-LAST:event_tfEnderecoMouseExited

    private void tfEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEnderecoKeyReleased

    private void tfTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTelefoneFocusGained
        setarFocusGainedTelefone( tfTelefone );
    }//GEN-LAST:event_tfTelefoneFocusGained

    private void tfTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTelefoneFocusLost
        setarFocusLostTelefone( tfTelefone );
    }//GEN-LAST:event_tfTelefoneFocusLost

    private void tfEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEmailMouseEntered
        mouseEntra( tfEmail );
    }//GEN-LAST:event_tfEmailMouseEntered

    private void tfEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEmailMouseExited
        mouseSai( tfEmail );
    }//GEN-LAST:event_tfEmailMouseExited

    private void tfEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailKeyReleased

    private void tfPontodereferenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPontodereferenciaMouseEntered
        mouseEntra( tfPontodereferencia );
    }//GEN-LAST:event_tfPontodereferenciaMouseEntered

    private void tfPontodereferenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPontodereferenciaMouseExited
        mouseSai( tfPontodereferencia );
    }//GEN-LAST:event_tfPontodereferenciaMouseExited

    private void tfPontodereferenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPontodereferenciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPontodereferenciaKeyReleased

    private void tfNumeroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNumeroMouseEntered
        mouseEntra( tfNumero );
    }//GEN-LAST:event_tfNumeroMouseEntered

    private void tfNumeroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNumeroMouseExited
        mouseSai( tfNumero );
    }//GEN-LAST:event_tfNumeroMouseExited

    private void tfNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroKeyReleased

    private void tfObsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfObsMouseEntered
        mouseEntra( tfObs );
    }//GEN-LAST:event_tfObsMouseEntered

    private void tfObsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfObsMouseExited
        mouseSai( tfObs );
    }//GEN-LAST:event_tfObsMouseExited

    private void tfObsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfObsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfObsKeyReleased

    private void tfTelefoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfTelefoneMouseEntered
        mouseEntra( tfTelefone );
    }//GEN-LAST:event_tfTelefoneMouseEntered

    private void tfTelefoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfTelefoneMouseExited
        mouseSai( tfTelefone );
    }//GEN-LAST:event_tfTelefoneMouseExited


    private void setarFocusGainedTelefone( JFormattedTextField ftm ) {
        if( ftm.getText().trim().equals("") || ftm.getText().trim().equals("+    (    )      -") ){   
            
            try {
                
                MaskFormatter mascaraTelefone = new MaskFormatter("+ ## ( ## ) #### - ####");
                mascaraTelefone.setValidCharacters("0123456789");
                
                ftm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory( mascaraTelefone ) );                
            } catch ( Exception e ) {
                JOPM JOPM = new JOPM( 2, "Erro ao setar Máscara, "
                        +"\n" + e.toString()
                                , "Erro ao setar Máscara" );
                        ftm.requestFocus();
            }
            ftm.setText( "5585" );            
        }                
    } 
    
    public void setarFocusLostTelefone( JFormattedTextField ftm ) {
                
        if( !ftm.getText().trim().equals("") ){  
            
            if( ftm.getText().trim().length() < 23 ){ ftm.setValue( "" );
                
                try {                    
                    MaskFormatter mascaraTelefone = new MaskFormatter(""); 
                    ftm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory( mascaraTelefone ) );
                    ftm.setText( "" ); 
                } catch ( Exception e ) {
                    JOPM JOPM = new JOPM( 2, "Erro ao setar Máscara, "
                        +"\n" + e.toString()
                                , "Erro ao setar Máscara" );
                        ftm.requestFocus();
                }
            }
        }              
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAtualizar;
    public javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpPermitirAcesso;
    private javax.swing.JPanel jpPermitirAcesso1;
    private javax.swing.JPanel jpPermitirAcesso2;
    private javax.swing.JPanel jpStatus1;
    public javax.swing.JTextField tfEmail;
    public javax.swing.JTextField tfEndereco;
    public javax.swing.JTextField tfNomeDaCategoriaDoProduto;
    public javax.swing.JTextField tfNumero;
    public javax.swing.JTextField tfObs;
    public javax.swing.JTextField tfPontodereferencia;
    public javax.swing.JFormattedTextField tfTelefone;
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