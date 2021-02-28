package PolynomialCalculator;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JLabel firstPolynomial = new JLabel("First Polynomial :", SwingConstants.CENTER);
    private JLabel secondPolynomial = new JLabel("Second Polynomial :", SwingConstants.CENTER);
    private JLabel resultPolynomial = new JLabel("Result Polynomial :", SwingConstants.CENTER);

    private JTextField enterFirstPolynomial = new JTextField(100);
    private JTextField enterSecondPolynomial = new JTextField(100);
    private JTextField returnResultPolynomial = new JTextField(100);

    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton mulButton = new JButton("*");
    private JButton divButton = new JButton("/");

    private JButton derButton = new JButton("d/dx");
    private JButton intButton = new JButton("intgr");

    public CalculatorView (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,230);
        this.setBackground(new Color(100, 96, 13));
        this.setEnabled(true);
        this.setVisible(true);
        this.setLayout(new FlowLayout());

        firstPolynomial.setFont(new Font("Calibri", Font.BOLD, 22));
        secondPolynomial.setFont(new Font("Calibri", Font.BOLD, 22));
        resultPolynomial.setFont(new Font("Calibri", Font.BOLD, 22));

        firstPolynomial.setAlignmentX(CENTER_ALIGNMENT);
        secondPolynomial.setAlignmentX(CENTER_ALIGNMENT);
        resultPolynomial.setAlignmentX(CENTER_ALIGNMENT);

        firstPolynomial.setMinimumSize(new Dimension(50,20));
        firstPolynomial.setPreferredSize(new Dimension (50,20));
        firstPolynomial.setMaximumSize(new Dimension (50,20));

        secondPolynomial.setMinimumSize(new Dimension(50,20));
        secondPolynomial.setPreferredSize(new Dimension (50,20));
        secondPolynomial.setMaximumSize(new Dimension (50,20));

        resultPolynomial.setMinimumSize(new Dimension(50,20));
        resultPolynomial.setPreferredSize(new Dimension (50,20));
        resultPolynomial.setMaximumSize(new Dimension (50,20));


        JPanel labelsPanel = new JPanel();
        labelsPanel.setPreferredSize(new Dimension(250,170));
        labelsPanel.setLayout(new GridLayout(3,1));
        labelsPanel.setBackground(new Color(22, 200, 137));
        labelsPanel.setBounds(0,0,200,300);



        labelsPanel.add(firstPolynomial);
        labelsPanel.add(secondPolynomial);
        labelsPanel.add(resultPolynomial);


        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setPreferredSize(new Dimension(310,170));
        textFieldsPanel.setLayout(new GridLayout(3,1));
        textFieldsPanel.setBackground(new Color(100,100,100));

        enterFirstPolynomial.setFont(new Font("Calibri",Font.BOLD, 20));
        enterSecondPolynomial.setFont(new Font("Calibri",Font.BOLD, 20));
        returnResultPolynomial.setFont(new Font("Calibri",Font.BOLD, 20));

        textFieldsPanel.add(enterFirstPolynomial);
        textFieldsPanel.add(enterSecondPolynomial);
        textFieldsPanel.add(returnResultPolynomial);



        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(130,170));
        buttonsPanel.setLayout(new GridLayout(3,2));
        Font buttonFont = new Font(addButton.getFont().getName(), addButton.getFont().getStyle(), 40);
        Font calculusFont = new Font(derButton.getFont().getName(), derButton.getFont().getStyle(), 13);

        addButton.setFont(buttonFont);
        subButton.setFont(buttonFont);
        mulButton.setFont(buttonFont);
        divButton.setFont(buttonFont);
        derButton.setFont(calculusFont);
        intButton.setFont(calculusFont);

        buttonsPanel.add(addButton);
        buttonsPanel.add(subButton);
        buttonsPanel.add(mulButton);
        buttonsPanel.add(divButton);
        buttonsPanel.add(derButton);
        buttonsPanel.add(intButton);

        this.add(labelsPanel);
        this.add(textFieldsPanel);
        this.add(buttonsPanel);

    }

    public JTextField getEnterFirstPolynomial() {
        return enterFirstPolynomial;
    }

    public void setEnterFirstPolynomial(JTextField enterFirstPolynomial) {
        this.enterFirstPolynomial = enterFirstPolynomial;
    }

    public JTextField getEnterSecondPolynomial() {
        return enterSecondPolynomial;
    }

    public void setEnterSecondPolynomial(JTextField enterSecondPolynomial) {
        this.enterSecondPolynomial = enterSecondPolynomial;
    }

    public JTextField getReturnResultPolynomial() {
        return returnResultPolynomial;
    }

    public void setReturnResultPolynomial(JTextField returnResultPolynomial) {
        this.returnResultPolynomial = returnResultPolynomial;
    }

    public void setReturnResultPolynomial(String returnResultPolynomial) {
        this.returnResultPolynomial.setText(returnResultPolynomial);
    }

    public void addAddListener (ActionListener listenForAddButton){
        addButton.addActionListener(listenForAddButton);
    }

    public void addSubListener (ActionListener listenForSubButton){
        subButton.addActionListener(listenForSubButton);
    }

    public void addMulListener (ActionListener listenForMulButton){
        mulButton.addActionListener(listenForMulButton);
    }

    public void addDivListener (ActionListener listenForDivButton){
        divButton.addActionListener(listenForDivButton);
    }

    public void addDerListener (ActionListener listenForDerButton){
        derButton.addActionListener(listenForDerButton);
    }

    public void addIntListener (ActionListener listenForIntButton){
        intButton.addActionListener(listenForIntButton);
    }

}
