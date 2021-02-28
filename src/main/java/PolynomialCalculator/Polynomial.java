package PolynomialCalculator;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private int numberOfMonomials;
    private ArrayList<Monomial> monomials;

    private static final int MAXIMUM_DEGREE = 15;
    private static final String MONOMIAL_PATTERN = "([-+]?([0-9]*)?)(([xX]?(\\^[0-9]+)?)?)";


    public static boolean isValid (String polynomial){
        if (polynomial.equals("x")){
            return true;
        }

        boolean containsAtLeastOneNumber = false;
        char[] chars = polynomial.toCharArray();
        for (char c : chars){
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public Polynomial(int numberOfMonomials) {
        // initializeaza un polinom gol cu gradul maximi (numberOfMonomials - 1)
        // cand se apeleaza in context se apeleaza cu gradul maxim + 1
        this.numberOfMonomials = numberOfMonomials;
        this.monomials = new ArrayList<Monomial>(numberOfMonomials);
        for (int i = 0; i < numberOfMonomials; i++){
            Monomial m = new Monomial(0,i);
            addMonomial(m);
        }

        System.out.println("sout in constructor de poli :");
        System.out.println(this);
    }

    public Polynomial(int numberOfMonomials, ArrayList<Monomial> monomials) {
        this.numberOfMonomials = numberOfMonomials;
        this.monomials = monomials;
    }



    public Polynomial (String sourcePolynomial){
        this.numberOfMonomials = 0;
        this.monomials = new ArrayList<Monomial>(MAXIMUM_DEGREE);

        Pattern monomialPattern = Pattern.compile(MONOMIAL_PATTERN);
        Matcher monomialMatcher = monomialPattern.matcher(sourcePolynomial);

        while (monomialMatcher.find()){
            Monomial currentMonomial = new Monomial(monomialMatcher.group(0));

            boolean monomialState = this.addMonomial(currentMonomial);
            if (monomialState == true) {
                this.numberOfMonomials++;
            }
        }
    }



    public int getNumberOfMonomials() {
        return numberOfMonomials;
    }

    public void setNumberOfMonomials(int numberOfMonomials) {
        this.numberOfMonomials = numberOfMonomials;
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    public int maximumDegree (){
        if (monomials.size() == 0){
            return 0;
        }

        int maximumDegree = -1;
        for (Monomial monomial : monomials){
            if (monomial.getCoefficient() != 0){
                if (monomial.getDegree() > maximumDegree){
                    maximumDegree = monomial.getDegree();
                }
            }

        }
        return maximumDegree;
    }

    public boolean addMonomial (Monomial monomial) {
        if (!(monomial.getCoefficient() == 0 && monomial.getDegree() == 0))  {
            this.getMonomials().add(monomial);
            //System.out.println("Monomial added successfully");
            this.setNumberOfMonomials(monomials.size());
            return true;
        }
        this.setNumberOfMonomials(monomials.size());
        return false;
    }

    public void sort (){
        Collections.sort(monomials);
    }

    @Override
    public String toString() {
        String result = ""; // initializam rezultatul

        boolean allZero = true; // daca toti coef poliomului sunt 0
        for (Monomial monomial : monomials){
            if (monomial.getCoefficient() != 0.0){
                allZero = false;
            }
        }

        if (allZero == true) { // trebuie sa afisam 0
            result = "0";
        }

        else // daca nu
            {
                // afisam monoamele in ordine descrescatoare
                // deoarece daca e pozitiv nu trebuie sa i afisam + ul
                // ex : x^5+3x^4...
                // ex : -x^5-3x^4

                for (int index = monomials.size() - 1; index > -1; index--){
                    Monomial monomial = monomials.get(index);


                    if (monomial.getCoefficient() > 0){
                        //System.out.println("coef>0 : " + monomial.getCoefficient());
                        if (result != ""){
                            result += "+";
                        }

                    }   // afisam + pentru coeficientii pozitivi

                    if (monomial.getCoefficient() != 0){
                        //System.out.println("coef<0 : " + monomial.getCoefficient());
                        result += monomial;
                    }  // si afisam doar monoamele cu coeficienti nenuli
                }
            }
        return result;
    }
}
