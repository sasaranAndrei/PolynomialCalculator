package PolynomialCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MVCCalculator {
    public static void main(String[] args) {

        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

    }
}
