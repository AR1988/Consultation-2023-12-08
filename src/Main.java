import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Andrej Reutow
 * created on 08.12.2023
 */
public class Main {

    private final static String text = """ 
            Типы web storages Веб хранилища в браузерах реализованы в виде LocalStorage F
            """;

    public static void main(String[] args) {
        List<String> words = Arrays.stream(text.split(" "))
                .filter(word -> word.matches("[a-zA-Zа-яА-Я]*"))
                .collect(Collectors.toList());

        Map<String, Integer> counterWords = new HashMap<>();

        for (String word : words) {
            if (counterWords.containsKey(word)) {
                counterWords.put(word, counterWords.get(word) + 1);
            } else {
                counterWords.put(word, 1);
            }
        }

        int max = 0;
        String wordMaxRes = "";
        for (Map.Entry<String, Integer> entry : counterWords.entrySet()) {
            String word = entry.getKey();
            int counter = entry.getValue();
            if (counter > max) {
                max = counter;
                wordMaxRes = word;
            }
        }
        System.out.println(wordMaxRes);

        int maxCharters = 1;
        String wordMaxCharters = null;
        for (Map.Entry<String, Integer> entry : counterWords.entrySet()) {
            String word = entry.getKey();
            if (word.length() > maxCharters) {
                maxCharters = word.length();
                wordMaxCharters = word;
            }
        }

        System.out.println(maxCharters);
        System.out.println(wordMaxCharters);

        int maxWordL = words.stream().mapToInt(String::length).max().orElse(0);
        System.out.println(maxWordL);
    }
}
