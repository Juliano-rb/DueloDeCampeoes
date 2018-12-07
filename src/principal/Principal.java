/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import guerreiro.*;
import arma.*;
import principal.GUI.MainWindow;
import java.util.Scanner;


/**
 *
 * @author Juliano
 */
public class Principal {
    public static void main(String[] args){
        /*
        * O conector é usado como um intermedio para os objetos se comunicarem com a interface indiretamente (via
        * mensagens). Com isso é gerado o encapsulamento da interface e modificando o conector pode-se criar tanto
        * programas de linha de comando quanto de interface facilmente
        *
        */
        Conector conector = new Conector(false,false);
        

        MainWindow janelaPrincipal = new MainWindow(conector);
        janelaPrincipal.setVisible(true);

        conector.setOutGUI(janelaPrincipal);
    }
}
