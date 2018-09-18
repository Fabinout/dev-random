import java.util.Optional;

public class Main {

    private static final String DEFAULT_SEED = "Symbiont";

    public static void main(String[] args) {
        String seed = extractSeed(args);
        DevRandomSimulator devRandomSimulator = new DevRandomSimulator(seed);
        devRandomSimulator.run();
    }

    private static String extractSeed(String[] arg) {
        if (arg.length == 0) {
            return DEFAULT_SEED;
        }
        return arg[0];
    }
}
