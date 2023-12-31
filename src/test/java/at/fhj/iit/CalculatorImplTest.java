package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing CalculatorImpl to complete High Test Coverage
 */
@DisplayName("Testing Calculator implementation")
public class CalculatorImplTest {
    private Calculator calc;

    /**
     * inits Calculator with CalculatorImpl for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        calc = new CalculatorImpl();
    }

    @ParameterizedTest
    @CsvSource({
            " 1,  2,  3",
            " 0,  0,  0",
            " 3,  4,  7",
            "-2,  2,  0",
            "-8,  3, -5",
            "-4,  6,  3",
            "-2, -2, -4"
    })
    @DisplayName("Testing addition")
    /**
     * is testing addition of two numbers
     */
    void testAdd(double addend1, double addend2, double expected) {
        // EXERCISE PHASE
        double actual = calc.add(addend1, addend2);

        // VERIFY PHASE
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Testing subtraction")
    /**
     * is testing difference of two numbers
     */
    public void testMinus() {
        // EXERCISE PHASE
        double actual = calc.minus(5, 2);

        // VERIFY PHASE
        assertEquals(3, actual, 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            " 1,  2,  -1",
            " 0,  0,  0",
            " 3,  4,  -1",
            "-2,  2,  -4",
            "-8,  3, -11",
            "44,  6,  38",
            "100, 20, 80"
    })
    @DisplayName("Testing subtraction with more sample data")
    /**
     * is testing difference of two numbers
     */
    public void testMinusMore(double nr1, double nr2, double expected) {
        // EXERCISE PHASE
        double actual = calc.minus(nr1, nr2);

        // VERIFY PHASE
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Testing multiplication")
    /**
     * is testing multiplication of two numbers
     */
    public void testMultiply() {
        double actual = calc.multiply(5, 2);
        assertEquals(10, actual, 0.001);
    }

    @Test
    @DisplayName("Testing divide")
    /**
     * is testing division of two numbers
     */
    public void testDivide() {
        double actual = calc.divide(5, 2);
        assertEquals(2.5, actual, 0.001);
    }

    @Test
    @DisplayName("Testing divide by zero")
    /**
     * is testing division by zero, which has to throw Exception
     */
    public void testDivideWithZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(5, 0);
        });
    }

    // TODO for testing Continuous Delivery Pipelines
    // - create a new branch e.g. new-divide-tests
    // - create another Parameterized Test e.g. for divide Operation
    // - commit and push your new created test case
    // - create a pull request to merge into main branch
    // - workflow on pull_request has to be run and check your code

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2 ",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040"
    })
    @DisplayName("Testing faculty")
    /**
     * is testing faculty calculation by a couple of numbers
     */
    void testFaculty(int number, int expected) {
        assertEquals(expected, calc.faculty(number));
    }


    @Test
    @DisplayName("Testing sum from 1 to n")
    /**
     * is testing sum of natural numbers between 1 and 5
     */
    void testSumOfNaturalNumbers() {
        assertEquals(calc.sumOfNaturalNumbers(5), (1 + 2 + 3 + 4 + 5));
    }


}
