public class NanoTimeCharRandomizer implements CharRandomizer {

    @Override
    public char getRandomChar(long randomLong) {
        return (char) (getJVMFreeMemory() + randomLong);
    }

    private long getJVMFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}
