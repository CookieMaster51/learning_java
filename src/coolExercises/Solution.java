package coolExercises;

public class Solution {
    public static void main(String args[] ) throws Exception {
        int total = 0;
        for(int number = 2; number < 10000; number ++){
            if(isAmicable(number)){
                total += number;
                System.out.println(number);
            }
        }
        System.out.println(total);
    }


    public static boolean isAmicable(int number){
        int possPair = divisorSum(number);
        if (possPair == number){
            return false;
        } else if (divisorSum(possPair) == number){
            return true;
        } else {
            return false;
        }
    }

    public static int divisorSum (int number){
        int total = 0;
        for (int possDiv = 1; possDiv < number; possDiv++){
            if (number % possDiv == 0){
                total += possDiv;
            }
        }
        return total;
    }
}