package org.itstep.entity;

public class MathOperation {

    public static double execute(double a, double b, char op){

        switch (op){
            case '+':
                return  a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

}
