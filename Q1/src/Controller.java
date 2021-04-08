/**
 * The Controller class take care of the control of the synchronization of the threads, the max threads allowed
 * and the results
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 */

public class Controller {
    private final int maxThreads;
    private int activeTreads, currentNumbers;
    private boolean numbers[];

    /**
     * constructor for building the controller shared source
     * @param max The maximum number of threads on air
     * @param totalNumbers The total number for checking the primes until him
     */
    public Controller(int max, int totalNumbers) {
        maxThreads = max;
        activeTreads = currentNumbers = 0;
        numbers = new boolean[totalNumbers + 1];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = false;
    }

    /**
     * method to manage the maximum threads in parallel
     */
    public synchronized void waitForThread(){
        while (activeTreads == maxThreads) {
            try {
                wait();
            }
            catch (InterruptedException e){}
        }
        activeTreads++;
    }

    /**
     * method for waiting till all the results are ready
     */
    public synchronized void waitForAll(){
        while (currentNumbers < numbers.length - 2){
            try {
                wait();
            }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    /**
     * method for updating when a thread finish his work
     */
    public synchronized void finished(){
        activeTreads--;
        currentNumbers++;
        notifyAll();
    }

    /**
     * method for printing the results
     * @return String of the results
     */
    public synchronized String printResults(){
        String res = "";
        for (int i = 2 ; i < numbers.length ; i++) {
            if (numbers[i])
                res += i + " ";
        }
        return res;
    }

    /**
     * method for updating the results array
     * @param num the number that appeared to be a prime number
     */
    public synchronized void itsPrime(int num){
        numbers[num] = true;
    }

}
