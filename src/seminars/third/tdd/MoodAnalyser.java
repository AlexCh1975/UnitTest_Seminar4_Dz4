package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.toLowerCase().contains("good")) return "Happy!";
        if (message.toLowerCase().contains("bad")) return "Unhappy!";
        return "Norm!";
    }

}