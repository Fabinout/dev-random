public class TimeCharRandomizer {

    char getRandomCharWithTime(long currentTimeMillis) {
        return (char) currentTimeMillis;
    }

    public char getRandomChar(long randomLong){
        return getRandomCharWithTime(System.currentTimeMillis() + randomLong);
    }
}
