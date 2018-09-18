import org.junit.Test;

public class DevRandomSimulatorTest {

    private DevRandomSimulator randomSimulator;


    @Test
    public void runAFewTimes() {
        randomSimulator = new DevRandomSimulator("lkjdsqfli");
        randomSimulator.runAFewTimes(1000);
    }
}