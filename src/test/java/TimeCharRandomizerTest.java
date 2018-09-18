import org.junit.Test;

import static org.junit.Assert.*;

public class TimeCharRandomizerTest {

    @Test
    public void testRandomChars() {
        TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        for (int i = 0; i < 100; i++) {
            char randomChar = timeCharRandomizer.getRandomChar();
            System.out.println("randomChar " + i + " = " + randomChar);
        }
    }
}