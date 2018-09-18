public class TimeCharRandomizer {

    char getRandomChar(long currentTimeMillis) {
        return (char) currentTimeMillis;
    }

    public char getRandomChar(){
        return getRandomChar(System.currentTimeMillis());
    }
}
