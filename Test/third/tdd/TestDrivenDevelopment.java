package third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.MoodAnalyser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.coverage.SomeService;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDrivenDevelopment {
    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp(){
        moodAnalyser = new MoodAnalyser();
    }

    //3.5. Red-Green-Refactor
    @Test
    void goodMood(){
        assertEquals("Happy!", moodAnalyser.analyseMood("Good Day!"));
    }

    @Test
    void badMood(){
        assertEquals("Unhappy!", moodAnalyser.analyseMood("Bad Day!"));
    }

    @Test
    void normalMood(){
        assertEquals("Norm!", moodAnalyser.analyseMood("Normal Day!"));
    }
}