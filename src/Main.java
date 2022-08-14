import java.util.HashMap;
import java.util.Map;

public class Main {
    private static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> mapCounter = new HashMap<>();

        String loremIpsumLowCase = loremIpsum.toLowerCase();

        Character currentChar;
        for(int i = 0; i < loremIpsumLowCase.length(); i++){
            currentChar = loremIpsumLowCase.charAt(i);

            if(currentChar == ' ') continue;

            if(mapCounter.containsKey(currentChar)){
                mapCounter.put(currentChar, mapCounter.get(currentChar) + 1);
            } else {
                mapCounter.put(currentChar, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = -1;
        char minChar = ' ';
        char maxChar = ' ';

        for(Map.Entry<Character, Integer> entry : mapCounter.entrySet()){
            if(entry.getValue() > max){
                maxChar = entry.getKey();
                max = entry.getValue();
            }

            if(entry.getValue() < min){
                minChar = entry.getKey();
                min = entry.getValue();
            }
        }

        System.out.println("Минимально встречается символ: " + minChar + " (" + min + " раз(-а))");
        System.out.println("Максимально часто встречается символ: " + maxChar + " (" + max + " раз(-а))");
    }
}
