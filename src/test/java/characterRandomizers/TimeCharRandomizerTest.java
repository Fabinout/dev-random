package characterRandomizers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TimeCharRandomizerTest {

    private TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();

    @Test
    public void testRandomChars() {
        for (int i = 0; i < 100; i++) {
            char randomChar = timeCharRandomizer.getRandomChar(0l);
            System.out.println("randomChar " + i + " = " + randomChar);
        }
    }

    @Test
    public void testRandomCharsWithSpecificTimeMillis() {
        char pseudoRandomChar = timeCharRandomizer.castLongToChar(10l);
        assertThat(pseudoRandomChar).isEqualTo('\n');
    }

    @Test
    public void testRandomIsNotAlwaysTheSame() {
        List<Character> results = new ArrayList<>();
        char previousValue = 'a';
        for (int i = 0; i < 100; i++) {
            char randomChar = timeCharRandomizer.getRandomChar((previousValue));
            results.add(randomChar);
            previousValue = randomChar;
        }
        assertThat(results.stream().distinct().count()).isGreaterThan(80);
    }

}