/*
import org.junit.jupiter.api.Test;
import PolynomialCalculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;


 */
public class PolynomialTests {
    /*
    @Test
    public void testPolynomialAddition() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8,1));
        firstPolynomial.addMonomial(new Monomial(6,2));
        firstPolynomial.addMonomial(new Monomial(1,3));
        firstPolynomial.addMonomial(new Monomial(3,6));
        System.out.println(firstPolynomial);

        //x + 4x^2 + 2x^3 + 4x^5
        Polynomial secondPolynomial = new Polynomial("0");
        secondPolynomial.addMonomial(new Monomial(1, 1));
        secondPolynomial.addMonomial(new Monomial(4, 2));
        secondPolynomial.addMonomial(new Monomial(2, 3));
        secondPolynomial.addMonomial(new Monomial(4, 5));
        System.out.println(secondPolynomial);

        Polynomial addPolynomial = new Polynomial("0");
        addPolynomial.addMonomial(new Monomial(9, 1));
        addPolynomial.addMonomial(new Monomial(10, 2));
        addPolynomial.addMonomial(new Monomial(3, 3));
        addPolynomial.addMonomial(new Monomial(4, 5));
        addPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(addPolynomial);

        CalculatorModel model = new CalculatorModel();
        model.addPolynomials(firstPolynomial, secondPolynomial);
        Polynomial resultPolynomial = model.getResultPolynomial();

        assertEquals(addPolynomial, resultPolynomial);
    }


    @Test
    public void testPolynomialSubtraction() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8, 1));
        firstPolynomial.addMonomial(new Monomial(6, 2));
        firstPolynomial.addMonomial(new Monomial(1, 3));
        firstPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(firstPolynomial);

        //x + 4x^2 + 2x^3 + 4x^5
        Polynomial secondPolynomial = new Polynomial("0");
        secondPolynomial.addMonomial(new Monomial(1, 1));
        secondPolynomial.addMonomial(new Monomial(4, 2));
        secondPolynomial.addMonomial(new Monomial(2, 3));
        secondPolynomial.addMonomial(new Monomial(4, 5));
        System.out.println(secondPolynomial);

        Polynomial subPolynomial = new Polynomial("0");
        subPolynomial.addMonomial(new Monomial(7, 1));
        subPolynomial.addMonomial(new Monomial(2, 2));
        subPolynomial.addMonomial(new Monomial(-1, 3));
        subPolynomial.addMonomial(new Monomial(-4, 5));
        subPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(subPolynomial);

        CalculatorModel model = new CalculatorModel();
        model.subPolynomials(firstPolynomial, secondPolynomial);
        Polynomial resultPolynomial = model.getResultPolynomial();

        assertEquals(subPolynomial, resultPolynomial);

    }

    @Test
    public void testPolynomialMultiplication() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8, 1));
        firstPolynomial.addMonomial(new Monomial(6, 2));
        firstPolynomial.addMonomial(new Monomial(1, 3));
        firstPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(firstPolynomial);

        //x + 4x^2 + 2x^3 + 4x^5
        Polynomial secondPolynomial = new Polynomial("0");
        secondPolynomial.addMonomial(new Monomial(1, 1));
        secondPolynomial.addMonomial(new Monomial(4, 2));
        secondPolynomial.addMonomial(new Monomial(2, 3));
        secondPolynomial.addMonomial(new Monomial(4, 5));
        System.out.println(secondPolynomial);

        //12x^11 + 6x^9 + 16x^8 + 27x^7 + 34x^6 + 16x^5 + 41x^4 + 38x^3 + 8x^2
        Polynomial mulPolynomial = new Polynomial("0");
        mulPolynomial.addMonomial(new Monomial(8, 2));
        mulPolynomial.addMonomial(new Monomial(38, 3));
        mulPolynomial.addMonomial(new Monomial(41, 4));
        mulPolynomial.addMonomial(new Monomial(16, 5));
        mulPolynomial.addMonomial(new Monomial(34, 6));
        mulPolynomial.addMonomial(new Monomial(27, 7));
        mulPolynomial.addMonomial(new Monomial(16, 8));
        mulPolynomial.addMonomial(new Monomial(6, 9));
        mulPolynomial.addMonomial(new Monomial(12, 11));
        System.out.println(mulPolynomial);

        CalculatorModel model = new CalculatorModel();
        model.mulPolynomials(firstPolynomial, secondPolynomial);
        Polynomial resultPolynomial = model.getResultPolynomial();

        assertEquals(mulPolynomial, resultPolynomial);

    }

    @Test
    public void testPolynomialDivision() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8, 1));
        firstPolynomial.addMonomial(new Monomial(6, 2));
        firstPolynomial.addMonomial(new Monomial(1, 3));
        firstPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(firstPolynomial);

        //x + 4x^2 + 2x^3 + 4x^5
        Polynomial secondPolynomial = new Polynomial("0");
        secondPolynomial.addMonomial(new Monomial(1, 1));
        secondPolynomial.addMonomial(new Monomial(4, 2));
        secondPolynomial.addMonomial(new Monomial(2, 3));
        secondPolynomial.addMonomial(new Monomial(4, 5));
        System.out.println(secondPolynomial);

        Polynomial expectedResultPolynomial = new Polynomial("0");
        expectedResultPolynomial.addMonomial(new Monomial((float)3 / 4, 1));

        Polynomial expectedRestPolynomial = new Polynomial("0");
        expectedRestPolynomial.addMonomial(new Monomial(8, 1));
        expectedRestPolynomial.addMonomial(new Monomial((float)21 / 4, 2));
        expectedRestPolynomial.addMonomial(new Monomial(-2, 3));
        expectedRestPolynomial.addMonomial(new Monomial((float)-3/2, 4));

        System.out.print(expectedResultPolynomial);
        System.out.println("  rest  " + expectedRestPolynomial);
        System.out.println();

        CalculatorModel model = new CalculatorModel();
        model.divPolynomials(firstPolynomial, secondPolynomial);
        Polynomial resultPolynomial = model.getResultPolynomial();
        Polynomial restPolynomial = model.getRestPolynomial();

        assertEquals(expectedResultPolynomial, resultPolynomial);
        assertEquals(expectedRestPolynomial, restPolynomial);




    }

    @Test
    public void testPolynomialDerivation() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8, 1));
        firstPolynomial.addMonomial(new Monomial(6, 2));
        firstPolynomial.addMonomial(new Monomial(1, 3));
        firstPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(firstPolynomial);

        Polynomial derPolynomial = new Polynomial("0");

        derPolynomial.addMonomial(new Monomial(8, 0));
        derPolynomial.addMonomial(new Monomial(12, 1));
        derPolynomial.addMonomial(new Monomial(3, 2));
        derPolynomial.addMonomial(new Monomial(18, 5));

        System.out.println(derPolynomial);
    }

    @Test
    public void testPolynomialIntegration() {
        //8x + 6x^2 + x^3 + 3x^6
        Polynomial firstPolynomial = new Polynomial("0");
        firstPolynomial.addMonomial(new Monomial(8, 1));
        firstPolynomial.addMonomial(new Monomial(6, 2));
        firstPolynomial.addMonomial(new Monomial(1, 3));
        firstPolynomial.addMonomial(new Monomial(3, 6));
        System.out.println(firstPolynomial);

        Polynomial intPolynomial = new Polynomial("0");
        intPolynomial.addMonomial(new Monomial(4, 2));
        intPolynomial.addMonomial(new Monomial(2, 3));
        intPolynomial.addMonomial(new Monomial((float)1 / 4, 4));
        intPolynomial.addMonomial(new Monomial((float)3 / 7, 7));
        System.out.println(intPolynomial);
    }




     */

}
