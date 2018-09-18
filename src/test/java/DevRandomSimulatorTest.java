import characterRandomizers.CharRandomizer;
import characterRandomizers.JVMFreeMemoryCharRandomizer;
import characterRandomizers.TimeCharRandomizer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DevRandomSimulatorTest {

    private DevRandomSimulator randomSimulator;

    private CharRandomizer randomizer1;
    private CharRandomizer randomizer2;

    @Before
    public void setUp() throws Exception {
        randomizer1 = Mockito.mock(TimeCharRandomizer.class);
        randomizer2 = Mockito.mock(JVMFreeMemoryCharRandomizer.class);
        when(randomizer1.getRandomChar(anyLong()))
                .thenReturn('ᆠ');
        when(randomizer1.getRandomChar('ᆠ'))
                .thenReturn('!');
        when(randomizer2.getRandomChar(anyLong()))
                .thenReturn('§');
        when(randomizer2.getRandomChar('§'))
                .thenReturn('°');
    }

    @Test
    public void runAFewTimes() {
        //given
        randomSimulator = new DevRandomSimulator("test seed", singletonList(randomizer1));

        //when
        randomSimulator.runAFewTimes(1000);

        //then
        verify(randomizer1, times(1000)).getRandomChar(anyLong());
    }

    @Test
    public void runAFewTimesWithDifferentRandomizers() {
        //given
        randomSimulator = new DevRandomSimulator("test seed", asList(randomizer1, randomizer2));

        //when
        randomSimulator.runAFewTimes(1000);

        //then
        verify(randomizer1, atLeast(300)).getRandomChar(anyLong());
        verify(randomizer2, atLeast(300)).getRandomChar(anyLong());
    }


    @Test
    public void selectARandomizer() {
        List<CharRandomizer> resultRandomizerList = new ArrayList<>();
        randomSimulator = new DevRandomSimulator("test seed", asList(randomizer1, randomizer2));

        try {
            for (int i = 0; i < 1000; i++) {
                CharRandomizer charRandomizer = randomSimulator.selectARandomizer("" + i);
                resultRandomizerList.add(charRandomizer);
            }
            long numberOfRandomizer1 = resultRandomizerList.stream()
                    .filter(charRandomizer -> charRandomizer instanceof TimeCharRandomizer)
                    .count();
            assertThat(numberOfRandomizer1).isGreaterThan(300);
            long numberOfRandomizer2 = resultRandomizerList.stream()
                    .filter(charRandomizer -> charRandomizer instanceof JVMFreeMemoryCharRandomizer)
                    .count();
            assertThat(numberOfRandomizer2).isGreaterThan(300);
        } catch (Exception e) {
            fail();
        }
    }
}