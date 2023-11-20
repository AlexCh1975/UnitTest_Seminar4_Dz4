package third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.coverage.SomeService;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp(){
        someService = new SomeService();
    }

    //3.1
    @Test
    void testReturnFizz(){
        assertEquals("Fizz", someService.fizzBuzz(3));
    }

    @Test
    void testReturnBuzz(){
        assertEquals("Buzz", someService.fizzBuzz(5));
    }

    @Test
    void testReturnFizzBuzz(){
        assertEquals("FizzBuzz", someService.fizzBuzz(15));
    }

    @Test
    void testReturnValue(){
        assertEquals("11", someService.fizzBuzz(11));
    }

    //3.2
    /**
     * Разработайте тесты для метода firstLast6, где на вход подается массив чисел,
     * а метод
     * возвращает true, если первое или последнее число в массиве равно 6, иначе false.
     */
    @Test
    void testFirstLast6(){
        assertTrue(someService.firstLast6(new int[] {6, 7, 9, 6}));
    }

    @ParameterizedTest
    @CsvSource({
            "2000.0, 50, 1000",
            "2000, 100, 0",
            "2000, 0, 2000"
    })
    void calculatingDiscountPositiveCase(double amount, int discount, double result){
        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(result);
    }


    @Test
    void insufficientCoverageTest(){

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0

        assertThatThrownBy(() ->
                someService.calculatingDiscount(-2222, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    //3.4
    @Test
    void sumCorrect(){
        assertEquals(6, someService.luckySum(1, 2, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "13, 1, 3",
            "1, 13, 3",
            "1, 3, 13"
    })
    void sum(int a, int b, int c){
        assertEquals(4, someService.luckySum(a, b, c));
    }



}