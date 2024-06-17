package model;

public class EquationModel {
    private String[] stack;
    private int currentPosition;

    public EquationModel(String line) {
        this.stack = line.split(" ");
        this.currentPosition = 0;
    }

    public double evaluateEquation() {
        double result = getPriority();
        while (currentPosition < stack.length) {
            String operator = stack[currentPosition];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                currentPosition++;
            }
            double operand = getPriority();
            if (operator.equals("+")) {
                result += operand;
            } else {
                result -= operand;
            }
        }
        return result;
    }

    private double getPriority() {
        double firstOperand = getOperator();
        while (currentPosition < stack.length) {
            String operator = stack[currentPosition];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("//") && !operator.equals("^") && !operator.equals("")) {
                break;
            } else {
                currentPosition++;
            }
            double secondOperand = getOperator();
            if (operator.equals("*")) {
                firstOperand *= secondOperand;
            } else if (operator.equals("/")) {
                firstOperand /= secondOperand;
            } else if (operator.equals("//")) {
                firstOperand %= secondOperand;
            } else if (operator.equals("^") || operator.equals("")) {
                firstOperand = Math.pow(firstOperand, secondOperand);
            }
        }
        return firstOperand;
    }

    private double getOperator() {
        String nextToken = stack[currentPosition];
        if (nextToken.equals("(")) {
            currentPosition++;
            double result = evaluateEquation();
            String closingBracket;
            if (currentPosition < stack.length) {
                closingBracket = stack[currentPosition];
            } else {
                throw new IllegalArgumentException("Missing closing bracket");
            }
            if (closingBracket.equals(")")) {
                currentPosition++;
                return result;
            }
            throw new IllegalArgumentException("Invalid expression");
        } else if (nextToken.equals("log")) {
            currentPosition++;
            double argument = getOperator();
            return Math.log(argument) / Math.log(2);
        } else if (nextToken.equals("exp")) {
            currentPosition++;
            double argument = getOperator();
            return Math.exp(argument);
        } else if (nextToken.equals("!")) {
            currentPosition++;
            double argument = getOperator();
            return calculateFactorial((int) argument);
        } else {
            currentPosition++;
            return Double.parseDouble(nextToken);
        }
    }

    private double calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of a negative number is undefined");
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}