import java.util.Scanner;

public class MakeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First word:");
        int[] toMake = countLetters(scanner.nextLine());
        System.out.println("Second word:");
        int[] letterBank = countLetters(scanner.nextLine());

        boolean valid = true;
        for (int index = 0; index < 26; index ++){
            if (toMake[index] > letterBank[index]){
                valid = false;
            }
        }

        if (valid) {
            System.out.println("Can be created");
        } else {
            System.out.println("Cannot be created");
        }
    }
    public static int[] countLetters(String word){
        int[] counts = new int[26];
        word = word.toLowerCase();
        for (int index = 0; index < word.length(); index++){
            char letter = word.charAt(index);
            counts[(int)letter-97] ++;
        }
        return counts;
    }
}
