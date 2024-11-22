package oldExecrises;

public class PassByReference {
    public static void main(String[] args) {
        int numberMain = 30;
        doStuff(numberMain);
        System.out.println(numberMain);
    }
    public static void doStuff (int number) {
        number += 10;
    }
}
