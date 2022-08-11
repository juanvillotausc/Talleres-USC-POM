package test;

import entidades.Persona;

import javax.swing.*;

public class TestIMC {

    public static void main(String[] args) {

       Double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso en kilogramos"));
       Double estatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su estatura en metros"));

        Persona p1 = new Persona(peso,estatura);

        p1.calcularIMC();

    }
}
