public class CalculatorModel {
    private String[] tokens;
    private int position;

    public CalculatorModel(String line) {
        this.tokens = line.split(" ");
        this.position = 0;
    }

    public double performCalculation() {
        double result = evaluateExpression();
        return result;
    }

    private double evaluateExpression() {
        double firstOperand = evaluateTerm();
        while (position < tokens.length) {
            String operator = tokens[position];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                position++;
            }
            double secondOperand = evaluateTerm();
            if (operator.equals("+")) {
                firstOperand += secondOperand;
            } else {
                firstOperand -= secondOperand;
            }
        }
        return firstOperand;
    }

    private double evaluateTerm() {
        double firstOperand = evaluateFactor();
        while (position < tokens.length) {
            String operator = tokens[position];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("//") && !operator.equals("^")) {
                break;
            } else {
                position++;
            }
            double secondOperand = evaluateFactor();
            if (operator.equals("*")) {
                firstOperand *= secondOperand;
            } else if (operator.equals("/")) {
                firstOperand /= secondOperand;
            } else if (operator.equals("//")) {
                firstOperand %= secondOperand;
            } else if (operator.equals("^")) {
                firstOperand = Math.pow(firstOperand, secondOperand);
            }
        }
        return firstOperand;
    }

    private double evaluateFactor() {
        String nextToken = tokens[position];
        if (nextToken.equals("(")) {
            position++;
            double result = evaluateExpression();
            String closingBracket;
            if (position < tokens.length) {
                closingBracket = tokens[position];
            } else {
                throw new IllegalArgumentException("Ошибка");
            }
            if (closingBracket.equals(")")) {
                position++;
                return result;
            }
            throw new IllegalArgumentException("')' ошибка");
        } else {
            position++;
            return Double.parseDouble(nextToken);
        }
    }

    public double calculate() }

}