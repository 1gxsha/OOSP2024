package controller;

import model.EquationModel;
import view.EquationView;

import java.util.Scanner;

public class EquationController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше уравнение: ");
        String equation = scanner.nextLine();
        EquationModel equationModel = new EquationModel(equation);
        double result = equationModel.evaluateEquation();
        EquationView.displayResult(result);
    }
}
