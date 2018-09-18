import org.junit.Test;

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
    public void testRandomCharsWithSpecificTimeMillis() {
        char pseudoRandomChar = timeCharRandomizer.getRandomChar(10l);
        assertThat(pseudoRandomChar).isEqualTo('\n');
    }
}