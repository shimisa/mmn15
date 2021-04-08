/**
 * The Main class starts the threads and execute the general algo
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */

public class Main {

    public static void main(String [] args){
        /**
         * @param N the Max number
         * @param T the Max active threads
         * @param c the Controller for managing the threads
         */
        final int N = 100, T = 100;

        Controller c = new Controller(T, N);
        /**
         *The general algorithm
         */
        for(int i = 1 ; i <= N ; i++){
            c.waitForThread();
            (new PrimeThread(i, c)).start();
        }
        c.waitForAll();
        System.out.println(c.printResults());
    }

}
