/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicios_visualizar;

import exercicios.Exercicios;
import exercicios.Exercicios_Home;
import exercicios_atualizar.Exercicios_Atualizar;


/**
 *
 * @author pc
 */
public class Exercicios_Visualizar extends Exercicios_Atualizar{

    public Exercicios_Visualizar( Exercicios_Home Exercicios_Home2, Exercicios Exercicios2) {
        super(Exercicios_Home2, Exercicios2, "Visualizar");
        
        
        Exercicios_New.btSalvar.setVisible(false);
        Exercicios_New.btAtualizar.setVisible(false);
                
    }
    
}
