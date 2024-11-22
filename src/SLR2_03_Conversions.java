import java.util.Scanner;
public class SLR2_03_Conversions {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 3) {
            choice = choiceMenu();
            switch(choice){
                case 1:
                    System.out.print("Enter amount in cm ");
                    double cm = Float.parseFloat(myScanner.nextLine());
                    cmToIn(cm);
                    break;
                case 2:
                    System.out.print("Enter amount in inches ");
                    double inches = Float.parseFloat(myScanner.nextLine());
                    inToCm(inches);
                    break;
            }
        }

    }
    public static int choiceMenu(){
        System.out.println("1. cm to inches");
        System.out.println("2. inches to cm");
        System.out.println("3. Quit");
        int choice = 0;
        while (choice < 1 || choice > 3)  {
            System.out.print("? ");
            choice = Integer.parseInt(myScanner.nextLine());
        }
        return choice;
    }
    public  static void cmToIn(double cm){
        double inches = cm / 2.54;
        System.out.println(cm + " cm is " + inches + " inches");
    }
    public  static void inToCm(double in){
        double cm = in * 2.54;
        System.out.println(in + " inches is " + cm + " cm");
    }
}
