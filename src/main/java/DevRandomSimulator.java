public class DevRandomSimulator {

    private String seed;

    public DevRandomSimulator(String seed) {
        this.seed = seed;
    }

    public void run() {
        TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        while (true) {
            char randomChar = timeCharRandomizer.getRandomChar(seed.hashCode());
            System.out.print(randomChar);
            seed = String.valueOf(randomChar);
        }
    }

    public void runAFewTimes() {
        TimeCharRandomizer timeCharRandomizer = new TimeCharRandomizer();
        for (int i = 0; i < 1000; i++) {
            char randomChar = timeCharRandomizer.getRandomChar(seed.hashCode());
            System.out.print(randomChar);
            seed = String.valueOf(randomChar);
        }
    }
}
