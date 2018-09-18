import java.util.Optional;

public class DevRandomSimulator {

    private String seed;

    public DevRandomSimulator(String seed) {
        this.seed = seed;
    }

    public void run() {
        TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        while (true) {
            System.out.print(timeCharRandomizer.getRandomChar(seed.hashCode()));
        }
    }
}
