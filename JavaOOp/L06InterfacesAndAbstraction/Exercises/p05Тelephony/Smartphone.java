package JavaOOP.L06InterfacesAndAbstraction.Exercises.p05Тelephony;

import java.util.List;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : this.urls) {
            try {
                if (url.chars().anyMatch(Character::isDigit)||url.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid URL!");
                }
                result.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }catch (IllegalArgumentException str){
                result.append(str.getMessage()).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String numb : this.numbers) {
            try {
                if (numb.chars().anyMatch(Character::isAlphabetic)||numb.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid number!");
                }
                result.append("Calling... ").append(numb).append(System.lineSeparator());
            }catch (IllegalArgumentException str){
                result.append(str.getMessage()).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }
}
