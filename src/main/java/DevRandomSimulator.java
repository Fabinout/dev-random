import java.util.ArrayList;
import java.util.List;

public class DevRandomSimulator {

    private String seed;

    public DevRandomSimulator(String seed) {
        this.seed = seed;
    }

    public void run() {
        CharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        while (true) {
            char randomChar = timeCharRandomizer.getRandomChar(seed.hashCode());
            System.out.print(randomChar);
            seed = String.valueOf(randomChar);
        }
    }

    public void runAFewTimes(int numberOfOutputs) {
        List<Character> results = new ArrayList<>();
        CharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        for (int i = 0; i < numberOfOutputs; i++) {
            char randomChar = timeCharRandomizer.getRandomChar(seed.hashCode());
            System.out.print(randomChar);
            seed = String.valueOf(randomChar);
            results.add(randomChar);
        }

        System.out.println("Results of all generated Numbers:");
        System.out.println(numberOfDifferentValues(results, numberOfOutputs));

    }

    private String numberOfDifferentValues(List<Character> results, int numberOfOutputs) {
        return String.format("\t Distinct values : %s out of %s", results.stream().distinct().count(), numberOfOutputs);
    }
}
