import java.util.Optional;

public class DevRandomSimulator {
    private String seed;

    public DevRandomSimulator(String seed) {
        this.seed = Optional.ofNullable(seed)
                .orElse("Symbiont");
    }

    public void run(char a) {

    }
}
