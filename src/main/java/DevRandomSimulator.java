import characterRandomizers.CharRandomizer;

import java.util.ArrayList;
import java.util.List;

public class DevRandomSimulator {

    private String seed;
    private List<CharRandomizer> charRandomizers;

    public DevRandomSimulator(String seed, List<CharRandomizer> randomizers) {
        this.seed = seed;
        charRandomizers = randomizers;
    }

    void run() {
        while (true) {
            char randomChar = printRandomValues();
        }
    }

    private char printRandomValues() {
        char randomChar = charRandomizers.get(0).getRandomChar(seed.hashCode());
        System.out.print(randomChar);
        seed = String.valueOf(randomChar);
        return randomChar;
    }


    void runAFewTimes(int numberOfOutputs) {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < numberOfOutputs; i++) {
            char randomChar = printRandomValues();
            results.add(randomChar);
        }
        System.out.println("Results of all generated Numbers:");
        System.out.println(numberOfDifferentValues(results, numberOfOutputs));
    }

    private String numberOfDifferentValues(List<Character> results, int numberOfOutputs) {
        return String.format("\t Distinct values : %s out of %s", results.stream().distinct().count(), numberOfOutputs);
    }
}
