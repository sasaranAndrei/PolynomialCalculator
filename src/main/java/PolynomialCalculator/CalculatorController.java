package PolynomialCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController (CalculatorView view, CalculatorModel model){
        this.view = view;
        this.model = model;

        this.view.addAddListener(new AddListener());
        this.view.addSubListener(new SubListener());
        this.view.addMulListener(new MulListener());
        this.view.addDivListener(new DivListener());
        this.view.addDerListener(new DerListener());
        this.view.addIntListener(new IntListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem
            String secondPolynomial = view.getEnterSecondPolynomial().getText(); // datele de intrare

            if (Polynomial.isValid(firstPolynomial) == true && Polynomial.isValid(secondPolynomial) == true){
                Polynomial firstOperand = new Polynomial(firstPolynomial); // le convertim
                Polynomial secondOperand = new Polynomial(secondPolynomial); // pentru a opera cu ele

                model.addPolynomials(firstOperand, secondOperand); // aduna polinoamele

                String resultPolynomial = model.getResultPolynomial().toString();
                view.setReturnResultPolynomial(resultPolynomial); // si l afisam pe interfata
            }
            else {
                JOptionPane.showMessageDialog(null,"INVALID INPUT. TRY AGAIN");
            }


        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem
            String secondPolynomial = view.getEnterSecondPolynomial().getText(); // datele de intrare

            if (Polynomial.isValid(firstPolynomial) == true && Polynomial.isValid(secondPolynomial) == true) {

                Polynomial firstOperand = new Polynomial(firstPolynomial); // le convertim
                Polynomial secondOperand = new Polynomial(secondPolynomial); // pentru a opera cu ele

                model.subPolynomials(firstOperand, secondOperand); // scade polinoamele

                String resultPolynomial = model.getResultPolynomial().toString();
                view.setReturnResultPolynomial(resultPolynomial);
            } else {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. TRY AGAIN");
            }
        }
    }

    class MulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem
            String secondPolynomial = view.getEnterSecondPolynomial().getText(); // datele de intrare

            if (Polynomial.isValid(firstPolynomial) == true && Polynomial.isValid(secondPolynomial) == true) {

                Polynomial firstOperand = new Polynomial(firstPolynomial); // le convertim
                Polynomial secondOperand = new Polynomial(secondPolynomial); // pentru a opera cu ele

                model.mulPolynomials(firstOperand, secondOperand); // inmulteste polinoamele

                String resultPolynomial = model.getResultPolynomial().toString();
                view.setReturnResultPolynomial(resultPolynomial);
            }
            else {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. TRY AGAIN");
            }
        }
    }

    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem
            String secondPolynomial = view.getEnterSecondPolynomial().getText(); // datele de intrare

            if (Polynomial.isValid(firstPolynomial) == true && Polynomial.isValid(secondPolynomial) == true) {

                Polynomial firstOperand = new Polynomial(firstPolynomial); // le convertim
                Polynomial secondOperand = new Polynomial(secondPolynomial); // pentru a opera cu ele

                model.divPolynomials(firstOperand, secondOperand); // imparte polinoamele

                String resultPolynomial = model.getResultPolynomial().toString();
                if (model.getRestPolynomial().toString() != "0") {
                    resultPolynomial += " REST " + model.getRestPolynomial().toString();
                }

                view.setReturnResultPolynomial(resultPolynomial);
            } else {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. TRY AGAIN");
            }
        }
    }

    class DerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem

            if (Polynomial.isValid(firstPolynomial) == true) {

                view.getEnterSecondPolynomial().setText("-----------------------------------------------");
                Polynomial operandPolynomial = new Polynomial(firstPolynomial);

                model.derPolynomial(operandPolynomial);
                view.setReturnResultPolynomial(model.getResultPolynomial().toString());
            }
            else {
                JOptionPane.showMessageDialog(null, "INVALID INPUT. TRY AGAIN");
            }
        }
    }

    class IntListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPolynomial = view.getEnterFirstPolynomial().getText(); // extragem
            if (Polynomial.isValid(firstPolynomial) == true) {

            view.getEnterSecondPolynomial().setText("-----------------------------------------------");
            Polynomial operandPolynomial = new Polynomial (firstPolynomial);

            model.intPolynomial(operandPolynomial);
            view.setReturnResultPolynomial(model.getResultPolynomial().toString() + " + C");
            }
            else {
            JOptionPane.showMessageDialog(null, "INVALID INPUT. TRY AGAIN");
            }
        }
    }
}
