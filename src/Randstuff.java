public class Randstuff {
    public static void main(String[] args) {
        String[][] manyThings = {
                {"Lego", "Door knobs", "Cheese"},
                {"Donner Kebabs", "Keyboard", "Newspaper"},
                {"Window", "Whiteboard", "RTX 4090"}
        };
        for (String[] things: manyThings){
            for (String ting: things){
                System.out.print(ting+ " ");
            }
        }
    }
}
