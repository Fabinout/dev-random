public class Main {

    private static DevRandomSimulator devRandomSimulator;

    public static void main(String[] args) {
        devRandomSimulator = new DevRandomSimulator(null);
        devRandomSimulator.run('a');
    }
}
