package coolExercises;

import java.util.Scanner;

public class ISBNWaffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] isbn = new int[13];
        for (int i = 0; i < 13; i++){
            isbn[i] = Integer.parseInt(scanner.nextLine());
        }
        int calcDigit = 0;
        int count = 0;
        while (count < 12){
            calcDigit += isbn[count];
            count += 1;
            calcDigit += isbn[count] * 3;
            count += 1;
        }
        while (calcDigit >= 10) {
            calcDigit = calcDigit - 10;
        }
        calcDigit = 10 - calcDigit;
        if (calcDigit == 10){
            calcDigit = 0;
        }
        if(calcDigit == isbn[12]){
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }
    }
}
