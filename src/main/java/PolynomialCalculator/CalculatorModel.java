package PolynomialCalculator;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class CalculatorModel {
    private Polynomial resultPolynomial;
    private Polynomial restPolynomial;

    public Polynomial getResultPolynomial (){
        return  resultPolynomial;
    }

    public Polynomial getRestPolynomial() {
        return restPolynomial;
    }

    public void addPolynomials (Polynomial firstPolynomial, Polynomial secondPolynomial){
        // initializam polinomul rezultatul cu primul operand
        resultPolynomial = new Polynomial(firstPolynomial.getNumberOfMonomials(), firstPolynomial.getMonomials());

        for (Monomial secondMonomial : secondPolynomial.getMonomials()){
            // si pe masura ce parcurgem al doilea polinom
            int currentDegree = secondMonomial.getDegree();
            boolean foundDegree = false;
            // efectuam ADUNAREA coeficietilor monoamelor
            // de grad egal
             for (Monomial resultMonomial : resultPolynomial.getMonomials()){
                if (resultMonomial.getDegree() == currentDegree){
                    foundDegree = true;
                    // daca avem acelasi grad ADUNAM coeficientii
                    int index = resultPolynomial.getMonomials().indexOf(resultMonomial); // pe pozitia asta
                    float coefficient = resultPolynomial.getMonomials().get(index).getCoefficient(); // luam coeficientul vechi
                    coefficient += secondMonomial.getCoefficient(); // si creeam coeficientul nou

                    resultPolynomial.getMonomials().get(index).setCoefficient(coefficient); // actualizandu l
                }
            }

            if (foundDegree == false) { // daca gradul monomului din operandul2 nu a fost gasit
                // in operandul1, il adaugam la polinomul rezultat
                resultPolynomial.setNumberOfMonomials( resultPolynomial.getNumberOfMonomials()  +  1 );
                resultPolynomial.addMonomial(secondMonomial);
            }
        }

        resultPolynomial.sort();
        System.out.println("Addition performed successfully");
    }

    public void subPolynomials (Polynomial firstPolynomial, Polynomial secondPolynomial){
        // initializam polinomul rezultatul cu primul operand
        resultPolynomial = new Polynomial(firstPolynomial.getNumberOfMonomials(), firstPolynomial.getMonomials());

        for (Monomial secondMonomial : secondPolynomial.getMonomials()){
            // si pe masura ce parcurgem al doilea polinom
            int currentDegree = secondMonomial.getDegree();
            boolean foundDegree = false;
            // efectuam SCADEREA coeficietilor monoamelor
            // de grad egal
            for (Monomial resultMonomial : resultPolynomial.getMonomials()){
                if (resultMonomial.getDegree() == currentDegree){
                    foundDegree = true;
                    // daca avem acelasi grad SCADEM coeficientii
                    int index = resultPolynomial.getMonomials().indexOf(resultMonomial); // pe pozitia asta
                    float coefficient = resultPolynomial.getMonomials().get(index).getCoefficient(); // luam coeficientul vechi
                    coefficient -= secondMonomial.getCoefficient(); // si creeam coeficientul nou

                    resultPolynomial.getMonomials().get(index).setCoefficient(coefficient); // actualizandu l
                }
            }

            if (foundDegree == false) { // daca gradul monomului din operandul2 nu a fost gasit
                // in operandul1, il adaugam la polinomul rezultat
                resultPolynomial.setNumberOfMonomials( resultPolynomial.getNumberOfMonomials()  +  1 );
                Monomial oppositeMonomial = new Monomial(-1 * secondMonomial.getCoefficient(), secondMonomial.getDegree());
                //System.out.println(secondMonomial + " si op " + oppositeMonomial);
                resultPolynomial.addMonomial(oppositeMonomial);
            }
        }

        resultPolynomial.sort();
        System.out.println("Subtraction performed successfully");

    }

    public void mulPolynomials (Polynomial firstPolynomial, Polynomial secondPolynomial){
        resultPolynomial = new Polynomial("0");
        Collections.sort(firstPolynomial.getMonomials());
        Collections.sort(secondPolynomial.getMonomials());

        for (Monomial firstMonomial : firstPolynomial.getMonomials()){
            for (Monomial secondMonomial : secondPolynomial.getMonomials()){
                float newCoefficient = firstMonomial.getCoefficient() * secondMonomial.getCoefficient();
                int newDegree = firstMonomial.getDegree() + secondMonomial.getDegree();
                Monomial multiply =  new Monomial (newCoefficient, newDegree);

                // il bagam la rezultat
                boolean foundDegree = false;
                // efectuam actualizarea coeficietilor monoamelor
                // de grad egal
                for (Monomial resultMonomial : resultPolynomial.getMonomials()){
                    if (resultMonomial.getDegree() == newDegree){
                        foundDegree = true;
                        // daca avem acelasi grad
                        int index = resultPolynomial.getMonomials().indexOf(resultMonomial); // pe pozitia asta
                        // actualizam coeficientul
                        resultPolynomial.getMonomials().get(index).addMonomial(multiply);
                    }
                }

                if (foundDegree == false) { // daca gradul monomului din operandul2 nu a fost gasit
                    // in operandul1, il adaugam la polinomul rezultat
                    resultPolynomial.addMonomial(multiply);
                }


            }
        }

        resultPolynomial.sort();
        System.out.println("Multiplication performed successfully");

    }

    public void divPolynomials (Polynomial firstPolynomial, Polynomial secondPolynomial){
        // performs firstpolyonimal = secondpolynomial * result + rest
        int firstDegree = firstPolynomial.maximumDegree();
        int secondDegree = secondPolynomial.maximumDegree();

        //System.out.println(firstDegree + " si " + secondDegree);

        // cazurile speciale
        if (firstPolynomial.toString() == "0"){
            resultPolynomial = new Polynomial("0");
            restPolynomial = new Polynomial("0");
        }

        else if (secondPolynomial.toString() == "0"){
            JOptionPane.showMessageDialog(null, "CAN'T DIVIDE BY 0");
            resultPolynomial = new Polynomial("0");
            restPolynomial = new Polynomial("0");
        }
        else // aici incepe algoritmul

        if (firstDegree < secondDegree){
            // first : second = 0 rest first
            resultPolynomial = new Polynomial("0");
            restPolynomial = new Polynomial(firstPolynomial.getNumberOfMonomials(), firstPolynomial.getMonomials());
        }
        else {

            resultPolynomial = new Polynomial("0");
            restPolynomial = new Polynomial("0");
            //System.out.println(resultPolynomial.getMonomials().size());
           // System.out.println("r" + restPolynomial.maximumDegree() + "ss" + secondPolynomial.maximumDegree());
            do  {

                    Collections.sort(firstPolynomial.getMonomials());
                    Collections.sort(secondPolynomial.getMonomials());

                    // salvam valorile vechi
                    Polynomial savedResultPolynomial = new Polynomial (this.resultPolynomial.getNumberOfMonomials(), this.resultPolynomial.getMonomials());
                    float firstCoefficient = 0;
                    for (Monomial m : firstPolynomial.getMonomials()){
                        if (m.getDegree() == firstPolynomial.maximumDegree())
                        firstCoefficient = m.getCoefficient();
                    }

                    float divideCoefficient = firstCoefficient / secondPolynomial.getMonomials().get(secondPolynomial.getMonomials().size() - 1).getCoefficient();
                    int divideDegree = firstPolynomial.maximumDegree() - secondPolynomial.getMonomials().get(secondPolynomial.getMonomials().size() - 1).getDegree();
                    Monomial divide = new Monomial(divideCoefficient, divideDegree);

                    Polynomial dividePolynomial = new Polynomial("0");
                    dividePolynomial.addMonomial(divide);

                    // cream restu
                    mulPolynomials(dividePolynomial, secondPolynomial);
                    //System.out.println(this.resultPolynomial);
                    dividePolynomial = new Polynomial(resultPolynomial.getNumberOfMonomials(), resultPolynomial.getMonomials());
                    subPolynomials(firstPolynomial, dividePolynomial);

                    // setam restul
                    restPolynomial = new Polynomial(resultPolynomial.getNumberOfMonomials(), resultPolynomial.getMonomials());
                    firstPolynomial = new Polynomial(restPolynomial.getNumberOfMonomials(), restPolynomial.getMonomials());

                    // setam catul
                    resultPolynomial = new Polynomial(savedResultPolynomial.getNumberOfMonomials(), savedResultPolynomial.getMonomials());
                    resultPolynomial.addMonomial(divide);
            } while ((restPolynomial.maximumDegree() < secondPolynomial.maximumDegree()) == false);

        }

        resultPolynomial.sort();
        restPolynomial.sort();
        System.out.println("Division performed successfully");
    }

    public void derPolynomial (Polynomial polynomial){
        for (Monomial monomial : polynomial.getMonomials()){
            monomial.derivative();
        }
        resultPolynomial = new Polynomial (polynomial.getNumberOfMonomials(), polynomial.getMonomials());
        resultPolynomial.sort();
        System.out.println("Derivative performed successfully");
    }

    public void intPolynomial (Polynomial polynomial){
        for (Monomial monomial : polynomial.getMonomials()){
            monomial.integration();
        }
        resultPolynomial = new Polynomial(polynomial.getNumberOfMonomials(), polynomial.getMonomials());
        resultPolynomial.sort();
        System.out.println("Integration performed successfully");
    }
}
