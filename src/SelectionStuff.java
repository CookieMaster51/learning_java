public class SelectionStuff {
    private enum Names {
        JAN,
        TOBY,
        RORY
    }

    public static void main(String[] args) {
        Names name1 = Names.JAN;

        if (name1 == Names.JAN) {
            System.out.println("Hello");
        } else if (name1 == Names.TOBY) {
            System.out.println("Why are you here?");
        }
    }
}
