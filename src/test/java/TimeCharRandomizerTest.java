import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TimeCharRandomizerTest {

    private TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();

    @Test
    public void testRandomChars() {
        for (int i = 0; i < 100; i++) {
            char randomChar = timeCharRandomizer.getRandomChar();
            System.out.println("randomChar " + i + " = " + randomChar);
        }
    }

    @Test
    public void testRandomIsNotAlwaysTheSame() {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add(timeCharRandomizer.getRandomChar());
        }
        assertThat(results.stream().distinct().count()).isGreaterThan(80);
    }


    @Test
    public void testRandomCharsWithSpecificTimeMillis() {
        char pseudoRandomChar = timeCharRandomizer.getRandomChar(10l);
        assertThat(pseudoRandomChar).isEqualTo('\n');
    }
}