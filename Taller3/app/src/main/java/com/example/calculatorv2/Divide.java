package com.example.calculatorv2;

public class Divide implements Operations {
    @Override
    public int operation(int a, int b) {
        if(b == 0) throw new Error("Error! divide for 0.");
        return a / b;
    }
}
