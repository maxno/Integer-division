package ua.com.foxminded;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionTest {

    IntegerDivision longDivision = new IntegerDivision();

    @Test
    @DisplayName("Input is 0")
    void numbersLongDivisionShouldThrowExceptionWhenInput0() {

        Exception illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> longDivision.numbersLongDivision(0, 0));

        String expected = "Input parameters contain 0";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Dividend less than divisor")
    void numbersLongDivisionShouldThrowExceptionWhenDividendLessThanDivisor() {

        Exception illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> longDivision.numbersLongDivision(3, 5));

        String expected = "Dividend is less than divisor";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Divisor = 1")
    void numbersLongDivisionShouldReturnDividendWhenDivisor1(){
        List<Integer> resultList = new ArrayList<>(Arrays.asList(123));

        List expected = resultList;
        List result = longDivision.numbersLongDivision(123, 1);

        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    @DisplayName("Answer is correct")
    void numbersLongDivisionReturnsCorrectAnswer(){
        List<Integer> resultList = new ArrayList<>(Arrays.asList(4,38,36,26,24,24,24,0));

        List expected = resultList;
        List result = longDivision.numbersLongDivision(7864, 4);

        assertArrayEquals(expected.toArray(),result.toArray());
    }

}
