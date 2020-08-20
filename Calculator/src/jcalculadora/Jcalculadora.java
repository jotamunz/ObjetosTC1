/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcalculadora;

import GUI.FormCalculadora;
import GUI.FormBitacora;
import Clases.Calculadora;

public class Jcalculadora {

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        FormBitacora frmB = new FormBitacora(c);
        FormCalculadora frmC = new FormCalculadora(c, frmB);
        frmC.setVisible(true);
    }
}
