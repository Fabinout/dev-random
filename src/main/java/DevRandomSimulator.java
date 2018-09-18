import java.util.Optional;

public class DevRandomSimulator {

    private String seed;

    public DevRandomSimulator(String seed) {
        this.seed = Optional.ofNullable(seed)
                .orElse("Symbiont");
    }

    public void run(char a) {
        TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        while (true) {
            System.out.print(timeCharRandomizer.getRandomChar());

        }
    }
}
