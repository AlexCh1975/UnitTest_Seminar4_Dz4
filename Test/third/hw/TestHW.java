package third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.hw.MainHW;

import static org.junit.jupiter.api.Assertions.*;

public class TestHW {
    private MainHW mainHW;

    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }

    /**
     *  hw 3.1  Напишите тесты, покрывающие на 100% метод evenOddNumber, который
     *  проверяет, является ли
     * переданное число четным или нечетным:
     */
    @Test
    void testEventOddNumberReturnTrue(){
        assertTrue(mainHW.eventOddNumber(2));
    }

    @Test
    void testEventOddNumberReturnFalse(){
        assertFalse(mainHW.eventOddNumber(3));
    }

    /**
     *  hw 3.2 Разработайте и протестируйте метод numberInInterval, который проверяет,
     *  попадает ли
     * переданное число в интервал (25;100)
     */
    @Test
    void testIsTheNumberInTheRange(){
        assertTrue(mainHW.numberInInterval(50));
    }

    @ParameterizedTest
    @CsvSource({
            "24",
            "101"
    })
    void teatNumberIsLessThanInterval(int n){
        assertFalse(mainHW.numberInInterval(n));
    }
}
