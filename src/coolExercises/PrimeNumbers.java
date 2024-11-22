package coolExercises;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class PrimeNumbers {
    public static int numThreads = 15; // Best on my machine, change for different CPUs
    public static long[] primeSums = new long[numThreads]; // To allow an arbitrary number of threads to return values

    public static void main(String[] args) {
        long maximum = (long) 1e6;
        long totalElapsed = 0;

        for (int i = 0; i < 10; i++) { // to run through 10 times to get an average time
            long startTime = System.currentTimeMillis();

            long result = 0;

            CountDownLatch countDownLatch = new CountDownLatch(numThreads);
            for (int threadIndex = numThreads-1; threadIndex > -1; threadIndex--){ // Starts with the biggest one
                // System.out.println(nextMulSix((j)*maximum/numThreads) + " " + nextMulSix((j + 1)*maximum/numThreads));
                PrimeSumTask task = new PrimeSumTask(countDownLatch, nextMulSix(threadIndex*maximum/numThreads),
                        nextMulSix((threadIndex+1)*maximum/numThreads)-1, threadIndex); // Makes a new runnable task

                Thread thread = new Thread(task); // Assigns the task to a thread
                thread.start(); // Starts the thread
            }
            
            try {
                countDownLatch.await(); // Waits for them to finish
                result = 5 + Arrays.stream(primeSums).sum(); // 5 because 2 and 3 are not counted
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long stopTime = System.currentTimeMillis();
            if (result != 37550402023L){ // Precalculated expected result
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
    public void run() { // This is what thread.start() calls
        PrimeNumbers.primeSums[position] = getSumOfPrimes(start, end);
        countDownLatch.countDown();
    }
    
    public static long getSumOfPrimes(long start, long maximum){
        long total = 0;
        for (long possPrime = start; possPrime <= maximum; possPrime+=6){ // Every prime is one above or one below a multiple of six
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
        while (currCheck <= max && !found) { // Again only need to check primes so only check one above and one below a multiple of six
            if (toCheck % (currCheck-1) == 0) {
                return false;
            }
            if (toCheck % (currCheck+1) == 0) {
                return false; // Ok, ik im not supposed to do this, but it is much quicker
            }
            currCheck += 6;
        }
        return toReturn;
    }
}