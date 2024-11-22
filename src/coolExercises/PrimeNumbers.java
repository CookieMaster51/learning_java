package coolExercises;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class PrimeNumbers {
    public static int numThreads = 15;
    public static long[] primeSums = new long[numThreads];
    public static void main(String[] args) {
        long maximum = (long) 1e6; // Change this for testing
        long totalElapsed = 0;
        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            long result = 0;

            CountDownLatch countDownLatch = new CountDownLatch(numThreads);
            for (int j = numThreads-1; j > -1; j--){
                // System.out.println(nextMulSix((j)*maximum/numThreads) + " " + nextMulSix((j + 1)*maximum/numThreads));
                PrimeSumTask task = new PrimeSumTask(countDownLatch, nextMulSix(j*maximum/numThreads),
                        nextMulSix((j+1)*maximum/numThreads)-1, j);
                Thread thread = new Thread(task);
                thread.start();
            }
            
            try {
                countDownLatch.await();
                result = 5 + Arrays.stream(primeSums).sum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long stopTime = System.currentTimeMillis();
            if (result != 37550402023L){
                System.out.println("FAIL");
            }
            long elapsed = stopTime - startTime;
            totalElapsed += elapsed;
        }
        long elapsed = totalElapsed / 10;
        System.out.printf("The function took %d milliseconds", elapsed);
    }


    public static long nextMulSix(long maximum){
        return (maximum + 6 - (maximum % 6));
    }
}

class PrimeSumTask implements Runnable{
    CountDownLatch countDownLatch;
    long start;
    long end;
    int position;
    
    public PrimeSumTask(CountDownLatch countDownLatch, long start, long end, int position){
        this.countDownLatch = countDownLatch;
        this.start = start;
        this.end = end;
        this.position = position;
    }

    @Override
    public void run() {
        PrimeNumbers.primeSums[position] = getSumOfPrimes(start, end);
        countDownLatch.countDown();
    }
    
    public static long getSumOfPrimes(long start, long maximum){
        long total = 0;
        for (long possPrime = start; possPrime <= maximum; possPrime+=6){
            if(isPrime(possPrime - 1)){
                total += possPrime-1;
            }
            if (isPrime(possPrime + 1)){
                total += possPrime+1;
            }
        }
        return total;
    }
    public static boolean isPrime(long toCheck) {
        boolean toReturn = true;
        long max = (long) Math.sqrt(toCheck) + 1;
        long currCheck = 6;
        boolean found = false;
        while (currCheck <= max && !found) {
            if (toCheck % (currCheck-1) == 0) {
                return false;
            }
            if (toCheck % (currCheck+1) == 0) {
                return false;
            }
            currCheck += 6;
        }
        return toReturn;
    }
}