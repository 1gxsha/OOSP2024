import java.util.Scanner;

public class CalculatorView {
    public String takeUserInput() {
        System.out.println("Введите выражение (числа и операторы через пробел): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showResult(double result) {
        System.out.println("Результат: " + result);
    }

    public String getUserInput() {
        System.out.println("Введите данные: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayResult(double result) {
        System.out.println("Полученный результат: " + result);
    }
}