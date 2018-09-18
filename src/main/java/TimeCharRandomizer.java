public class TimeCharRandomizer {

    char castLongToChar(long l) {
        return (char) l;
    }

    public char getRandomChar(long randomLong){
        return castLongToChar(System.currentTimeMillis() + randomLong);
    }
}
