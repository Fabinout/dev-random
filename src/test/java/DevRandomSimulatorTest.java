import characterRandomizers.TimeCharRandomizer;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DevRandomSimulatorTest {

    private DevRandomSimulator randomSimulator;
    private TimeCharRandomizer randomizer;


    @Test
    public void runAFewTimes() {
        //given
        randomizer = Mockito.mock(TimeCharRandomizer.class);
        Random random = new Random(89l);
        when(randomizer.getRandomChar(anyLong()))
                .thenReturn('ᆠ');
        randomSimulator = new DevRandomSimulator("test seed", randomizer);

        //when
        randomSimulator.runAFewTimes(1000);

        //then
        verify(randomizer, times(1000)).getRandomChar(anyLong());
    }
}