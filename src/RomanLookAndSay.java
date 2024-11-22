import java.util.Scanner;

public class RomanLookAndSay {
    public static final String[] romanLetters = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String romanToDo = scanner.nextLine();
        System.out.println(lookAndSay(lookAndSay("MMXX")));

    }
    public static String lookAndSay(String romanToDo){
        String out = "";
        char prevLetter = romanToDo.charAt(0);
        int prevCount = 0;
        for (int index = 1; index < romanToDo.length(); index++){
            if (prevLetter == romanToDo.charAt(index)){
                prevCount ++;
            } else {
                out += romanLetters[prevCount] + prevLetter;
                prevCount = 0;
                prevLetter = romanToDo.charAt(index);
            }
        }
        out += romanLetters[prevCount] + prevLetter;
        return out;
    }
}
