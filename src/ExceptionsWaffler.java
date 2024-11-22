import java.util.Scanner;

import static java.lang.Float.NaN;

public class ExceptionsWaffler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter a second number");
            num2 = Integer.parseInt(scanner.nextLine());
            float result = (float)num1/(float)num2;
            if (Float.isNaN(result)) {
                throw new ArithmeticException();
            }
            System.out.println(result);
        } catch (NumberFormatException exception) {
            System.out.println("ONE OF THOSE WAZ NOT A NUMBER");
        } catch (ArithmeticException exception){
            System.out.println("Divisor was 0");
        }
    }
}
