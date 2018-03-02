
package br.com.jmary.home;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import utilidades_imagens.Imagens;

public class HomeJApplet extends JApplet {

    @Override
    public void init() {

        add( new Home() ); // BorderLayout.CENTER

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {}
                
                JFrame frame = new JFrame( "SKINA DA PIZZA - JMARYSYSTEMS - Suporte: 85 8623.8463", null );                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new HomeJApplet();
        applet.init();
                
        frame.setContentPane( applet.getContentPane() );
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(null);
                
        iconeDoPrograma( frame );
        telaCheia ( frame );

        applet.start();
            }
        });
    }
    
    public static void iniciarJFrame(){
        main(new String [2]);
    }
    
    private static void telaCheia( JFrame frame ) {
        try{ frame.setUndecorated(true);                                    } catch( Exception e ){}
        try{ frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME); } catch( Exception e ){}
        try{ frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                 } catch( Exception e ){}
    }
    
    /* Início Setando O Ícone do Programa */
    private static void iconeDoPrograma( JFrame frame ) {     
        try{ 
            BufferedImage bufImg = ImageIO.read( Imagens.class.getResource("jmol.png") );  
            /*
            double scale = 0.5;
            BufferedImage bi = new BufferedImage( (int) (scale * bufImg.getWidth()), 
            (int) (scale * bufImg.getHeight() ), BufferedImage.TYPE_INT_ARGB );
            Graphics2D grph = (Graphics2D) bi.getGraphics();
            grph.scale(scale, scale);
            grph.drawImage( bufImg, 0, 0, null);
            grph.dispose();
                        
            String arq = System.getProperty("user.home") + System.getProperty("file.separator") + "JMarySystems_Print"+ System.getProperty("file.separator")+"n"+".png";
            ImageIO.write( bi, "PNG", new File( arq ) );
            */
            //String extension = photoFile.substring(photoFile.lastIndexOf(".") + 1);
                        
            frame.setIconImage( bufImg ); //bi
        }catch( Exception e ){}      
    }
    /* Fim Setando O Ícone do Programa */

}
