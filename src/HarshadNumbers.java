import java.util.Scanner;

public class HarshadNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What Harshad number do you want?");
        int goTo = Integer.parseInt(scanner.nextLine());
        int numFound = 0;
        int result = 0;
        int index = 1;
        while (numFound < goTo) {
            if (isHarshad(index)){
                numFound ++;
                result = index;
            }
            index ++;
        }
        System.out.println(result);
    }
    public static boolean isHarshad(int num){
        char[] numCharArray = String.valueOf(num).toCharArray();
        int total = 0;
        for (char digit: numCharArray){
            total += Integer.parseInt(String.valueOf(digit));
        }
        if (num % total == 0){
            return true;
        } else {
            return false;
        }
    }
}
