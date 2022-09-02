package com.example.calculatorv2.polimorfism;

public class Divide implements Operations {
    @Override
    public int operation(int a, int b) throws Exception{
        if(b == 0) throw new Exception("Error! divide for 0.");
        return a / b;
    }
}
