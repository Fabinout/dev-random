import characterRandomizers.CharRandomizer;
import characterRandomizers.JVMFreeMemoryCharRandomizer;
import characterRandomizers.TimeCharRandomizer;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DevRandomSimulatorTest {

    private DevRandomSimulator randomSimulator;

    private CharRandomizer randomizer1;
    private CharRandomizer randomizer2;

    @Test
    public void runAFewTimes() {
        //given
        randomizer1 = Mockito.mock(TimeCharRandomizer.class);
        when(randomizer1.getRandomChar(anyLong()))
                .thenReturn('ᆠ');
        randomSimulator = new DevRandomSimulator("test seed", singletonList(randomizer1));

        //when
        randomSimulator.runAFewTimes(1000);

        //then
        verify(randomizer1, times(1000)).getRandomChar(anyLong());
    }

    @Test
    public void runAFewTimesWithDifferentRandomizers() {
        //given
        randomizer1 = Mockito.mock(TimeCharRandomizer.class);
        randomizer2 = Mockito.mock(JVMFreeMemoryCharRandomizer.class);
        when(randomizer1.getRandomChar(anyLong()))
                .thenReturn('ᆠ');
        when(randomizer2.getRandomChar(anyLong()))
                .thenReturn('§');

        randomSimulator = new DevRandomSimulator("test seed", asList(randomizer1, randomizer2));

        //when
        randomSimulator.runAFewTimes(1000);

        //then
        verify(randomizer1, atLeast(300)).getRandomChar(anyLong());
        verify(randomizer2, atLeast(300)).getRandomChar(anyLong());
    }
}