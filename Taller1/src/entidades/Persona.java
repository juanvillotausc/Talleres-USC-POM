package entidades;

import javax.swing.*;

public class Persona {
    private double masa;
    private double estatura;

    public Persona(double masa, double estatura) {
        this.masa = masa;
        this.estatura = estatura;
    }

    public void calcularIMC(){

        double imc = (this.masa)/Math.pow(this.estatura, 2);
        imc = Math.round(imc);
        if(imc >= 40){
           JOptionPane.showMessageDialog(null,"Se encuentra en obesidad mórbida: "+ imc);
        }else if(imc >= 30){
            JOptionPane.showMessageDialog(null,"Se encuentra en obesidad: "+ imc);
        } else if (imc >= 25) {
            JOptionPane.showMessageDialog(null,"Se encuentra en sobrepeso: "+ imc);
        } else if (imc >= 18.5) {
            JOptionPane.showMessageDialog(null,"Se encuentra en peso normal: "+ imc);
        }else {
            JOptionPane.showMessageDialog(null,"Se encuentra en peso bajo: "+ imc);
        }

    }
}
