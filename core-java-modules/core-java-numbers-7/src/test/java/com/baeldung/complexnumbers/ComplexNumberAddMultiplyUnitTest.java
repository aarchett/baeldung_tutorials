package com.baeldung.complexnumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComplexNumberAddMultiplyUnitTest {

    @ParameterizedTest(name = "Multiplying {0} and {1}")
    @CsvSource({
            "3+2i, 1+7i, -11+23i",
            "2, 4, 8",
            "2, 4i, 8i",
            "1+1i, 1+1i, 0+2i",
            "  3+2i, 1 +    7i,   -11 + 23i   ",
            "0+5i, 3+0i, 0+15i",
            "0+0i, -2+0i, 0+0i",
            "-3+2i, 1-7i, 11+23i",
            "2+4i, 0, 0"
    })
    public void multiply_two_complex_numbers(String complexStr1, String complexStr2, String expectedStr) {
        ComplexNumber complex1 = new ComplexNumber(complexStr1);
        ComplexNumber complex2 = new ComplexNumber(complexStr2);
        ComplexNumber expected = new ComplexNumber(expectedStr);
        ComplexNumber product = complex1.multiply(complex2);
        Assertions.assertTrue(isSame(product, expected));
    }

    @ParameterizedTest(name = "Adding {0} and {1}")
    @CsvSource({
            "3+2i, 1+7i, 4+9i",
            "2, 4, 6",
            "2, 4i, 2+4i",
            "1+1i, 1+1i, 2+2i",
            "  3+2i, 1 +    7i,   4 + 9i   ",
            "0+5i, 3+0i, 3+5i",
            "0+0i, -2+0i, -2+0i",
            "-3+2i, 1-7i, -2-5i",
            "2+4i, 0, 2+4i"
    })
    public void add_two_complex_numbers(String complexStr1, String complexStr2, String expectedStr) {
        ComplexNumber complex1 = new ComplexNumber(complexStr1);
        ComplexNumber complex2 = new ComplexNumber(complexStr2);
        ComplexNumber expected = new ComplexNumber(expectedStr);
        ComplexNumber sum = complex1.add(complex2);
        Assertions.assertTrue(isSame(sum, expected));
    }

    public boolean isSame(ComplexNumber result, ComplexNumber expected) {
        return result.real == expected.real && result.imaginary == expected.imaginary;
    }
}
