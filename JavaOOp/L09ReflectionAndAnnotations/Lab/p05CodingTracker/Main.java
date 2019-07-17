package JavaOOP.L09ReflectionAndAnnotations.Lab.p05CodingTracker;

public class Main {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
