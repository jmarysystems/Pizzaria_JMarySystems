package exercicios;

import br.com.jmary.home.Home;
import javax.swing.JTabbedPane;

/**
 *
 * @author AnaMariana
 */
public class Exercicios_Home extends javax.swing.JPanel {
    
    public Home                        Home;      
    public Exercicios_Home_Inicio      Inicio;    
    public JTabbedPane                 tabHome;
    public Conjunto_Botoes_Exercicios  Conjunto_Botoes_Exercicios;

    /**
     * Creates new form Cliente
     * @param Home2
     */
    public Exercicios_Home( Home Home2 ) {        
        initComponents();
       
        Home                        = Home2;
        tabHome                     = new JTabbedPane();
        Conjunto_Botoes_Exercicios  = new Conjunto_Botoes_Exercicios( this );
        
        Inicio                      = new Exercicios_Home_Inicio(this);                        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHome = new javax.swing.JPanel();

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel pnHome;
    // End of variables declaration//GEN-END:variables
             
}
