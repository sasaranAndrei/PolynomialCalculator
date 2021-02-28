package PolynomialCalculator;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial implements Comparable {
    private float coefficient;
    private int degree;

    private static final DecimalFormat DECIMAL_FORMAT_2 = new DecimalFormat("#.##");
    private static final String COEFFICIENT_PATTERN = "([-+]?([0-9]*)?)";
    private static final String DEGREE_PATTERN = "[xX]((\\^)[0-9]*)?";

    public Monomial(float coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Monomial  (String monomial) {
        Pattern coefficientPattern = Pattern.compile(COEFFICIENT_PATTERN);
        Matcher coefficientMatcher = coefficientPattern.matcher(monomial);

        if (coefficientMatcher.find()) {
            if (coefficientMatcher.group(0).length() > 0) {// daca exista stringu
                String coefficientString = coefficientMatcher.group(0); // il salvam si operam cu el
                if (coefficientString.equals("-")) {  // cazurile
                    this.coefficient = -1;
                }
                else if (coefficientString.equals("+")) { // de exceptie
                    this.coefficient = 1;
                }
                else this.coefficient = Integer.parseInt(coefficientString);
            }
            else {
                // cand incepe cu x^..
                if (monomial.length() > 0) {
                    this.coefficient = 1;
                }
            }


        }
        //System.out.println(coefficient);

        Pattern degreePattern = Pattern.compile(DEGREE_PATTERN);
        Matcher degreeMatcher = degreePattern.matcher(monomial);

        if (degreeMatcher.find()) {
            if (degreeMatcher.group(0).length() > 1) {// daca exista stringu
                String degreeString = degreeMatcher.group(0); // il salvam si operam cu el
                if (degreeString.charAt(1) == '^') {
                    this.degree = Integer.parseInt(degreeString.substring(2));
                }
            } else {
                this.degree = 1;
            }
        } else {
            this.degree = 0;
        }
    }

    public void derivative() {
        coefficient = coefficient * degree;
        if (degree > 0) {
            degree = degree - 1;
        } else {
            degree = 0;
        }
    }

    public void integration() {
        coefficient = coefficient / (degree + 1);
        degree = degree + 1;
    }

    public void addMonomial(Monomial monomial) {
        if (this.degree == monomial.degree) {
            this.coefficient += monomial.coefficient;
        }
    }

    @Override
    public String toString() {
        String result = "";
        int coefficientInt = (int) coefficient;
        if (Float.valueOf(String.valueOf(coefficientInt)) == coefficient) {

            result = String.valueOf(coefficientInt);
        } else {
            //System.out.println("Asta fute pe masa");
            result = String.valueOf(DECIMAL_FORMAT_2.format(coefficient));
        }
        if (coefficient == 1 && degree != 0) {
            result = "";
        }
        if (coefficient == -1 && degree != 0) {
            result = "-";
        }
        if (degree > 0) {
            result += "x";
            if (degree > 1) {
                result += "^" + degree;
            }
        }
        return result;
    }

    @Override
    public int compareTo(Object monomial) {
        int compareDegree = ((Monomial) monomial).getDegree();
        return this.degree - compareDegree;
    }
}
